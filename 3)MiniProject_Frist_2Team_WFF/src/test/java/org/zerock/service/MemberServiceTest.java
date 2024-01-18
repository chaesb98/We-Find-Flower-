package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTest {

	@Setter(onMethod_ = {@Autowired})
	private MemberService service;
	
	
	@Test
	public void testGet() {
		// 1번 글의 상세 정보를 로그 정보로 표시해 줍니다.
		log.info(service.get("TestID"));
	}
	
	// 등록(regiter) 직업의 기능 구현과 테스트
	@Test
	public void testRegister() {
		MemberVO member = new MemberVO();
		member.setId("difoasf");
		member.setPassword("sadglkh");
		member.setName("김정민");
		member.setEmail("test3@hanmail.net");
		member.setAddress1("서울");
		
		service.register(member);
		log.info("BoardServiceTests에서 생성된 게시물의 번호 :" + member.getId());
	}

	
	@Test
	public void testModify() {
		// testModify()의 경우, 특정한 게시글(여개서는 1번글)을 먼저 조회하고,
		MemberVO member = service.get("TestID1"); // 1번 글 수정 처리
		if (member == null) {
			return;
		}
		// 조회한 게시글을 수정합니다.
	    member.setName("김사랑");
	    member.setPassword("4256");
	    member.setEmail("kimlove@gmail.com");
	    member.setAddress1("서울");
	    
	    service.modify(member);
	}
	

	
	@Test
    public void testFindId() {
		MemberVO member = new MemberVO();
		member.setName("테스트");
		member.setEmail("test@gmail.com");
		log.info("아이디 찾기 : "+service.findId(member.getName(), member.getEmail()));
	}


	
	@Test
    public void testFindPwd() {
		MemberVO member = new MemberVO();
		member.setId("TestID4");
		member.setEmail("test@gmail.com");
		log.info("비밀번호 찾기 : "+service.findPwd(member.getId(), member.getEmail()));
	}

}
