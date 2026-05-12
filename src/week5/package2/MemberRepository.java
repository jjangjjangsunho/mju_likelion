package week5.package2;

import week5.role.Member;
import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findByName(String name);
    List<Member> findAll();
    boolean checkDuplicateName(String name);
}
