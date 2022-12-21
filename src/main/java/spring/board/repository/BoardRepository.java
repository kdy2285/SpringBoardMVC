package spring.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByTitleContaining(String title, Pageable pageable);
}
