package kr.co.study.web.controller;




import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.study.application.BoardService;
import kr.co.study.web.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

//	@Autowired
//	PasswordEncoder passwordEncoder;

	private final BoardService service;

	@GetMapping("/list")
	public String list( Model model, BoardDTO boardDTO ) {

		List<BoardDTO> boardList = service.selectBoardList();

		model.addAttribute("boardList", boardList);

		return "thymeleaf/page/board/list";
  	}

	@GetMapping("/view/{id}")
	public String view( @PathVariable("id") String sId, Model model, BoardDTO boardDTO, HttpServletRequest request ) {

		boardDTO = service.selectBoardById(sId);

		model.addAttribute("boardDTO", boardDTO);

		return "thymeleaf/page/board/view";
  	}

	@PostMapping("/modify")
	public String modify( Model model, BoardDTO boardDTO, HttpServletRequest request ) {

		boardDTO = service.selectBoardById(request.getParameter("id"));

		model.addAttribute("boardDTO", boardDTO);

		return "thymeleaf/page/board/modify";
  	}

	@PostMapping("/delete")
	public String delete( Model model, BoardDTO boardDTO, HttpServletRequest request ) {

		boardDTO = service.selectBoardById(request.getParameter("id"));

		model.addAttribute("boardDTO", boardDTO);

		return "thymeleaf/page/board/modify";
  	}
}

