package spring.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.board.entity.Board;
import spring.board.repository.BoardRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board join(Board board) {
        boardRepository.save(board);
        return board;
    }

    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    @Transactional
    public void update(Long boardId, Board updateParam) {
        Board findBoard = boardRepository.findById(boardId).orElse(null);
        findBoard.change(updateParam.getTitle(), updateParam.getContent());
    }

    @Transactional
    public void delete(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
