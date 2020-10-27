package kr.co.study.web.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class BoardDTO {

	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	private String id;

	private String title;

	private String contents;

	private String regId;

	private LocalDate regDate;
}
