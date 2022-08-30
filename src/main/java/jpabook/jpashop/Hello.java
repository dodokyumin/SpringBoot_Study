package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

//Getter Setter 어노테이션만으로 기존 getter setter 메소드 구현 끝
@Getter @Setter
public class Hello {
    private String data;
}
