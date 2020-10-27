package kr.co.study.domain;

import java.io.Serializable;
import java.time.LocalDate;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Board implements Serializable {

	private static final long serialVersionUID = 5030778095514659860L;

	@NonNull
	private String id;

	@NonNull
	private String title;

	@NonNull
	private String contents;

	@NonNull
	private String regId;

	@NonNull
	private LocalDate regDate;

}
