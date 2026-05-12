package week5.package1;

import week5.role.Lion;
import week5.role.Member;
import week5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main에서는 Service만 사용하고 Repository를 직접 다루지 않음
        MemberService memberService = new MemberService();

        while (true) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 1: 레이어 분리) ===== 🦁");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                System.out.println("\n👤 역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = Integer.parseInt(scanner.nextLine());

                System.out.println("\n📝 정보 입력");
                System.out.print("이름: ");
                String name = scanner.nextLine();
                System.out.print("전공: ");
                String major = scanner.nextLine();
                System.out.print("기수: ");
                int cohort = Integer.parseInt(scanner.nextLine());
                System.out.print("파트: ");
                String part = scanner.nextLine();

                Member newMember = null;

                if (roleChoice == 1) {
                    System.out.print("학번: ");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    newMember = new Lion(name, major, cohort, part, studentId);
                } else if (roleChoice == 2) {
                    System.out.print("직책: ");
                    String role = scanner.nextLine();
                    newMember = new Staff(name, major, cohort, part, role);
                }

                if (newMember != null) {
                    boolean isSuccess = memberService.register(newMember);
                    if (isSuccess) {
                        System.out.println("\n✅ 등록 완료: " + newMember.getName());
                    } else {
                        System.out.println("\n❌ 실패: 이미 존재하는 이름입니다.");
                    }
                }

            } else if (choice == 2) {
                System.out.println("\n📋 ===== 전체 멤버 목록 =====");
                List<Member> members = memberService.getAllMembers();
                if (members.isEmpty()) {
                    System.out.println("등록된 멤버가 없습니다.");
                } else {
                    for (Member m : members) {
                        System.out.println(m.getDetails());
                        String submitStatus = m.isSubmittable() ? "✅ 가능" : "❌ 불가능";
                        System.out.println("과제 제출 가능: " + submitStatus);
                        System.out.println("--------------------");
                    }
                }

            } else if (choice == 3) {
                System.out.print("\n🔍 검색할 이름: ");
                String searchName = scanner.nextLine();

                Member foundMember = memberService.searchByName(searchName);

                if (foundMember != null) {
                    System.out.println("\n🚀 ===== 검색 결과 =====");
                    System.out.println(foundMember.getDetails());
                    String submitStatus = foundMember.isSubmittable() ? "✅ 가능" : "❌ 불가능";
                    System.out.println("과제 제출 가능: " + submitStatus);
                } else {
                    System.out.println("\n❌ 해당 멤버를 찾을 수 없습니다.");
                }

            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        scanner.close();
    }
}