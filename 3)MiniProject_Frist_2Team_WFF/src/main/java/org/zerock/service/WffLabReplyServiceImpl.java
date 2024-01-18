package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.WffLabReplyPageDTO;
import org.zerock.domain.WffLabReplyVO;
import org.zerock.mapper.WffLabMapper;
import org.zerock.mapper.WffLabReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class WffLabReplyServiceImpl implements WffLabReplyService{
	
	@Setter(onMethod_ = @Autowired)
	private WffLabReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private WffLabMapper boardmapper;
	
	// 댓글 등록
	@Transactional
	@Override
	public int register(WffLabReplyVO vo) {
		log.info("register 댓글 등록처리 성공!"+vo);
		boardmapper.updateReplyCnt(vo.getBno(), 1); //댓글 1개를 늘려라 (추가)
		return mapper.insert(vo);
	}

	// 댓글 상세보기
	@Override
	public WffLabReplyVO get(Long rno) {
		log.info("get 댓글 상세 보기 : "+ rno);
		return mapper.read(rno);
	}
	
	// 댓글 수정
	@Override
	public int modify(WffLabReplyVO vo) {
		log.info("modify 댓글 수정 처리 : "+ vo);
		return mapper.update(vo);
	}

	// 댓글 삭제
	@Transactional
	@Override
	public int remove(Long rno) {
		log.info("remove 댓글 삭제 처리 : " + rno);
	      // Page485 다음 2줄 소스 추가 코딩해 줍니다.
		WffLabReplyVO vo = mapper.read(rno);
		boardmapper.updateReplyCnt(vo.getBno(), -1);
		
		return mapper.delete(rno);
	}

	@Override
	public List<WffLabReplyVO> getList(Criteria cri, Long bno) {
		log.info("get Reply List of a Board : 특정 게시글의 댓글 내용들 리스트 출력" + bno);
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public WffLabReplyPageDTO getListPage(Criteria cri, Long bno) {
		return new WffLabReplyPageDTO(mapper.getCountByBno(bno),mapper.getListWithPaging(cri, bno));
	}

	
}
