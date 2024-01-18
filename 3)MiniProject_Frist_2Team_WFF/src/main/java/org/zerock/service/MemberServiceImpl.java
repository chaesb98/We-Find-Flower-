package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service  // 계층 구조상 주로 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용함.
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper membermapper;

	@Override
	public MemberVO get(String id) {
		return membermapper.read(id);
	}
	
	// 로그인
	@Override
	public MemberVO login(String id, String password) {
		log.info("login name : "+membermapper.login(id, password));
		return membermapper.login(id, password);
	}
	
	// 회원 가입
	@Override
	public void register(MemberVO member) {
		log.info("register 회원가입 서비스 실행!" + member);
		membermapper.insert(member);
	}

	// 회원 정보 수정
	@Override
	public boolean modify(MemberVO member) {
		return membermapper.update(member) == 1;
	}
	
	// 회원 계정 삭제(탈퇴)
	@Override
	public boolean deleteMember(String id, String password) {
		return membermapper.deleteMember(id, password)==1;
	}
	
	// 회원 아이디 찾기
	@Override
	public List<MemberVO> findId(String name, String email) {
		log.info("find Id : "+ name+ email);
		return membermapper.findId(name, email);
	}

	// 회원 비밀번호 찾기
	@Override
	public List<MemberVO> findPwd(String id, String email) {
		log.info("회원 비밀번호 찾기 : " + id +email);
		return membermapper.findPwd(id, email);
	}

		
}


