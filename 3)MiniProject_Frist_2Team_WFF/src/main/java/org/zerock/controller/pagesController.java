package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/pages/*")
@AllArgsConstructor
public class pagesController {
	
	
	// 메인
	@GetMapping("/main")
	public void main() { 
		
	}
	
	// 회사소개(브랜드소개)
	@GetMapping("/about")
	public void about() {
		
	}

	// 자주묻는질문
	@GetMapping("/faq")
	public void faq() { 

	}

}
