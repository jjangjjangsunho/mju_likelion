package week2;

public class ClassExample {

    static void main() {
        BankAccount account = new BankAccount();
        //account.password = 123456; // 컴파일 에러
        //System.out.println(account.password);

        account.changePassword(123456);
        System.out.println(account.getPassword());

        System.out.println(account);
    }
}
