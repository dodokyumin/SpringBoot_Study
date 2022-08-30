package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpashopApplication {

    public static void main(String[] args) {

        //lombok 테스트를 위한 코드
        Hello lombokTest = new Hello();
        lombokTest.setData("hello");
        String data = lombokTest.getData();
        System.out.println("data = " + data);

        SpringApplication.run(JpashopApplication.class, args);
    }

}
