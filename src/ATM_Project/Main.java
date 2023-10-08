package ATM_Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // HashMap contains userId and User obj
        HashMap<Integer,User> userdata = new HashMap<>();
        // HashMap contains transaction history in the form of userId and ArrayList of Transaction
        HashMap<Integer,ArrayList<Transaction>> transactionHistory = new HashMap<>();

        int userId=1001;
        int transactionId=5001;
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("Welcome to the OctaNet ATM ..!!\nPlease choose the Interface ..!!\nTo choose the Admin Interface enter 1\nTo choose the user Interface enter 2\nEnter 3 to Exit ");
            int interfaceInput = sc.nextInt();

            if(interfaceInput==1){
                boolean terminationPoint = false;
                while(!terminationPoint){

                    System.out.println("Welcome to the Admin Interface of OctaNet ATM ..!!\nPress 1 --> To add the User ..!!\nPress 2 --> To check the ATM Balance ..!!\nPress 3 --> To add the ATM Balance ..!!\nPress 4 --> To withdraw ATM Balance ..!!\nPress 5 --> To Exit ..!!");
                    int input = sc.nextInt();

                    if(input==1){
                        System.out.println("Enter the userName");
                        String userName = sc.next();
                        System.out.println("Enter the startingBalance");
                        int accountBalance = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the userPin");
                        String userPin = sc.nextLine();

                        User user = new User(userId,userName,accountBalance,userPin);
                        userdata.put(userId,user);
                        User addedUser = userdata.get(userId);
                        userId++;

                        ArrayList<Transaction> transactions = new ArrayList<>();
                        Transaction transaction = new Transaction(transactionId++,"Deposit",accountBalance,"successfull");
                        transactions.add(transaction);
                        transactionHistory.put(addedUser.getUserId(),transactions);
                        System.out.println("user added successfully and user Id and Pin are "+addedUser.getUserId()+" "+addedUser.getUserPin());
                        System.out.println();
                    }else if(input==2){
                        System.out.println("ATM Current Balance is "+Atm.getAtmBalance());
                        System.out.println();
                    } else if (input==3) {
                        System.out.println("Enter the Amount to be Added ..!!");
                        int amount = sc.nextInt();
                        Atm.setAtmBalance(Atm.getAtmBalance()+amount);
                        System.out.println("Amount added successfully and updated ATM Balance is "+Atm.getAtmBalance());
                        System.out.println();
                    } else if (input==4) {
                        System.out.println("Enter the Amount to be withdraw ..!!");
                        int amount = sc.nextInt();
                        if(amount>Atm.getAtmBalance()){
                            System.out.println("Withdraw amount should be less than ATM Balance");
                            System.out.println();
                            break;
                        }
                        Atm.setAtmBalance(Atm.getAtmBalance()-amount);
                        System.out.println("Amount added successfully and updated ATM Balance is "+Atm.getAtmBalance());
                        System.out.println();
                    } else {
                        System.out.println("Thank you for using OctaNet ATM ..!!!!!");
                        terminationPoint=true;
                        System.out.println();
                    }
                }
            } else if (interfaceInput==2) {
                while(true){
                    System.out.println("Welcome to the User Interface of OctaNet ATM ..!!");
                    System.out.println("Please enter the user Id ");
                    int user_id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter the user Pin ");
                    String user_pin = sc.nextLine();

                    if(!(userdata.containsKey(user_id) && userdata.get(user_id).getUserPin().equals(user_pin))){
                        System.out.println("Please enter the valid user Id and user pin ..!!");
                        System.out.println();
                        break;
                    }

                    System.out.println("Press 1 --> To get the transaction History ..!!\nPress 2 --> To Withdraw ..!!\nPress 3 --> To Deposit ..!!\nPress 4 --> To Transfer ..!!\nPress 5 --> To Exit ..!!");
                    int input = sc.nextInt();

                    if(input==1){
                        System.out.println(transactionHistory.get(user_id));
                        System.out.println();
                    } else if (input==2) {
                        System.out.println("Enter the Amount to Withdraw ..!!");
                        int amount = sc.nextInt();
                        if(Atm.getAtmBalance()<amount || userdata.get(user_id).getAccountBalance()<amount){
                            System.out.println("Please enter the sufficient amount ..!!");
                            break;
                        }
                        userdata.get(user_id).setAccountBalance(userdata.get(user_id).getAccountBalance()-amount);
                        Atm.setAtmBalance(Atm.getAtmBalance()-amount);

                        Transaction transaction = new Transaction(transactionId++,"Withdraw",amount,"successfull");
                        transactionHistory.get(user_id).add(transaction);
                        System.out.println(amount+" is successfully withdraw. Please collect your cash ..!!");
                        System.out.println();

                    } else if (input==3) {
                        System.out.println("Enter the Amount to Deposit ..!!");
                        int amount = sc.nextInt();
                        userdata.get(user_id).setAccountBalance(userdata.get(user_id).getAccountBalance()+amount);
                        Atm.setAtmBalance(Atm.getAtmBalance()+amount);

                        Transaction transaction = new Transaction(transactionId++,"Deposit",amount,"successfull");
                        transactionHistory.get(user_id).add(transaction);

                        System.out.println(amount+" is successfully Deposit and your current Account Balance is "+userdata.get(user_id).getAccountBalance());
                        System.out.println();

                    } else if (input==4) {
                        System.out.println("Enter the amount to Transfer ..!!");
                        int amount = sc.nextInt();
                        if(userdata.get(user_id).getAccountBalance()<amount){
                            System.out.println("Insufficient amount to transfer ..!!");
                            break;
                        }
                        System.out.println("Enter the receiver user Id ..!!");
                        int receiverUserId = sc.nextInt();
                        // deduct the amount from the user
                        userdata.get(user_id).setAccountBalance(userdata.get(user_id).getAccountBalance()-amount);

                        Transaction transaction1 = new Transaction(transactionId++,"Transfer",amount,"successfull");
                        transactionHistory.get(user_id).add(transaction1);

                        // deposit the amount to receiver
                        userdata.get(receiverUserId).setAccountBalance(userdata.get(receiverUserId).getAccountBalance()+amount);
                        Transaction transaction2 = new Transaction(transactionId++,"Deposit",amount,"Successfull");
                        transactionHistory.get(receiverUserId).add(transaction2);

                        System.out.println(amount+"is successfully Transfer ..!!");
                        System.out.println();
                    } else if (input==5) {
                        System.out.println("Thank you for using OctaNet ATM ..!!!!!");
                        System.out.println();
                        break;
                    }
                }
            } else if (interfaceInput==3) {
                System.out.println("Thank you for using OctaNet ATM ..!!!!!");
                return;
            }else{
                System.out.println("Please choose the correct given number to select the right interface ..!!");
                System.out.println();
            }
        }
    }
}