package kr.co.study.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.study.domain.Board;
import kr.co.study.repository.BoardMapper;
import kr.co.study.web.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService{

	private final BoardMapper boardMapper;

	@Transactional(readOnly = true)
	public List<BoardDTO> selectBoardList() {
		List<BoardDTO> rtnList = new ArrayList<BoardDTO>();
		List<Board> boardList = boardMapper.selectBoardList();

		rtnList = boardList.stream()
					.map(board -> BoardDTO.builder()
								.id(board.getId())
								.title(board.getTitle())
								.contents(board.getContents())
								.regId(board.getRegId())
								.regDate(board.getRegDate())
								.build())
					.collect(Collectors.toList());
		return rtnList;
	}

	@Transactional(readOnly = true)
	public BoardDTO selectBoardById( String sId ) {
		BoardDTO rtnDto = new BoardDTO();
		Board board = boardMapper.selectBoardById(sId);

		rtnDto = BoardDTO.builder()
			.id(board.getId())
			.title(board.getTitle())
			.contents(board.getContents())
			.build();

		return rtnDto;
	}
}
