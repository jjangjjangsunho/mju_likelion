package week5.package1;

import week5.role.Lion;
import week5.role.Member;
import week5.role.Staff;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        Scanner scanner = new Scanner(System.in); // 변수명 scanner 유지

        while (true) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 1) ===== 🦁");
            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                register(memberService, scanner);
            } else if (choice.equals("2")) {
                System.out.println("\n===== 🎯전체 멤버 목록 =====");
                List<Member> members = memberService.findMembers();
                for (Member m : members) {
                    System.out.println(m.getDetails() + "\n");
                }
            } else if (choice.equals("3")) {
                search(memberService, scanner);
            } else if (choice.equals("4")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    private static void register(MemberService service, Scanner scanner) {
        try {
            System.out.println();
            System.out.println("👤역할 (1: 아기사자, 2: 운영진): ");
            int type = Integer.parseInt(scanner.nextLine());
            System.out.println();
            System.out.println("📝 정보 입력");
            System.out.print("이름: "); String name = scanner.nextLine();
            System.out.print("전공: "); String major = scanner.nextLine();
            System.out.print("기수: "); int cohort = Integer.parseInt(scanner.nextLine());
            System.out.print("파트: "); String part = scanner.nextLine();

            if (type == 1) {
                System.out.print("학번: "); int id = Integer.parseInt(scanner.nextLine());
                service.join(new Lion(name, major, cohort, part, id));
            } else {
                System.out.print("직책: "); String role = scanner.nextLine();
                service.join(new Staff(name, major, cohort, part, role));
            }
            System.out.println();
            System.out.println("✅ 등록되었습니다.");
        } catch (Exception e) {
            System.out.println();
            System.out.println("❌ 오류: " + e.getMessage());
        }
    }

    private static void search(MemberService service, Scanner scanner) {
        System.out.print("찾을 이름: ");
        String name = scanner.nextLine();
        Member member = service.findOne(name);

        if (member != null) {
            System.out.println("\n🎯===== 검색 결과 =====");
            System.out.println(member.getDetails());
            System.out.println("과제 제출 가능 여부: " + (member.isSubmittable() ? "✅ 가능" : "❌ 불가능"));
        } else {
            System.out.println("해당 멤버가 없습니다.");
        }
    }
}