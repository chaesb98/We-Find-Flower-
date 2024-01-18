package org.zerock.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {
	
	private MemberService memberservice;
	
	// 로그인
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id")String id, @RequestParam("password") String password, HttpServletRequest req) throws Exception {
		MemberVO login = memberservice.login(id, password);
		
		if(login != null) {
			HttpSession session = req.getSession(); // 잘못적어도 session이 생긴다. 위치를 if문 안으로 이동
			
			session.setAttribute("member", login);
			log.info(login);
		}
		return "redirect:/pages/main";
		
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/member/login";
	}
	
	
	// 회원 가입
	@GetMapping("/join")
	public void register() {
		
	}
	
	@PostMapping("/join")
	public String register(MemberVO member, RedirectAttributes rttr) {
		log.info("regiser(가입): " + member);
		memberservice.register(member);
		rttr.addFlashAttribute("result", member.getId());
		//redirect : 갱신해서 보내줌
		return "redirect:/pages/main";
	}
	
	// 회원 정보 수정
	@GetMapping("/edit")
	public void edit() {
		
	}
	
	@PostMapping("/edit")
	public String modify(MemberVO member, RedirectAttributes rttr, HttpServletRequest request) {
		
			memberservice.modify(member);
		    rttr.addFlashAttribute("result", member.getId());	
			return "redirect:/pages/main";
		}
	
	// 회원 계정 삭제(탈퇴)
	@GetMapping(value="/leave")
	public void leave(){
	}
	
	
	@PostMapping(value="/leave")
	public String remove(@RequestParam("id") String id, @RequestParam("password") String password, RedirectAttributes rttr) {
		log.info("remove: 삭제 처리 " + id+", "+password);
		// BoardController의 remove() 메서드는 삭제 후 페이지의 이동이 필요하므로
		// RedirectAttributes를 파라미터로 사용하고, 'redirect'를 이용해서
		// 삭제 처리 후에 다시 목록 페이지로 이동 처리 합니다.		
		if(memberservice.deleteMember(id, password)) {
			rttr.addFlashAttribute("result", "success");
			
		}else {
			rttr.addFlashAttribute("result", "false");
			
		}
		return "redirect:/member/login";
	}
	
	//회원 아이디 찾기
	@GetMapping("/findId")
	public void findId() {

	}
	
	@PostMapping("/findId")
	public void findId(@RequestParam("name") String name, @RequestParam("email") String email, Model model) {
		log.info("Post find Id....");
		log.info("name input : "+name+" email input : "+email);
		
		List<MemberVO> userIdList = memberservice.findId(name, email);
		if(userIdList.size()==0 || userIdList == null) {
			model.addAttribute("fail",0);
		}else {
			log.info("user Id = "+userIdList);
			
			Set<String> regIdSet = new HashSet<String>();
			
			for(MemberVO memberList : userIdList) {
				log.info("userId : "+memberList.getId());
				
				for(int i=0;i<userIdList.size();i++) {
					regIdSet.add(memberList.getId());
				}
			}
			log.info("regIdSetset : "+regIdSet);
			
			model.addAttribute("success",1);
			model.addAttribute("userid", regIdSet);
		}
	}

	//회원 비밀번호 찾기
	@GetMapping("/findPwd")
	public void findPwd() {

	}
	
	@PostMapping("/findPwd")
	public void findPwd(@RequestParam("id") String id, @RequestParam("email") String email, Model model) {
		log.info("Post Find Pwd...");
		log.info("id input : "+id+" email input : "+email);
		
		List<MemberVO> userPwdList = memberservice.findPwd(id, email);
		if(userPwdList.size()==0 || userPwdList == null) {
			model.addAttribute("fail",0);
		}else {
			log.info("user Pwd = "+userPwdList);
			
			Set<String> regPwdSet = new HashSet<String>();
			
			for(MemberVO memberList : userPwdList) {
				log.info("findPwd : "+memberList.getPassword());
				
				for(int i=0;i<userPwdList.size();i++) {
					regPwdSet.add(memberList.getPassword());
				}
			}
			log.info("regPwdSetset : "+regPwdSet);
			
			model.addAttribute("success",1);
			model.addAttribute("userPwd", regPwdSet);
		}
	}


}
