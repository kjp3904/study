package kr.co.study.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.study.domain.Account;
import kr.co.study.web.dto.JoinDTO;

@Repository
@Mapper
public interface SignMapper {
	Account selectUserById(String id);

	Integer insertUser(JoinDTO join);
}
