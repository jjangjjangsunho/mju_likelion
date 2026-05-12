package week5.package1;

import week5.role.Member;
import java.util.List;

public class MemberService {

    // Step 1의 핵심: 외부에서 주입받지 않고, 내부에서 직접 생성하여 사용함
    private final MemberRepository memberRepository = new MemberRepository();

    // 중복 확인 후 등록
    public boolean register(Member member) {
        if (memberRepository.checkDuplicateName(member.getName())) {
            return false; // 이미 존재하는 이름이면 false 반환
        }
        memberRepository.save(member);
        return true;
    }

    // 전체 멤버 조회
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // 이름으로 검색
    public Member searchByName(String name) {
        return memberRepository.findByName(name);
    }
}