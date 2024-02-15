package shop.mtcoding.blog.board;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import shop.mtcoding.blog.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name= "board_tb")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

    @ManyToOne
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
