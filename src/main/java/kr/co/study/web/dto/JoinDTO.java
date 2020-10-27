package kr.co.study.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class JoinDTO {

	@NotEmpty(message=" 아이디를 입력해 주세요. ")
	private String ID;

	@NotEmpty(message=" 이름을 입력해 주세요. ")
	private String NAME;

	@Size(min=2, max=12, message=" 비밀번호를 입력해 주세요. ")
	private String PASSWORD;

//	@Builder
//	public JoinDTO(String ID, String NAME, String PASSWORD) {
//		// TODO Auto-generated constructor stub
//		this.ID = ID;
//		this.NAME = NAME;
//		this.PASSWORD = PASSWORD;
//	}

}
