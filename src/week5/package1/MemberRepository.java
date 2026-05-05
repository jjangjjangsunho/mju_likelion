package week5.package1;

import week5.role.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberRepository {
    private final List<Member> store = new ArrayList<>();

    public void save(Member member) {
        store.add(member);
    }

    public Optional<Member> findByName(String name) {
        for (Member member : store) {
            if (member.getName().equals(name)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store);
    }
}