package week5.package2;

import week5.role.Lion;
import week5.role.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockMemberRepository implements MemberRepository {
    @Override
    public void save(Member member) {
        // Mock은 저장하지 않음
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 항상 더미 데이터 반환
        return Optional.of(new Lion("더미사자", "컴공", 14, "백엔드", 20260000));
    }

    @Override
    public List<Member> findAll() {
        List<Member> dummyList = new ArrayList<>();
        dummyList.add(new Lion("더미1", "전공1", 14, "파트1", 1111));
        dummyList.add(new Lion("더미2", "전공2", 14, "파트2", 2222));
        return dummyList;
    }
}