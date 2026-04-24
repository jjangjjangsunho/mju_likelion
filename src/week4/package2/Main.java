package week4.package2;

import week4.role.Lion;
import week4.role.Role;
import week4.role.Staff;
import java.util.*;

public class Main {

        static Scanner scanner = new Scanner(System.in); //static을 추가
        static List<Role> members = new ArrayList<>(); //static을 추가
        static Map<String, List<Role>> partMap = new HashMap<>();

        static void main() {
            while (true){

                System.out.println("======🦁맴버 관리 시스템======");
                System.out.println("1. 멤버 등록");
                System.out.println("2. 전체 멤버 조회");
                System.out.println("3. 이름으로 검색");
                System.out.println("4. 파트별 조회");
                System.out.println("5. 종료");
                System.out.print("선택: ");

                int menu = scanner.nextInt();
                scanner.nextLine();

                if (menu == 1){
                    registerMember();
                } else if (menu == 2) {
                    listAllMembers();
                } else if (menu == 3) {
                    searchByName();
                } else if (menu == 4) {
                    searchByPart();
                } else if (menu == 5) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
            }
        }

        // 명단 등록
        static void registerMember() {
            System.out.println("— 📝 멤버 등록 —");
            System.out.print("역할 선택(1: 아기사자, 2: 운영진): ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 제거용

            System.out.print("👤 이름: ");
            String name = scanner.nextLine();

            boolean isDuplicate = false; // 중복 검사 로직 시작

            for (Role m : members){
                if (m.getName().equals(name)){
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate){
                System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                return;
            } // 중복 검사 로직 종료

            System.out.print("🎓 전공: ");
            String major = scanner.nextLine();

            System.out.print("🚀 기수: ");
            int cohort = scanner.nextInt();
            scanner.nextLine();

            System.out.print("🖥 파트 (백엔드/프론트엔드/기획/디자인): ");
            String part = scanner.nextLine();

            System.out.print("🆔 학번: ");
            int studentId = scanner.nextInt();

            Role newMember;

            if (roleChoice == 1){
                newMember = new Lion(name, major, cohort, part, studentId);
            } else {
                newMember = new Staff(name, major, cohort, part, studentId); //Staff 클래스 role -> studentId
            }

            members.add(newMember);
            if (!partMap.containsKey(part)) {
                partMap.put(part, new ArrayList<>());
            }
            partMap.get(part).add(newMember);
            System.out.println("✅ 등록 완료: " + newMember.getName());
        }

        // 전체 명단 조회
        static void listAllMembers() {
            System.out.println("— 📋 전체 멤버 목록 —");

            if (members.isEmpty()){
                System.out.println("등록된 멤버가 없습니다.");
                return;
            }

            for (int i = 0; i < members.size(); i++){
                Role m = members.get(i);
                String roleLabel = (m instanceof Lion) ? "아기사자" : "운영진";
                System.out.println(i + 1 + ". [" + roleLabel + "] " + m.getName() + "- " + m.getCohort() + "기");
            }
            System.out.println("📊 총 " + members.size() + "명");
        }

        // 이름 조회
        static void searchByName() {
            System.out.println("— 🔍 이름으로 검색 —");
            System.out.print("검색할 이름: ");
            String keyword = scanner.nextLine();

            for (Role m : members) {
                if (m.getName().equals(keyword)) {
                    System.out.println("✨ [검색 결과]");
                    System.out.println(m.getDetails());
                    System.out.println("📝 과제 제출 가능 여부: " + (m.isSubmittable() ? "✅ 가능" : "❌ 불가능"));
                }
            }
        }

        // 파트 조회
        static void searchByPart() {
            System.out.println("— 💻 파트별 조회 —");

            System.out.println("📁 등록된 파트: [백엔드, 프론트엔드]");

            System.out.print("조회할 파트명: ");
            String keyword = scanner.nextLine();

            if (!partMap.containsKey(keyword)) {
                System.out.println("❌ 존재하지 않는 파트입니다.");
                return;
            }

            List<Role> partMembers = partMap.get(keyword);
            System.out.println("✨ [" + keyword + " 파트 멤버]");
            for (int i = 0; i < partMembers.size(); i++) {
                Role m = partMembers.get(i);
                String roleLabel = (m instanceof Lion) ? "아기사자" : "운영진";
                System.out.println(i + 1 + ". [" + roleLabel + "] " + m.getName() + " - " + m.getCohort() + "기");
            }
        }
    }


