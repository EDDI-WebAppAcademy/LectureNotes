package kr.eddi.demo.entity.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestBoard {
    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @OneToMany(mappedBy = "testBoard", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    public TestBoard (String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setComment (Comment comment) {
        comments.add(comment);
        comment.setTestBoard(this);
    }
}
