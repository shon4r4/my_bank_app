public class Account {
    private float balance;
    float interestRate;
    private long accountNr;
    private String type;


    //this constructor is only used when reading information about the accounts from a file
    public Account(String type, float interestRate, long accountNr, float balance) {
        this.type = type;
        this.interestRate = interestRate;
        this.accountNr = accountNr;
        this.balance = balance;
    }
    public Account(String type, float interestRate) {
        this.type = type;
        this.interestRate = interestRate;
    }

    public void createAccountNr(long accountNr) {
        this.accountNr = accountNr;
    }
    public long getAccountNr() {
        return accountNr;
    }
    public String getType() {
        return type;
    }
    public float getInterestRate(){
        return interestRate;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
    public boolean withdraw(float amount) {
        if (amount >= balance) this.balance -= amount;
        return (amount >= balance);
    }
    public float getBalance() {
        return balance;
    }
}
