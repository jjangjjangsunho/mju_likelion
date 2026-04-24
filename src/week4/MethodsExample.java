package week4;

public class MethodsExample {
    // 함수(메서드)
    // 어떠한 값이 넘겨지면 아무 값도 넘겨지지 않았을 떄
    // 작업을 수행한 후
    // 반환하거나 혹은 반환하지 않고 종료

    static void main() {
        int mod_result = mod(3,2);
        System.out.println(mod_result);

        printNum(10);

        String str = greeting();
        System.out.println(str);

        greeting_2();
    }

    // 1. 입력 0, 출력 0
    static int mod (int a, int b){
        int result = a % b;
        return result;
    }

    // 2. 입력 0, 출력(반환) X
    static void printNum (int a){
        System.out.println(a);
    }

    // 3. 입력 X, 출력 O
    static String greeting(){
        return "Hello!";
    }

    // 4. 입력 X, 출력 X
    static void greeting_2(){
        System.out.println("Hello!");
    }
}
