package hi1237.hello.spring4.dao;

import hi1237.hello.spring4.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("bdao")
// 여기에 bdao를 써주니 BoardDAOUnitTest의 bdao의 빨간줄이 사라짐
public class BoardDAOImpl implements BoardDAO {

    @Value("#{sql['selectBoard']}")
    private String selectSQL;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Board> selectBoard(int snum) {

        Object[] params = new Object[]{snum};
        RowMapper<Board> mapper = new SelectMapper();

        return jdbcTemplate.query(selectSQL, params, mapper);
    }

    public class SelectMapper implements RowMapper<Board> {

        @Override
        public Board mapRow(ResultSet rs, int num) throws SQLException {
            Board bd = new Board(rs.getString(1),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    null);

            return bd;
        }

    }
}
