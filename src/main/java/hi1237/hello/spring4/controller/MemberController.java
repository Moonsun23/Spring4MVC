package hi1237.hello.spring4.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MemberController {

        // 로거 설정: getLogger(로깅할 클래스 명)
    private Logger logger = LogManager.getLogger(MemberController.class);

        // http://localhost:8080/ 호출시 실행
        @RequestMapping(value="/member/join",method= RequestMethod.GET )
        public String join(Model m) {

            // 로거 출력
            logger.info("member/join 호출!");

            // return "index"; // jsp:view resolver
            return "member/join.tiles";

        }

    @RequestMapping(value="/member/join",method= RequestMethod.POST )
    public String joinok(Model m) {

        // 로거 출력
        logger.info("member/joinok 호출!");

        // return "index"; // jsp:view resolver
        return "redirect: /member/login";

    }
    @RequestMapping(value="/member/login", method=RequestMethod.POST)
    public String login(Model m) {

        // 로거 출력
        logger.info("member/loginok 호출!");

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
