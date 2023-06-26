package hi1237.hello.spring4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

        // http://localhost:8080/ 호출시 실행
        @RequestMapping("/")
        public String index(Model m) {

            // addAttribute(변수명, 대상객체)
            m.addAttribute("sayHello", "Hello World! from Controller");

            return "index";

        }
}
