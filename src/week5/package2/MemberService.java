package week5.package2;

import week5.role.Member;
import java.util.List;

public class MemberService {
    // 구체적인 클래스가 아닌 인터페이스에 의존함
    private final MemberRepository memberRepository;

    // 의존성 주입 (Dependency Injection)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean register(Member member) {
        if (memberRepository.checkDuplicateName(member.getName())) {
            return false;
        }
        memberRepository.save(member);
        return true;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member searchByName(String name) {
        return memberRepository.findByName(name);
    }
}
