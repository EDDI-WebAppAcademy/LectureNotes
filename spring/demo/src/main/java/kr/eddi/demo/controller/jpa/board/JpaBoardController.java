package kr.eddi.demo.controller.jpa.board;

import kr.eddi.demo.controller.jpa.board.request.BoardRequest;
import kr.eddi.demo.entity.jpa.boards.Board;
import kr.eddi.demo.service.jpa.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("39th/jpa/board")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaBoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public List<Board> boardList () {
        log.info("boardList()");

        return service.list();
    }

    @PostMapping("/register")
    public void boardRegister (@RequestBody BoardRequest boardRequest) {
        log.info("boardRegister()");

        service.register(boardRequest);
    }

    @GetMapping("/{boardNo}")
    public Board boardRead (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRead()");

        return service.read(boardNo);
    }

    @DeleteMapping("/{boardNo}")
    public void boardRemove (@PathVariable("boardNo") Long boardNo) {
        log.info("boardRemove()");

        service.remove(boardNo);
    }

    @PutMapping("/{boardNo}")
    public Board boardModify (@PathVariable("boardNo") Long boardNo, @RequestBody Board board) {
        log.info("boardModify()");

        board.setBoardNo(boardNo);
        service.modify(board);

        return board;
    }
}
