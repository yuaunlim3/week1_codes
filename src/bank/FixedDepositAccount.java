package bank;

public class FixedDepositAccount extends BankAccount{
    private float interest;
    private int counterInterest = 0;
    private int duration;
    private int counterDuration = 0;
    private float balance;

    public FixedDepositAccount(String name, Float balance){
        super(name);
        this.balance = balance;
        this.interest = 3F;
        this.duration = 6;
    }

    public FixedDepositAccount(String name, Float balance,Float interest){
        super(name);
        this.balance = balance;
        this.interest = interest;
        this.duration = 6;
    }

    public FixedDepositAccount(String name, Float balance, Float interest, Integer duration){
        super(name);
        this.balance = balance;
        this.interest = interest;
        this.duration = duration;
    }


    public float getInterest() {
        return interest;
    }
    public void setInterest(float interest) {
        if(this.counterInterest == 0){
            this.interest = interest;
            this.counterInterest++;
        }
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        if(this.counterDuration == 0){
            this.duration = duration;
            this.counterDuration++;
        }
    }

    public float getBalance(){

        return this.balance + this.interest;
    }

    @Override

    public void deposit(int amt){}
    public void withdraw(int amt){}
    
}
