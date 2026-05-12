package week5.package2;

import week5.role.Lion;
import week5.role.Member;
import week5.role.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private final List<Member> store = new ArrayList<>();

    public MockMemberRepository() {
        store.add(new Lion("장선호", "컴퓨터공학과", 14, "백엔드", 60232050));
        store.add(new Staff("최인준", "컴퓨터공학과", 14, "백엔드", "회장"));
    }

    @Override
    public void save(Member member) {
        // 저장 하지 않음
        System.out.println(" ⚠️ [Mock] 더미 저장소이므로 '" + member.getName() + "'의 정보를 실제로 저장하지 않습니다.");
    }

    @Override
    public Member findByName(String name) {
        for (Member member : store) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return store;
    }

    @Override
    public boolean checkDuplicateName(String name) {
        return findByName(name) != null;
    }
}