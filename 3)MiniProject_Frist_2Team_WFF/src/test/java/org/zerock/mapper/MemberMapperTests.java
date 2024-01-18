package org.zerock.mapper;

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
public class MemberMapperTests {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper membermapper;
	
	@Test
	public void testLogin() {
		MemberVO member = new MemberVO();
		member.setId("TestID4");
		member.setPassword("1234");
		log.info("login name : "+membermapper.login(member.getId(), member.getPassword()));
	}
	

	@Test
	public void testInsert() {
		MemberVO member = new MemberVO();
		member.setId("test999");
		member.setPassword("1234");
		member.setName("채승병");
		member.setEmail("test@daum.net");
		member.setAddress1("서울시 구로구");
		member.setAddress2("경인로 557");
		member.setAddress3("삼영빌딩 4층");
		
		membermapper.insert(member);
		log.info(member);
	}
	
	@Test
	public void testInsertSelectKey() {
		MemberVO member = new MemberVO();
		member.setId("testid");
		member.setPassword("1234");
		member.setName("김시험");
		member.setEmail("test@daum.net");
		member.setAddress1("서울시 구로구");
		member.setAddress2("경인로 557");
		member.setAddress3("삼영빌딩 4층");
		
		log.info(member);
	}
	

	@Test
	public void testUpdate() {
		MemberVO member = new MemberVO();
		// 수정하기 위한 게시글번호(bno)가 있는 DB 데이터를 활용합니다!
		member.setId("TestID3");
		member.setPassword("te우!");
		member.setEmail("te수정 와우!");
		member.setName("고윤정");
		member.setAddress1("서울시 구로구");
		member.setAddress2("경인로 557");
		member.setAddress3("삼영빌딩 4층");
		
		int count = membermapper.update(member);
		log.info("UPDATE COUNT : " + count);
	}
	

	@Test
	public void testFindId() {
		MemberVO member = new MemberVO();
		member.setName("테스트");
		member.setEmail("test@gmail.com");
		log.info("findId : "+membermapper.findId(member.getName(), member.getEmail()));
	}
	
	@Test
	public void testFindPwd() {
		MemberVO member = new MemberVO();
		
		member.setId("TestID4");
		member.setEmail("test@gmail.com");
		
		log.info("Find memberPwd: " + membermapper.findPwd(member.getId(), member.getEmail()));
	}
	

}
