package kr.eddi.demo.entity.test;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ClassRoom {

    @Id
    @Column(name = "class_room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classRoomId;

    private String roomName;

    public ClassRoom (String roomName) {
        this.roomName = roomName;
    }
}
