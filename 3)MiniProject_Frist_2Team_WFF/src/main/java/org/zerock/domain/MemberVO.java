package org.zerock.domain;

import lombok.Data;

@Data
public class MemberVO {

	private String id; // 멤버 아이디 필드 선언
	private String password; // 멤버 비밀번호 필드 선언
	private String email; // 멤버 이메일 필드 선언
	private String name;  // 멤버 이름 필드 선언
	private String address1; // 멤버 주소 필드 선언
	private String address2;
	private String address3;
	
}
