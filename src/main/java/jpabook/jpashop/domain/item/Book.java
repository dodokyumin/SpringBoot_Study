package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") //Single_table 전략에서 저장이 될 때 DB입장에서 구분할 수 있도록 저장하는 값
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;

}
