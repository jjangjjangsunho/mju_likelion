package week5.package1;

import week5.role.Member;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

    public void join(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        if (result.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        memberRepository.save(member);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(String memberName) {
        Optional<Member> result = memberRepository.findByName(memberName);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}