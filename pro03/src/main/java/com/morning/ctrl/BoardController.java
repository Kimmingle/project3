package com.morning.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.morning.biz.BoardBiz;
import com.morning.domain.Board;

@Controller
@RequestMapping("/board/") //모든 메서드는 /board/로 시작하는 URL 요청을 처리
public class BoardController {

	@Autowired
	private BoardBiz boardService;  // 게시판 비즈니스 로직을 처리하기위한 객체
	
	@RequestMapping("list.do")
	public String getBoardList(Model model) { 
		model.addAttribute("list", boardService.getBoardList());  //모든 게시물 리스트 가져와서 모델에 추가
		return "board/list";   //board의 list뷰 반환
	}
	
	@RequestMapping("detail.do")
	public String getBoard(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", boardService.getBoard(bno));
		return "board/get";
	}

	@GetMapping("insert.do")
	public String insBoard(Board board, Model model) {
		return "board/insert";
	}
	
	@PostMapping("insertPro.do")
	public String insBoardPro(Board board, Model model) {
		boardService.insBoard(board);
		return "redirect:list.do";  //위에있는 list.do 메서드를 수행하는건가?
	}

	@GetMapping("update.do")
	public String upBoard(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", boardService.getBoard(bno));
		return "board/edit";
	}
	
	@PostMapping("updatePro.do")
	public String upBoardPro(@RequestAttribute("board") Board board, Model model) {
		boardService.upBoard(board);
		return "redirect:list.do";
	}
	
	@RequestMapping("delBoard.do")
	public String delBoard(@RequestParam("bno") int bno, Model model) {
		boardService.delBoard(bno);
		return "redirect:list.do";
	}
}
