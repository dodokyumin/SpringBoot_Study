package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) //EnumType의 default는 ORDINAL(1,2,3,4..가 컬럼으로 들어감).
    //만약 READY, XXX, COMP 처럼 가운데 XXX가 추가 됐을 경우, 원래 2였던 COMP가 3으로 밀리면서 기존 2들은 XXX로 바뀌어 출력하게 됨.
    //그래서 ORDINAL은 쓰지 말자. STRING은 순서가 밀릴 일이 없음.
    private DeliveryStatus status; //READY(배송 준비), COMP(배송)
}
