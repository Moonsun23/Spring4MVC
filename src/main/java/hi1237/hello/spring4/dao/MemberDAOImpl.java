package hi1237.hello.spring4.dao;

import hi1237.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("mdao")


public class MemberDAOImpl implements MemberDAO{
    // sql.properties에 작성한 sql 불러우기
    @Value("#{sql['insertMember']}") private String insertSQL;
    @Value("#{sql['loginMember']}") private String loginSQL;


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertMember(Member m) {
        // 매개변수 정의
        Object[] params = new Object[]{
                m.getUserid(), m.getPasswd(), m.getName(), m.getEmail()
        };
        // 쿼리 실행: update(sql문, 매개변수)
        return jdbcTemplate.update(insertSQL, params);
    }

    public Member loginMember(Member m) {
        // 매개변수 정의
        Object[] params = new Object[]{
                m.getUserid(), m.getPasswd()
        };

        /// 로그인 매퍼 선언 - 콜백 함수
                RowMapper<Member> mapper = new LoginMapper();

        // 쿼리 실행: queryForObject(sql문, 매개변수,  Mapper) - 단일값 반환하는 실행문(?)
        return jdbcTemplate.queryForObject(loginSQL, params, mapper);
    }

    private class LoginMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int num) throws SQLException {
            Member m = new Member();

            m.setUserid(rs.getString(1));
            m.setName(rs.getString(2));

            return m;

            // 콜백함수 : 헐리우드 여배우를 모집하려고 공고를 냈다. 배우지망생 모두 몰려들어 오디션을 봤다.
            // 오디션을 본 사람이 나 합격했냐고 계속 연락해서 회사 업무가 진행이 안된다..
            // 그래서 우리가 합격한 사람한테 연락을 주겟다.........
            // 그럼 그때  같이 일한다..
            //--------------------------------------------
            // 달걀 익을때까지 냄비 앞에서 기다리는거.. 혹은 타이머를 맞춰놓고 나 할일 하다가 타이머가 울리면 가는것..
            //
        }
    }
}
