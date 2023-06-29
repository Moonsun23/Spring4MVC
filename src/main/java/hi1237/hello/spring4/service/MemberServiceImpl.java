package hi1237.hello.spring4.service;

import hi1237.hello.spring4.dao.MemberDAO;
import hi1237.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("msrv")
public class MemberServiceImpl implements MemberService{
// MemberServiceImpl에 대한 객체명을 msrv로 해줌
    @Autowired
    private MemberDAO mdao;
    @Override
    public boolean saveMember(Member m) {
        boolean isSaved = false;
        if ( mdao.insertMember(m) > 0)  isSaved = true;
        return isSaved;
    }

    @Override
    public boolean loginMember(Member m) {
        boolean isLogin = false;

        if(mdao.loginMember(m) != null)
            isLogin = true;


        return isLogin;

    }

    @Override
    public Member readOneMember(String userid) {
        return mdao.selectOneMember(userid);
    }


}
