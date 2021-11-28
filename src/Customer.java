import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName,lastName;
    private long pNR;
    private List<Account> accounts;

    public Customer(String firstName, String lastName, long pNR) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pNR = pNR;
        this.accounts = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getpNR() {
        return pNR;
    }

    public void setpNR(long pNR) {
        this.pNR = pNR;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public long addAccount(String type, float interestRate){
        Account account = new Account(type, interestRate);

        long nextAccountNr = 1000;
        for (Account value : accounts) {
            if (nextAccountNr < value.getAccountNr()) {
                nextAccountNr = value.getAccountNr();
            }
        }
        nextAccountNr += 1;
        account.createAccountNr(nextAccountNr);

        accounts.add(account);

        return nextAccountNr;
    }


    public void presetAccount(long accountNr, float balance, String type, float interestRate){
        Account account = new Account(type, interestRate, accountNr, balance);

        accounts.add(account);

    }

    public void deleteAccount(long accountNr){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNr() == accountNr){
                accounts.remove(i);
                break;
            }
        }
    }
}
