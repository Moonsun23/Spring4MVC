package hi1237.hello.spring4.controller;


import hi1237.hello.spring4.model.Board;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import hi1237.hello.spring4.service.BoardService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService bsrv;
    private Logger logger = LogManager.getLogger(BoardController.class);

    @GetMapping("/list")
    public String list(Model m, int cpg) {
            logger.info("board/list 호출!!");

        m.addAttribute("boards", bsrv.readBoard(cpg));
//        m.addAttribute("psnum", );     //페이지네이션 스타트 넘버의 약자 // 페이지네이션 시작 번호
//        m.addAttribute("allpg", ???);       // 총 페이지 수
            return "board/list.tiles";

        }
    @GetMapping("/write")
    public String write(HttpSession sess) {
        logger.info("board/write 호출!!");

        return "board/write.tiles";

    }

    @PostMapping ("/write")
    public String writeok(Board bd){
        logger.info("board/writeok 호출!!");
        String returnPage="redirect:/board/fail";

        if (bsrv.saveBoard(bd))
        returnPage = "redirect:/board/list?cpg=1";

        return returnPage;

    }


    @GetMapping("/view")
    public String view(Model m, String bno) {
        logger.info("board/view 호출!!");
        Board board = bsrv.readOneBoard(bno);

        m.addAttribute("board", board);

        return "board/view.tiles";

    }
}
