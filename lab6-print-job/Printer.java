// You will need a functioning Queue implementation (like LinkedQueue) for this to work.
// interface Queue { ... }
// class LinkedQueue implements Queue { ... }

/**
 * Represents a single document to be printed.
 */
class PrintJob {
    private String documentName;
    private int pageCount;

    // TODO: Implement the constructor
    public PrintJob(String documentName, int pageCount) {
        // Your code here
        this.documentName = documentName;
        this.pageCount = pageCount;
    }

    // TODO: Implement the toString method to return a descriptive string
    // e.g., "PrintJob[Document: report.docx, Pages: 15]"
    @Override
    public String toString() {
        return "Print Job[Document: " + documentName + "\nPages: " + pageCount; // Placeholder
    }
}

/**
 * Simulates a printer that manages a queue of print jobs.
 */
public class Printer {
    private Queue<PrintJob> jobQueue;

    public Printer() {
        // TODO: Initialize the jobQueue with a LinkedQueue
        jobQueue = new LinkedQueue<>(); // Placeholder
    }

    /**
     * Adds a new print job to the rear of the queue.
     * @param job The print job to add.
     */
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        // TODO: Enqueue the job
        jobQueue.enqueue(job);
    }

    /**
     * Processes the job at the front of the queue.
     */
    public void processNextJob() {
    if (jobQueue.isEmpty()) {
        System.out.println("Queue is currently empty");
    } else {
        PrintJob job = jobQueue.dequeue();
        System.out.println("Processing: " + job);
    }
}

    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}