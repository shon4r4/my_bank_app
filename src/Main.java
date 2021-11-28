import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String bankName = "";
        int sel = 400;
        Scanner userSel = new Scanner(System.in);
        Bank bank = new Bank();
        Filehandler filehandler = new Filehandler();

        filehandler.writeCustomersToFile(MockData.initiateMymockMyData(new Bank()),"gritBank.txt");

        while(true)
        {
            System.out.println(" |-----    Welcome to Grit Bank    -----| ");
            System.out.println(" |-----     MENU     -----| ");
            System.out.println(" 0. List of the available banks   ");
            System.out.println(" 1. Create new bank ");
            System.out.println(" 2. Import customer list");
            System.out.println(" 3. Add a customer");
            System.out.println(" 4. Remove a customer");
            System.out.println(" 5. Deposit ");
            System.out.println(" 6. Make a Withdraw ");
            System.out.println(" 7. Close the existing customers account");
            System.out.println(" 8. Farewell ");
            System.out.println("---------------------------------------");
            System.out.println("Choose between!");


            try {
                sel = userSel.nextInt();
            } catch (Exception e) {
                System.out.println("No such command");
                userSel.next();
            }

            if(sel == 8) break;


            switch (sel) {
                case 0 -> {
                    System.out.println("Available banks:");
                    filehandler.listFiles();
                }

                case 1 -> {
                    System.out.println("Bank name");
                    try {
                        bankName = userSel.next();
                    } catch (Exception e) {
                        System.out.println("not found");
                        userSel.next();
                    }

                    filehandler.createFile(bankName);
                }

                case 2 -> {
                    System.out.println(" |-------------------------------------------------| ");
                    System.out.println(" |**** The list of customers ****| ");
                    System.out.println(" |-------------------------------------------------| ");

                    System.out.println("Name of the file: ");
                    bankName = userSel.next();

                    bank = filehandler.readFile(bankName);
                    System.out.println(bank.getCustomers());

                }

                case 3 -> {

                    System.out.print("First name: ");
                    String firstName = userSel.next();
                    System.out.print("Last name: ");
                    String lastName = userSel.next();
                    System.out.print("Personal number: ");
                    long pNR = userSel.nextLong();
                    System.out.println(bank.addCustomer(firstName,lastName,pNR));
                    filehandler.writeCustomersToFile(bank,bankName);


                }

                case 4 -> {
                    System.out.print("Customer Personal number: ");
                    long pNR = userSel.nextLong();

                    System.out.println(bank.removeCustomer(pNR));
                    filehandler.writeCustomersToFile(bank,bankName);
                }


                case 5 -> {
                    System.out.print("Personal number: ");
                    long pNR = userSel.nextLong();
                    System.out.print("Account number: ");
                    long accountNr = userSel.nextLong();
                    System.out.print("Deposit amount: ");
                    int amount = userSel.nextInt();
                    System.out.println(bank.deposit(pNR,accountNr,amount));
                    filehandler.writeCustomersToFile(bank,bankName);

                }


                case 6 -> {
                    System.out.print("Personal number: ");
                    long pNR = userSel.nextLong();
                    System.out.print("Account number: ");
                    long accountNr = userSel.nextLong();
                    System.out.print("Withdraw amount: ");
                    int amount = userSel.nextInt();
                    System.out.println(bank.withdraw(pNR,accountNr,amount));
                    filehandler.writeCustomersToFile(bank,bankName);


                }

                case 7 -> {
                    System.out.print("Personal number: ");
                    long pNR = userSel.nextLong();
                    System.out.print("Account number: ");
                    long accountNr = userSel.nextLong();

                    System.out.println(bank.closeAccount(pNR,accountNr));
                    filehandler.writeCustomersToFile(bank,bankName);


                }

                default -> System.out.println("0");
            }
        }

    }
}
