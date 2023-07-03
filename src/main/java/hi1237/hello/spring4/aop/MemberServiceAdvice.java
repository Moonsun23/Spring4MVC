package hi1237.hello.spring4.aop;

import hi1237.hello.spring4.controller.MemberController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;


@Aspect
@Component

public class MemberServiceAdvice {

    private Logger logger = LogManager.getLogger(MemberServiceAdvice.class);

    @Pointcut("execution(* hi1237.hello.spring4.controller.MemberController.myinfo(..))")
        public void myInfoPoint() {}

    @Pointcut("execution(* hi1237.hello.spring4.controller.MemberController.join(..))")
        public void joinPoint(){}


    // around 있는 부분이 Advice.. '*' 은 접근제한
    // pointcut과 around를 합쳐서 advisor...라고 부른다
    @Around("myInfoPoint()")
    public Object myinfoAOPProcess(ProceedingJoinPoint pjp) throws Throwable {

        logger.info("myinfoAOPProcess 호출!!");
        HttpSession sess = null;

        // join point에서 넘겨준 매개변수에서 원하는 객체 추출
        for(Object o : pjp.getArgs()){
            if(o instanceof HttpSession)
                sess= (HttpSession) o;
        }

        // 포인트컷 대상 메서드 실행
        if (sess.getAttribute("member") == null)
            return "redirect:/member/login";

        //
        Object obj = pjp.proceed();
        return obj;
    }

    // 아래 around는 advice...
    @Around("joinPoint()")
    public Object joinAOPProcess(ProceedingJoinPoint pjp) throws Throwable {

        logger.info("joinAOPProcess 호출!!");
        HttpSession sess = null;

        // 이 부분에서는 MemberController의 join(GET) 부분에 HttpSession이 없어서 null 값이 떴음
        // 그래서 String join에 HttpSession 값을 넣어줘서 logger가 아닌 HttpSession이 작동하도록 함.
        for(Object o : pjp.getArgs()){
            if(o instanceof HttpSession)
                sess= (HttpSession) o;
        }

        // 포인트컷 대상 메서드 실행
        // 로그인 안했다면 -> join 으로 가고
        // 로그인 했다면 -> myinfo로 이동
        if (sess.getAttribute("member") != null)
            return "redirect:/member/myinfo";

        //
        Object obj = pjp.proceed();
        return obj;
    }

}
