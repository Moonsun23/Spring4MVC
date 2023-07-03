package hi1237.hello.spring4.dao;

import hi1237.hello.spring4.model.Board;

import java.util.List;

public interface BoardDAO {
    List<Board> selectBoard(int snum);
    Board selectOneBoard(String bno);

    int insertBoard(Board bd);
    // sql의 board (title, userid, contents) 부분을 Board bd로 가져옴. 클래스화 하여
}
