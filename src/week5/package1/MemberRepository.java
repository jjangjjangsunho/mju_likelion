package week5.package1;

import week5.role.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private final List<Member> store = new ArrayList<>();

    // 1. 멤버 저장
    public void save(Member member) {
        store.add(member);
    }

    // 2. 이름으로 검색
    public Member findByName(String name) {
        for (Member member : store) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null; // 찾지 못하면 null 반환
    }

    // 3. 전체 조회
    public List<Member> findAll() {
        return store;
    }

    // 4. 이름 중복 확인
    public boolean checkDuplicateName(String name) {
        return findByName(name) != null;
    }
}