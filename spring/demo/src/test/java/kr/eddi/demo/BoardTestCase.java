package kr.eddi.demo;

import kr.eddi.demo.entity.test.Comment;
import kr.eddi.demo.entity.test.TestBoard;
import kr.eddi.demo.entity.test.TestStudent;
import kr.eddi.demo.entity.test.response.CommentResponse;
import kr.eddi.demo.repository.test.CommentRepository;
import kr.eddi.demo.repository.test.TestBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BoardTestCase {

    @Autowired
    private TestBoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    // Non-Builder
    @Test
    void createBoard () {
        TestBoard board = new TestBoard("아래 글 적은 ㅅㄲ 봐라", "응 너도 낚임 ㅋㅋㅋ");

        boardRepository.save(board);
    }

    // Non-Builder
    @Test
    void writeComment () {
        Optional<TestBoard> maybeBoard = boardRepository.findById((long) 2);
        TestBoard board = maybeBoard.get();

        Comment comment = new Comment("이ㅅㄲ도 낚시 선수네!");

        // 개고수는 set 따윈 안써요.
        board.setComment(comment);
        boardRepository.save(board);

        commentRepository.save(comment);
    }

    @Test
    void buildBoard () {
        TestBoard board = TestBoard.builder()
                            .title("빌더")
                            .content("비일더")
                            .build();

        boardRepository.save(board);
    }

    @Test
    void buildComment () {
        Optional<TestBoard> maybeBoard = boardRepository.findById((long) 3);
        TestBoard board = maybeBoard.get();

        Comment comment = Comment.builder()
                            .content("셋터 치워! 빌더를 이용한 댓글")
                            .testBoard(board)
                            .build();

        commentRepository.save(comment);
    }

    @Test
    void findCommentsOnSpecificBoard () {
        List<Comment> commentList = commentRepository.findAllCommentsByBoardId((long) 3);
        List<CommentResponse> commentResponses = new ArrayList<>();

        for (Comment comment : commentList) {
            commentResponses.add(new CommentResponse(comment.getContent()));
        }

        System.out.println(commentResponses);
    }

    @Test
    void modifyCommentsOnBoard () {
        Optional<Comment> maybeComment = commentRepository.findById((long) 6);
        Comment comment = maybeComment.get();

        comment.modifyContent("이러쿵 저러쿵 요러쿵");

        commentRepository.save(comment);
    }

    @Test
    void deleteCommentsOnBoard () {
        commentRepository.deleteById((long) 5);
    }

    @Test
    void deleteBoard () {
        List<Comment> commentList = commentRepository.findAllCommentsByBoardId((long) 1);

        for (Comment comment : commentList) {
            commentRepository.delete(comment);
        }

        boardRepository.deleteById((long) 1);
    }
}
