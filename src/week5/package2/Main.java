package week5.package2;

import week5.role.Lion;
import week5.role.Member;
import week5.role.Staff;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step2 저장소 선택
        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        String repoChoice = scanner.nextLine();

        MemberRepository repository;
        if (repoChoice.equals("2")) {
            repository = new MockMemberRepository();
        } else {
            repository = new MemoryMemberRepository();
        }

        // 2. Service에 선택한 Repository 주입
        MemberService memberService = new MemberService(repository);

        while (true) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) =====");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                registerMenu(memberService, scanner);
            } else if (choice.equals("2")) {
                System.out.println("\n===== 🎯전체 멤버 목록 =====");
                List<Member> members = memberService.findMembers();
                for (Member m : members) {
                    System.out.println(m.getDetails() + "\n");
                }
            } else if (choice.equals("3")) {
                System.out.print("검색할 이름: ");
                String name = scanner.nextLine();
                Member member = memberService.findOne(name);
                if (member != null) {
                    System.out.println("\n🎯===== 검색 결과 =====");
                    System.out.println(member.getDetails());
                    System.out.println("✅ 과제 제출 가능: " + (member.isSubmittable() ? "가능" : "불가능"));
                } else {
                    System.out.println("해당 멤버를 찾을 수 없습니다.");
                }
            } else if (choice.equals("4")) {
                break;
            }
        }
    }

    private static void registerMenu(MemberService service, Scanner scanner) {
        System.out.println();
        System.out.println("👤역할 (1: 아기사자, 2: 운영진): ");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println();

        System.out.print("이름: "); String name = scanner.nextLine();
        System.out.print("전공: "); String major = scanner.nextLine();
        System.out.print("기수: "); int cohort = Integer.parseInt(scanner.nextLine());
        System.out.print("파트: "); String part = scanner.nextLine();

        if (type == 1) {
            System.out.print("학번: ");
            int studentId = Integer.parseInt(scanner.nextLine());
            service.join(new Lion(name, major, cohort, part, studentId));
        } else {
            System.out.print("직책: ");
            String staffRole = scanner.nextLine();
            service.join(new Staff(name, major, cohort, part, staffRole));
        }
    }
}