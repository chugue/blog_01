package shop.mtcoding.blog.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    @Column(length=60, nullable = false)
    private String password;

    private String email;
}