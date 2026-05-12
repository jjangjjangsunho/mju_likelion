package week5.package2;

import week5.role.Member;
import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {
    private final List<Member> store = new ArrayList<>();

    @Override
    public void save(Member member) {
        store.add(member);
    }

    @Override
    public Member findByName(String name) {
        for (Member member : store) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null; // 찾지 못하면 null 반환
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
