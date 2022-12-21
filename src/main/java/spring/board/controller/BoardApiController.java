package spring.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.board.entity.Board;
import spring.board.repository.BoardRepository;
import spring.board.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping("/boards")
    List<Board> all() {
        return boardRepository.findAll();
    }

    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @PostMapping("/boards")
    Board newBoard(@RequestBody Board newBoard) {
        return boardService.join(newBoard);
    }

    @PutMapping("/boards/{id}")
    Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {

        Board findBoard = boardRepository.findById(id).orElse(null);
        if (findBoard == null) {
            boardService.join(newBoard);
        } else {
            newBoard.setId(id);
            boardService.update(id, newBoard);
        }
        return newBoard;
    }

    @DeleteMapping("/boards/{id}")
    void deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
    }
}
