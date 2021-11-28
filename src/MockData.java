import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MockData {
    public static Collection<Customer> Customers = new ArrayList<>();

    public static void loadCustomerAndAccounts(){
        var c1 = new Customer("Kalle", "Anka", 11112222);
        var c2 = new Customer("Joakim", "vonAnka", 11113333);
        var c3 = new Customer("Janne", "Långben", 11114444);


        c1.addAccount("credit",1.4F);
        c1.addAccount("credit",1.45F);
        c1.addAccount("credit",1.46F);

        c2.addAccount("credit",1.5F);


        c3.addAccount("credit",1.8F);

        List<Customer> customers = new ArrayList<>(Arrays.asList(c1,c2,c3));

        Customers.addAll(customers);

    }

    public static Bank initiateMymockMyData(Bank b1){
        //Creating a mocked datafile
        MockData.loadCustomerAndAccounts();
        var Customer = MockData.Customers;

        for(var customer : Customer){
            b1.addCustomer(customer.getFirstName(), customer.getLastName(), customer.getpNR());
            int amount = 2;
            for (int i = 0; i < customer.getAccounts().size(); i++) {
                b1.addAccount(
                        customer.getpNR(),
                        customer.getAccounts().get(i).getType(),
                        customer.getAccounts().get(i).getInterestRate());

                b1.deposit(customer.getpNR(),
                        customer.getAccounts().get(i).getAccountNr(),
                        amount = (int) Math.pow(amount,2));
            }
        }
        return b1;
    }
}