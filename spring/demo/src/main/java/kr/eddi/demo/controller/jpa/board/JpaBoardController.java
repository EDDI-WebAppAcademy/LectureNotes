package kr.eddi.demo.controller.jpa.board;

import kr.eddi.demo.entity.jpa.boards.Board;
import kr.eddi.demo.service.jpa.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
