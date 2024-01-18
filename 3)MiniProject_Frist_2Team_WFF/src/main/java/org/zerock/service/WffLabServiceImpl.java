package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.WffLabVO;
import org.zerock.mapper.WffLabMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service  // 계층 구조상 주로 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용함.
@AllArgsConstructor
public class WffLabServiceImpl implements WffLabService {
	
	private WffLabMapper mapper;
	
	@Override
	public WffLabVO get(Long bno) {
		log.info("get... 특정 글 내용을 조회 합니다!" + bno);
		return mapper.read(bno);
	}
	
	// 게시글 등록
	@Override
	public void register(WffLabVO wfflabboard) {
		log.info("register 게시글등록 서비스 실행!" + wfflabboard);
		mapper.insertSelectKey(wfflabboard);
	}

	// 게시글 수정
	@Override
	public boolean modify(WffLabVO wfflabboard) {
		log.info("modify... 게시글을 수정 처리합니다!" + wfflabboard);
		return mapper.update(wfflabboard) == 1;
	}

	// 게시글 삭제
	@Override
	public boolean remove(Long bno) {
		log.info("remove... 게시글을 삭제 처리 합니다!" + bno);
		// 정상적으로 삭제가 이루어지면 1이라는 값이 반환되기 때문에
		// '==' 연산자를 이용해서 true/false를 처리할 수 있습니다.
		return mapper.delete(bno) == 1;
	}

	
	@Override
	public List<WffLabVO> getList(Criteria cri) {
		log.info("get List with criteria: "+cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}


		
}


