package kr.co.study.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.study.web.dto.JoinDTO;

@Repository
@Mapper
public interface MainMapper {
	Integer selectUserCount();
}
