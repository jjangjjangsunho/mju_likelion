package week5.package2;

import week5.role.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}