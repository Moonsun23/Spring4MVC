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
// aspectj의 문법을 가져다 쓸 수 있다.
@Component

public class BoardServiceAdvice {

    private Logger logger = LogManager.getLogger(BoardServiceAdvice.class);


    @Pointcut("execution(* hi1237.hello.spring4.controller.BoardController.write(..))")
    public void writePoint(){}

    // around 있는 부분이 Advice.. '*' 은 접근제한
    // pointcut과 around를 합쳐서 advisor...라고 부른다


    @Around("writePoint()")
    public Object writeAOPProcess(ProceedingJoinPoint pjp) throws Throwable {

        logger.info("writeAOPProcess 호출!!");
        HttpSession sess = null;

        for(Object o : pjp.getArgs()){
            if(o instanceof HttpSession)
                sess= (HttpSession) o;
        }

        // 포인트컷 대상 메서드 실행
        // 로그인 안했다면 -> write 으로 가고
        // 로그인 했다면 -> login로 이동
        if (sess.getAttribute("member") == null)
            return "redirect:/member/login";

        Object obj = pjp.proceed();
        return obj;
    }

}
