package bank;

import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccount {
    private final String name;
    private final String accNum;
    private float balance;
    private ArrayList<String> transactions;
    private boolean isClosed;
    private final String  openDate;

    public BankAccount(String name){
        this.name = name;
        Random rand = new SecureRandom();
        int num = rand.nextInt();
        this.accNum = Integer.toString(num);
        this.balance = 0;
        this.transactions = new ArrayList<String>();
        this.isClosed = false;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.openDate= myDateObj.format(myFormatObj);

    }

    public BankAccount(String name, float amount){
        this.name = name;
        Random rand = new SecureRandom();
        int num = rand.nextInt();
        this.accNum = Integer.toString(num);
        this.balance = amount;
        this.transactions = new ArrayList<String>();
        this.isClosed = false;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.openDate = myDateObj.format(myFormatObj);
    }

    

    public String getName() {
        return name;
    }

    public String getAccNum() {
        return accNum;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    public void deposit(int amt){
        LocalDateTime depoTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String depoTimeFormatted = depoTime.format(myFormatObj);
        if(!this.isClosed && amt>=0){
            this.balance += amt;
            String transaction = "deposit $" + amt + " at " + depoTimeFormatted;
            this.transactions.add(transaction);
        }
        System.out.printf("Account name: %s\n",this.name);
        for(String item:this.transactions){
            System.out.printf(">>> %s\n",item);
        }
    }

    public void withdraw(int amt){
        LocalDateTime wdTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String wdTimeFormatted = wdTime.format(myFormatObj);
        if(!this.isClosed && amt>=0 && this.balance > amt){
            this.balance -= amt;
            String transaction = "withdraw $" + amt + " at " + wdTimeFormatted;
            this.transactions.add(transaction);
        }
        System.out.printf("Account name: %s\n",this.name);
        for(String item:this.transactions){
            System.out.printf(">>> %s\n",item);
        }
    }


}
