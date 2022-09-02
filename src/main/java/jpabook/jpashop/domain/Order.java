package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // 예약어 order가 될 수 있으므로 저장할 때엔 orders로 저장
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id") // 매핑을 무엇으로 해줄 것인가를 입력
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id") // 1대1 테이블은 JPA에서는 FK를 아무데나 줘도 되지만,
    // FK가 보다 가까운 delivery에 joincolumn을 주는 것이 편함
    private Delivery delivery;

    private localDateTime orderDate; //주문 시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문 상태 [ORDER, CANCEL]

}
