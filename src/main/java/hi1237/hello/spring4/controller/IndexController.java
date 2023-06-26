package hi1237.hello.spring4.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {

        // 로거 설정: getLogger(로깅할 클래스 명)
    private Logger logger = LogManager.getLogger(IndexController.class);

        // http://localhost:8080/ 호출시 실행
        @RequestMapping("/")
        public String index(Model m) {

            // addAttribute(변수명, 대상객체)
            m.addAttribute("sayHello", "Hello World! from Controller");

            // 로거 출력
            logger.info("Hello, World! from Logger!!");

            return "index";

        }
}
