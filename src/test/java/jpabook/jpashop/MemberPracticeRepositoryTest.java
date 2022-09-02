package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class) //Spring과 관련된 테스트를 하겠다고 Junit에게 알려주는 역할
@SpringBootTest
public class MemberPracticeRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    //EntityManager를 통한 모든 데이터 변경은 Transaction 안에서 이뤄져야 한다.(@Transactional 없으면 테스트가 실행 안됨)
    //@Transactional이 TestCase에 있으면 Test가 끝난 후 바로 rollback을 해버린다.(왜냐하면, 데이터가 들어있을 경우 반복적인 테스트가 불가하기 때문)
    @Rollback(false) //rollback을 false로 해주면 테스트에서도 db에 들어간 데이터 확인 가능.
    public void testMember() throws Exception {
        // given
        Member_Practice memberPractice = new Member_Practice();
        memberPractice.setUsername("memberA");

        // when
        Long savedId = memberRepository.save(memberPractice);
        //저장된 변수 자동으로 뽑는 단축키(memberRepository.save(member); 까지만 입력 후 ctrl + alt + v)
        Member_Practice findMemberPractice = memberRepository.find(savedId);

        // then
        /* assertJ 라는 library를 스프링 테스트가 library dependency에서 자동으로 갖고있기 때문에 Assertions. 만 해도 바로 올라와
        .으로 연결하여 작성할 수 있는 것이 장점이다. */
        Assertions.assertThat(findMemberPractice.getId()).isEqualTo(memberPractice.getId());
        Assertions.assertThat(findMemberPractice.getUsername()).isEqualTo(memberPractice.getUsername());
        Assertions.assertThat(findMemberPractice).isEqualTo(memberPractice);
        System.out.println("findMember == member: " + (findMemberPractice == memberPractice)); //true
        //같은 transaction 안에서 저장하고 조회하면 같은 영속성 context가 같다.
        // 같은 영속성 context에서는 id값이 같으면 같은 entity로 식별하기 때문에.
        // 영속성 context에서 식별자가 같으면 같은 entity로 인식한다. 1차 캐시에서 영속성 context가 있는 걸 확인 후 select문 없이 바로 끌어왔다.

    }
}