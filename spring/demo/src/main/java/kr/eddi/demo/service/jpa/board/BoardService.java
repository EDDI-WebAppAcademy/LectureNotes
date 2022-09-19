package kr.eddi.demo.service.jpa.board;

import kr.eddi.demo.entity.jpa.boards.Board;

import java.util.List;

public interface BoardService {
    public void register(Board board);
    public List<Board> list();
    public Board read(Integer boardNo);
    public void modify(Board board);
    public void remove(Integer boardNo);
}
