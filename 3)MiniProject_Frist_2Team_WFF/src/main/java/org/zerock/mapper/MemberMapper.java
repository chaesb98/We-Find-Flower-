package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.MemberVO;

public interface MemberMapper {

//	public MemberVO get(String id);
	
	public List<MemberVO> getList();
	
	// 로그인
	public MemberVO login(@Param("id") String id, @Param("password") String password);
	
	// read(select) 처리를 위한 read() 추상 메서드 정의
	public MemberVO read(String id);

	// 회원 가입
	public void insert(MemberVO member);
	
	// 회원 정보 수정
	public int update(MemberVO member);
	
	// 회원 계정 삭제(탈퇴) 처리를 위한 delete() 추상 메서드 정의
	public int deleteMember(@Param("id") String id, @Param("password") String password);

	// 회원 아이디 찾기
	public List<MemberVO> findId(@Param("name")String name, @Param("email") String email);
	
	// 회원 비밀번호 찾기
	public List<MemberVO> findPwd(@Param("id") String id, @Param("email") String email);
	
	
}
