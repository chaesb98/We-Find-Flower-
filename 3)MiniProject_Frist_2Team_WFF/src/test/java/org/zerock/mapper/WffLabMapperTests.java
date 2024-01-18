package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.WffLabVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WffLabMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private WffLabMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(wfflabboard -> log.info(wfflabboard));
	}

//	@Test
//	public void testInsert() {
//		// 데이터를 변수에 넣기
//		WffLabVO wfflabboard = new WffLabVO();
//		wfflabboard.setTitle("새로 작성하는 글 제목!");
//		wfflabboard.setContent("새로 작성하는 글 내용!");
//		wfflabboard.setWriter("김희선");
//		
//		mapper.insert(wfflabboard);
//		log.info(wfflabboard);
//	}
	
//	@Test
//	public void testInsertSelectKey() {
//		WffLabVO wfflabboard = new WffLabVO();
//		wfflabboard.setTitle("새로 작성하는 글 select key 제목");
//		wfflabboard.setContent("새로 작성하는 내용 select key 내용");
//		wfflabboard.setWriter("김연아");
//		
//		mapper.insertSelectKey(wfflabboard);
//		log.info(wfflabboard);
//	}
	
	@Test
	public void testRead() {
		// 이번 testRead() 메서드의 테스트 확인은 "기존에 있는 DB 데이터 정보 bno 값"을 활용합니다.
//		WffLabVO wfflabboard = mapper.read(8L);
//
//		log.info(wfflabboard);

		mapper.getList().forEach(wfflabboard -> log.info(wfflabboard));
	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		List<WffLabVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(wfflabboard -> log.info(wfflabboard));
	}
	
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("22");
		cri.setType("TC");
		
		List<WffLabVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(wfflabboard -> log.info(wfflabboard));
	}

	
	
	@Test
	public void testDelete() {
		log.info("삭제 처리 리턴값 : delete count : " + mapper.delete(8L));
	}
	
	@Test
	public void testUpdate() {
		WffLabVO wfflabboard = new WffLabVO();
		// 수정하기 위한 게시글번호(bno)가 있는 DB 데이터를 활용합니다!
		wfflabboard.setBno(5L);
		wfflabboard.setTitle("5번글 testUpdate() 메서드 활용 제목 수정 와우!");
		wfflabboard.setContent("5번글 testUpdate() 메서드 활용 내용 수정 와우!");
		wfflabboard.setWriter("고윤정");
		
		int count = mapper.update(wfflabboard);
		log.info("UPDATE COUNT :" + count);
	}

}
