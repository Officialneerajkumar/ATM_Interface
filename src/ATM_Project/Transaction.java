package ATM_Project;

public class Transaction {
    private int transactionId;
    private String transactionName;
    private int transactionAmount;
    private String status;

    public Transaction() {
    }

    public Transaction(int transactionId, String transactionName, int transactionAmount, String status) {
        this.transactionId = transactionId;
        this.transactionName = transactionName;
        this.transactionAmount = transactionAmount;
        this.status = status;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionName='" + transactionName + '\'' +
                ", transactionAmount='" + transactionAmount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
