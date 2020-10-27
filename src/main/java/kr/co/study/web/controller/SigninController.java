package kr.co.study.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.study.application.SignInService;
import kr.co.study.web.dto.JoinDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class SigninController {

	@Autowired
	PasswordEncoder passwordEncoder;

	private final SignInService service;

  @GetMapping("/signin")
  public String signin() {
    return "thymeleaf/signin";
  }

  @GetMapping(value = "/join")
  public String join(Model model, JoinDTO joinDTO) {
	  return "thymeleaf/page/join";
  }

  @PostMapping(value = "/userSave")
  public String userSave(@Valid @ModelAttribute JoinDTO joinDTO, BindingResult bindingResult) {

	  if (bindingResult.hasErrors()) {
	  	return "thymeleaf/page/join";
	  }
	  else {
//	  	String sId = joinDTO.getID();
//	  	String sName = joinDTO.getNAME();
//	  	String sPassword = passwordEncoder.encode(joinDTO.getPASSWORD());
//	  	JoinDTO setDto = new JoinDTO(sId, sName, sPassword);
	  	service.insertUser(joinDTO);
	  }

	  return "redirect:/";
  }
}

