package week1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BabyLionBonus3_Main {

    static void main() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try { //예외 처리 추가
                System.out.println("🦁저장할 아기사자 수를 5 이상 입력해주세요.");
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

                    boolean isDuplicate = true; //중복 검사 추가
                    while (isDuplicate){
                        isDuplicate = false;
                        for (int j = 0 ; j < i ; j++){
                            if (name[i].equals(name[j])){
                                System.out.println("⚠️ 이미 등록된 이름입니다. 다시 입력해주세요.");
                                name[i] = scanner.nextLine();
                                isDuplicate = true;
                            }
                        }
                    }

                    while (name[i].isEmpty()){ //빈 이름 검사 추가
                        System.out.println("⚠️ 이름이 비었습니다. 다시 입력해주세요.");
                        name[i] = scanner.nextLine(); //nextLine을 써야 isEmpty를 쓸 수 있음.
                    }
                }

                System.out.println("📋아기사자 명단을 최종적으로 출력합니다.");
                for (int i = 0 ; i < size ; i++) {
                    System.out.println("🦁" + (i + 1) + ". " + name[i]);
                }

                while (true) { //exit, restart 기능 추가
                    System.out.println("===================");
                    System.out.println("⛔️프로그램을 종료하려면 'exit'를 입력하세요");
                    System.out.println("🔁계속 아기사자를 등록하려면 'restart'를 입력하세요");

                    String input = scanner.next();

                    if (input.equals("restart")) {
                        break;
                    } else if (input.equals("exit")) {
                        System.out.println("👋아기 사자 명단 관리 프로그램을 종료합니다.");
                        return;
                    } else {
                        System.out.println("⚠️잘못된 입력 값입니다. 다시 입력해주세요");
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("❗️[오류] 숫자만 입력할 수 있습니다");
                scanner.nextLine(); //버퍼를 비워야 무한루프 방지, claude의 도움을 받음
            }
        }

    }
}
