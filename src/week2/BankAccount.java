package week2;

public class BankAccount {

    // 멤버 변수
    // private => 동일 클래스
    private int bankCode;
    private int accountNo;
    private String owner;
    private int balance;
    private boolean isDormant;
    private int password;

    // 메서드
    public void inquiry(){}
    public void deposit(){}
    public void heldInDormant(){}
    public void changePassword(int password){
        this.password = password;
    }


    // 생성자
    // 클래스 내부에 정의, 생성자 메서드명은 클래스명과 일치! (중요)
    // new 연산자와 함께 사용
    BankAccount(int bankCode, int accountNo, String owner, int balacne, int password, boolean isDormant) {
        this.bankCode = bankCode;
        this.accountNo = accountNo;
        this.owner = owner;
        this.isDormant = isDormant;
        this.balance = balacne;
        this.password = password;
    }

    // 기본 생성자
    BankAccount(){}

    // Getter
    public int getBankCode() {
        return bankCode;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isDormant() {
        return isDormant;
    }

    public int getPassword() {
        return password;
    }

    // Setter
    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setDormant(boolean dormant) {
        isDormant = dormant;
    }

    public void setPassword(int password) {
        this.password = password;
    }


}
