package week2;

public class SavingsAccount extends BankAccount implements Withdrawable{

    boolean isOverdraft;

    void transfer(){}
    // 외부에서 사용할 수 있도록 접근 제어자를 public으로
    public void withdraw(){
        System.out.println("Withdraw");
    }
}
