package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.WffLabReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class WffLabReplyMapperTest {

	private Long[] bnoArr = {23L,22L,21L,20L,4L};

	@Setter(onMethod_ = @Autowired)
	private WffLabReplyMapper mapper;

	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	@Test
	public void testCreate() { //댓글 등록
		IntStream.rangeClosed(1, 10).forEach(i -> {
			WffLabReplyVO vo = new WffLabReplyVO();
			vo.setBno(bnoArr[i%5]); 
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer"+ i);
			
			mapper.insert(vo);
		});
	}
	
	
	@Test
	public void testRead() { //댓글 상세조회
		Long targetRno = 20L;
		WffLabReplyVO vo = mapper.read(targetRno);
		log.info(vo); 
	}
	
	
	@Test
	public void testDelete() { //댓글 삭제
		Long targetRno = 3L;
		mapper.delete(targetRno);
	}
	
	
	@Test
	public void testUpdate() { //댓글수정
		Long targetRno = 72L;
		
		WffLabReplyVO vo = mapper.read(targetRno);
		vo.setReply("@@댓글 수정 테스트 와우~~@@");
		int count = mapper.update(vo); //수정처리 잘되면 카운트 1 
		log.info("UPDATE COUNT :" + count);
	}
	
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<WffLabReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[4]); //여기서 bno는 위 Long[] bnoArr로 하고있다.(1441838L)
		replies.forEach(reply -> log.info(reply));
		
	}

}
