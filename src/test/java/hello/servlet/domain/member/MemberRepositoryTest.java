package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("user", 20);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember.getUsername()).isEqualTo("user");
        assertThat(savedMember.getAge()).isEqualTo(20);
    }

    @Test
    void findAll() {
        // givne
        Member user1 = new Member("user1", 30);
        Member user2 = new Member("user2", 31);
        memberRepository.save(user1);
        memberRepository.save(user2);

        // when
        List<Member> memberList = memberRepository.findAll();

        // then
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(user1, user2);
    }
}