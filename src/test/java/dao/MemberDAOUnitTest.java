package dao;

import hi1237.hello.spring4.dao.MemberDAO;
import hi1237.hello.spring4.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml",
        "classpath:spring/root-context.xml"})
@WebAppConfiguration
public class MemberDAOUnitTest {

    // 테스트 할 대상 객체를 주입받음
    @Autowired MemberDAO mdao;

    @Test
    @Transactional              // 데이터 입력 후 자동삭제
    // transactional을 통해 테스트를 자동 롤백하며 할 수 있다...(root-context에 삽입)
    public void insertMember() throws Exception {
        Member m = new Member(null, "abc123b", "987xyz", "abc123","abc123@987xyz.co.kr",null);
        // assertEquals(테스트메서드, 검증값)
        // abc123이라는 것(userid)에 unique 키를 넣어놔서 같은 값을 쓰면 안된다.
        assertEquals(mdao.insertMember(m), 1);
        // 위를 실행하면 1이 넘어온다..
    }

}
