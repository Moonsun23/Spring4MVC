package hi1237.hello.spring4.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {

        // 로거 설정: getLogger(로깅할 클래스 명)
    private Logger logger = LogManager.getLogger(MemberController.class);

        // http://localhost:8080/ 호출시 실행
        @RequestMapping("/member/join")
        public String join(Model m) {

            // 로거 출력
            logger.info("member/join 호출!");

            // return "index"; // jsp:view resolver
            return "member/join.tiles";

        }
    @RequestMapping("/member/login")
    public String login(Model m) {

        // 로거 출력
        logger.info("member/login 호출!");

        // return "index"; // jsp:view resolver
        return "member/login.tiles";

    }
    @RequestMapping("/member/myinfo")
    public String myinfo(Model m) {

        // 로거 출력
        logger.info("member/myinfo 호출!");

        // return "index"; // jsp:view resolver
        return "member/myinfo.tiles";

    }
}
