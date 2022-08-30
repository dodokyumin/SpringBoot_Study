package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute( "data","hello!");
        return "hello";
        /* return "hello"는 경로지정을 안해줘도 thymleaf의 기본 설정으로
        resources : templates/ + {ViewName} + .html 로 매핑해준다 */
    }
}
