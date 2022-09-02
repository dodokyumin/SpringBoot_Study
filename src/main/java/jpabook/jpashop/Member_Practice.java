package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter //Lombok이 제공하는 getter setter 어노테이션 기능
public class Member_Practice {

    @Id @GeneratedValue
    private Long id;
    private String username;
}
