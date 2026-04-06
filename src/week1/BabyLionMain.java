package week1;

import java.util.Scanner;

public class BabyLionMain {

    static void main() {
        System.out.println("🦁저장할 아기사자 수를 5 이상 입력해주세요.");

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        while (size < 5) {
            System.out.println("❗️[오류] 5 이상 입력해주세요.");
            System.out.println("🦁저장할 아기사자 수를 5 이상 입력해주세요.");
            size = scanner.nextInt();
        }

        String[] name = new String[size];

        System.out.println("✏️아기사자 이름을 입력해주세요.");
        scanner.nextLine();
        for (int i = 0 ; i < size ; i++) {
            name[i] = scanner.nextLine();
        }

        System.out.println("📋아기사자 명단을 최종적으로 출력합니다.");
        for (int i = 0 ; i < size ; i++){
            System.out.println("🦁" + (i + 1) + ". " + name[i]);
        }
    }
}

