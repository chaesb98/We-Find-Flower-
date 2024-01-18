package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.MemberVO;

public interface MemberService {
	
	public MemberVO get(String id);
	
	// 로그인
	public MemberVO login(@Param("id") String id, @Param("password") String password);

	// 회원 가입 register = insert
	public void register(MemberVO member);
	
	// 회원 정보 수정 modify = update
	public boolean modify(MemberVO member);
	
	// 회원 계정 삭제(탈퇴) remove = delete
	public boolean deleteMember(@Param("id") String id, @Param("password") String password);
	
	// 회원 아이디 찾기
	public List<MemberVO> findId(@Param("name")String name, @Param("email") String email);
	
	// 회원 비밀번호 찾기
	public List<MemberVO> findPwd(@Param("id")String id, @Param("email") String email);
	
}

