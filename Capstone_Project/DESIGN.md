# DESIGN.md — Hospital Emergency Room Triage System (Option B)

Phase 1

---

## 1. UML Class Diagram

```
+------------------+                    +------------------+
|     Patient      |                    |  EmergencyRoom   |
+------------------+                    +------------------+
| - patientId: String                 | - triageQueue: PriorityQueue<Patient> |
| - name: String                       | - patientRegistry: HashMap<String, Patient> |
| - severity: int                       +-------------------------------------+
| - arrivalTimestamp: long             | + addPatient(Patient): void          |
| - ageCount: int                       | + processNextPatient(): Patient      |
+------------------+                    | + ageRule(long): void                |
| + getPatientId(): String             +-------------------------------------+
| + getName(): String                 |
| + getSeverity(): int                 |
| + getArrivalTimestamp(): long        |
| + getAgeCount(): int                 |
| + setSeverity(int): void             |
| + setAgeCount(int): void             |
| + compareTo(Patient): int            |
| + toString(): String                 |
+-------------------------------------+

Relationships:
  EmergencyRoom 1 ---> * Patient
    (manages patients in the triage queue and registry)

  EmergencyRoom 1 ---> * Patient
    (registry provides O(1) lookup by patientId)
```

### Class Details

#### `Patient`
- **Fields:**
  - `patientId: String` — unique identifier
  - `name: String` — patient name
  - `severity: int` — triage severity (1 = Critical, 5 = Mild)
  - `arrivalTimestamp: long` — time of arrival (used for FIFO tie-breaking)
  - `ageCount: int` — number of times the patient's priority has been bumped by the aging rule
- **Methods:**
  - `getPatientId()`, `getName()`, `getSeverity()`, `getArrivalTimestamp()`, `getAgeCount()`
  - `setSeverity(int)`, `setAgeCount(int)`
  - `compareTo(Patient other): int` — ordering logic (see below)
  - `toString(): String` — descriptive representation
- Implements: `Comparable<Patient>`

#### `EmergencyRoom`
- **Fields:**
  - `triageQueue: PriorityQueue<Patient>` — orders patients by severity, then arrival time, then age bumps
  - `patientRegistry: HashMap<String, Patient>` — O(1) lookup of active patients by `patientId`
- **Methods:**
  - `addPatient(Patient p): void` — registers the patient and enqueues them
  - `processNextPatient(): Patient` — dequeues the highest-priority patient and removes them from the registry
  - `ageRule(long targetWaitThreshold): void` — bumps priority tiers for patients waiting past the threshold

---

## 2. Data Structure Selection

| Collection | Why It Was Chosen |
|---|---|
| `PriorityQueue<Patient>` | The core of the system. `PriorityQueue` is a min-heap by default, so we order patients by severity first, then arrival time (FIFO for tie-breaker), then age bumps. This gives O(log n) for enqueue & dequeue — exactly what an ER needs for always treating the most critical patient first. |
| `HashMap<String, Patient>` | Provides O(1) average lookup of an active patient by `patientId`. Needed so aging rule can quickly find and update a specific patient's priority without scanning the whole queue. |
| `ArrayList<Patient>` | Used internally to snapshot patients for the aging rule scan, or to store processed patient history. |

### Ordering Logic (`Patient.compareTo`)

```java
// Lower severity number = higher priority (1 = Critical, 5 = Mild)
if (this.severity != other.severity) {
    return Integer.compare(this.severity, other.severity); // low severity 1st
}
if (this.arrivalTimestamp != other.arrivalTimestamp) {
    return Long.compare(this.arrivalTimestamp, other.arrivalTimestamp); // earlier arrival 1st
}
return Integer.compare(this.ageCount, other.ageCount); // more age bumps 1st
```

Ensures the `PriorityQueue` always surfaces the most critical, longest-waiting patient.

---

## 3. Big-O Expectations

| Operation | Time Complexity | Justification |
|---|---|---|
| `addPatient(p)` | **O(log n)** | `PriorityQueue.add()` is O(log n); `HashMap.put()` is O(1) amortized |
| `processNextPatient()` | **O(log n)** | `PriorityQueue.poll()` is O(log n); `HashMap.remove()` is O(1) |
| `ageRule(threshold)` | **O(n)** | Must scan all patients in the queue to check wait times; each priority bump is O(log n) |
| Patient lookup by ID | **O(1)** average | Direct `HashMap.get()` |

Where `n` = number of patients currently in the triage queue.

---

## 4. Domain Rules

1. **Severity scale:** 1 = Critical, 2 = Very Urgent, 3 = Urgent, 4 = Less Urgent, 5 = Mild.
2. **Tie-breaker:** If same severity, earlier arrival time goes first.
3. **Aging rule:** If a patient has waited past `targetWaitThreshold` (in ms), their priority tier is bumped (severity decreased by 1, maxed at 1) and `ageCount` is incremented. This prevents starvation of critical patients.
4. **No duplicate IDs:** `patientId` must be UNIQUE in the registry.