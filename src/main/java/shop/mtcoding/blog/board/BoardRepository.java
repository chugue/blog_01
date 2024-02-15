package shop.mtcoding.blog.board;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager em;


    public Board findById(int id) {
        Query query = em.createNativeQuery("select * from board_tb join fetch user_tb ut where b.id = :id", Board.class);
        query.setParameter("id", id);

        Board board = (Board)query.getSingleResult();
        return board;
    }
}
