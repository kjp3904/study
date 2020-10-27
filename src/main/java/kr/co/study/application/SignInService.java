package kr.co.study.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.study.domain.Account;
import kr.co.study.repository.SignMapper;
import kr.co.study.web.dto.JoinDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignInService implements UserDetailsService{

	private final SignMapper signMapper;

	@Autowired
	PasswordEncoder passwordEncoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Account account = signMapper.selectUserById(username);
		if(account == null) {
			throw new UsernameNotFoundException("사용자 정보가 존재하지 않습니다.");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

//		log.info("!@!@>> pw:  " + account.getPassword());
//		log.info("!@!@>> encode:  " + passwordEncoder.encode(account.getPassword()));
//		account.setPassword(account.getPassword());

		return account;
	}

	public Integer insertUser(JoinDTO join) {
		log.info("SignInService.insertUser!!");

		return signMapper.insertUser(join);
	}
}
