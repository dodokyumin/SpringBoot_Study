package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속관계매핑에서 중요한 상속관계전략 지정(전략을 부모클래스에 잡아준다.)
// InheritanceType 에는 Joined(가장 정교화된 스타일), Single_Table(한 테이블에 다 때려박음), Table_Per_Class(book movie album 세개의 테이블만 나옴)가 있다.
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item { //구현체를 가지고 할 것이기 때문에 추상클래스 abstract 붙여줌
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;
}
