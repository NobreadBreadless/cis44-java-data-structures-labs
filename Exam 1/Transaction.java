class Transaction {
    private String transactionId;
    private double amount;

    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "ID: " + transactionId + ", Amount: " + amount;
    }
}