package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    //스프링 부트를 쓰기 때문에 스프링 컨테이너 위에서 모든게 동작. @PersistenceContext 가 있으면 EntityManager 를 주입해준다.
    @PersistenceContext
    private EntityManager em;

    //저장
    public Long save(Member member) {
        em.persist(member);
        return member.getId(); //커맨드와 쿼리를 분리하는 원칙
    }

    //조회(한개)
    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
