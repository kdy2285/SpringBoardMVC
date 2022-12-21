package spring.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.board.entity.Board;
import spring.board.repository.BoardRepository;
import spring.board.service.BoardService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model,@PageableDefault(size = 10) Pageable pageable,
                       @RequestParam(required = false, defaultValue = "") String searchText) {
        //Page<Board> boards = boardRepository.findAll(pageable);
        Page<Board> boards = boardRepository.findByTitleContaining(searchText, pageable);

        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 5);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 5);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/add")
    public String addForm() {
        return "board/addForm";
    }

    @PostMapping("/add")
    public String addBoard(@ModelAttribute Board board) {
        boardService.join(board);
        return "redirect:/board/list";
    }

    @GetMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, Model model) {
        Board board = boardRepository.findById(boardId).orElse(null);
        model.addAttribute("board", board);
        return "board/editForm";
    }

    @PostMapping("/{boardId}/edit")
    public String edit(@PathVariable Long boardId, @ModelAttribute Board board) {
        boardService.update(boardId, board);
        return "redirect:/board/list";
    }

    @DeleteMapping("{boardId}/delete")
    public String delete(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return "redirect:/board/list";
    }
}
