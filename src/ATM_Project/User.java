package ATM_Project;

public class User {
    private int userId;
    private String userName;
    private int accountBalance;
    private String userPin;

    public User(int userId, String userName, int accountBalance, String userPin) {
        this.userId = userId;
        this.userName = userName;
        this.accountBalance = accountBalance;
        this.userPin = userPin;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public String getUserPin() {
        return userPin;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", accountHolderName='" + userName + '\'' +
                ", userEmail='" + accountBalance + '\'' +
                ", userPin='" + userPin + '\'' +
                '}';
    }
}
