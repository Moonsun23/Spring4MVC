package hi1237.hello.spring4.dao;

import hi1237.hello.spring4.model.Member;

public interface MemberDAO {

    int insertMember(Member m);
    Member loginMember(Member m);
    Member selectOneMember(String userid);


}
