package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id") //컬럼 이름 따로 설정하기
    private Long id;

    private String name;

    @Embedded //내장 타입이라는 것
    private Address address;

    @OneToMany(mappedBy = "member") //나는 member에서 매핑된 거울일 뿐야(읽기 전용).
    private List<Order> orders = new ArrayList<>();
}
