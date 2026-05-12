package week5.package2;

import week5.role.Lion;
import week5.role.Member;
import week5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("💾 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        int repoChoice = Integer.parseInt(scanner.nextLine());

        // 다형성을 활용하여 인터페이스 타입으로 변수 선언
        MemberRepository repository;

        // 사용자의 선택에 따라 실제 생성할 객체(구현체)가 달라짐
        if (repoChoice == 2) {
            repository = new MockMemberRepository();
        } else {
            repository = new MemoryMemberRepository(); // 기본값 1번
        }

        // 선택된 저장소 객체를 Service에 주입(DI)
        MemberService memberService = new MemberService(repository);

        // 메인 로직 시작
        while (true) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🦁");
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
                        String status = m.isSubmittable() ? "✅ 가능" : "❌ 불가능";
                        System.out.println("과제 제출 가능: " + status);
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
                    String status = foundMember.isSubmittable() ? "✅ 가능" : "❌ 불가능";
                    System.out.println("과제 제출 가능: " + status);
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
