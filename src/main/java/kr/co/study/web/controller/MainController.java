package kr.co.study.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.study.application.MainService;
import kr.co.study.web.dto.JoinDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

	@Autowired
	PasswordEncoder passwordEncoder;

	private final MainService service;

	@RequestMapping(value = {"/"})
	public String index(Model model, HttpSession session) {


//		log.info("!@!@>> Id:    " + user.getId());

//		session.setAttribute("name", "kjp3904");

		return "thymeleaf/page/index";
	}

	@RequestMapping(value = "/dataSearch.do", method = RequestMethod.POST)
	public String dataSearch(Model model, JoinDTO dto) {
		System.out.println("11111111111111111222222222222222");
//		System.out.println("!@!@>> ID:  " + dto.getID());
//		System.out.println("!@!@>> NAME:  " + dto.getNAME());

		List testList = new ArrayList();
		Map testMap = new HashMap();

		testMap.put("ID", "kjp3904");
		testMap.put("NAME", "김진표");
		testMap.put("TEL_NO", "010-5555-9999");

		Map testMap2 = new HashMap();

		testMap2.put("ID", "kjp39041");
		testMap2.put("NAME", "김진표1");
		testMap2.put("TEL_NO", "010-4444-1111");

		testList.add(testMap);
		testList.add(testMap2);

		model.addAttribute("hello", "회원가입!!@@");
		model.addAttribute("testList", testList);


//		return "thymeleaf/join :: #list";
		return "thymeleaf/join";
	}



}
