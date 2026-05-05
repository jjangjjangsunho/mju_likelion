package week5.package2;

import week5.role.Member;
import java.util.List;
import java.util.Optional;

public class MemberService {
    // 인터페이스에 의존하며, 한 번 설정되면 변경되지 않도록 final 사용
    private final MemberRepository memberRepository;

    // 생성자를 통해 외부에서 구현체를 주입받음 (의존성 주입)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        if (result.isPresent()) {
            System.out.println("❌ 이미 존재하는 이름입니다.");
            return;
        }
        memberRepository.save(member);
        System.out.println("✅ 등록 완료: " + member.getName());
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(String name) {
        Optional<Member> result = memberRepository.findByName(name);
        return result.orElse(null);
    }
}