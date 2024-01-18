package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.WffLabVO;

public interface WffLabService {

	// register = insert
	public void register(WffLabVO wfflabboard);
	// get = 상세보기
	public WffLabVO get(Long bno);
	// modify = update
	public boolean modify(WffLabVO wfflabboard);
	// remove = delete
	public boolean remove(Long bno);
	
	
	// Page299 : 페이징 처리가 적용되는 getList() 메서드 선언
	public List<WffLabVO> getList(Criteria cri);
	
	//323p : 전체 데이터스를 구해주는 getTotal()메서드 선언
	public int getTotal(Criteria cri);

}

