package hi1237.hello.spring4.service;

import hi1237.hello.spring4.model.Board;

import java.util.List;

public interface BoardService {

  // 서비스에서는...  현재페이지를 넘겨주면 시작페이지를 기준으로 .....?????
    List<Board> readBoard(int cpg);

     Board readOneBoard(String bno);
}
