
import java.io.*;
import java.util.Scanner;

public class Filehandler {
    private File Object;
    private final String basePath = "./gritdocs/";

    public Filehandler() {
    }

    public void listFiles(){
        try {

            // create new file
            Object = new File(basePath);

            // array of files and directory
            String[] paths = Object.list();


            // for each name in the path array
            for(String path: paths) {

                // prints filename and directory name
                System.out.println(path);
            }

        } catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }

    public void createFile(String filename) {
        try {
            Object = new File(basePath+filename);
            if (Object.createNewFile()) {
                System.out.println("File created: " + Object.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeCustomersToFile(Bank bank, String filename){
        try {
            FileWriter myWriter = new FileWriter(basePath+filename,false);

            for (int i = 0; i < bank.getCustomersAndAccounts().size() ; i++) {
                myWriter.write(bank.getCustomersAndAccounts().get(i) + System.lineSeparator());
            }
            myWriter.close();
            System.out.println("Successfully printed the customerfile.");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public Bank readFile(String filename) {
        try {
            Object = new File(basePath+filename);
            Scanner myReader = new Scanner(Object);
            Bank bank = new Bank();

            System.out.println("Customers");

            while (myReader.hasNextLine()) {
                var line = myReader.nextLine();
                var InfoLine = line.split(" : ");
                var NamepNR = InfoLine[0].split(" ");
                var AccountsInfo = InfoLine[1].split(" , ");

                //Handle Name and SSN
                var firstName = NamepNR[0];
                var lastName = NamepNR[1];
                var pNR = Long.parseLong(NamepNR[2]);

                bank.addCustomer(firstName,lastName,pNR);

                //Handle accounts
                for (var acc : AccountsInfo) {
                    var Accounts = acc.split(" ");
                    var accountNr = Long.parseLong(Accounts[0]);
                    var accountType = Accounts[1];
                    var rate = Float.parseFloat(Accounts[2]);
                    var balance = Float.parseFloat(Accounts[3]);
                    bank.presetAccount(pNR, accountType, rate, balance, accountNr);
                }


            }
            myReader.close();
            //System.out.println(bank);
            return bank;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

    }



}