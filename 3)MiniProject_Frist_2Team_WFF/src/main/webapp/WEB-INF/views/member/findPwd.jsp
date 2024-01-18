<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %> 

	 <!--find CSS-->
	 <link rel="stylesheet" href="/resources/member/find.css">

</head>

<%@ include file="../includes/nav.jsp"%>

<!--=============find id/pw===============-->
<div class="maint_empty">
  <div class="row">
      <div class="col-md-6 mx-auto p-0" >
          <div class="card">
              <div class="findid-box">
                  <div class="findid-snip">
                      <input id="tab-1" type="radio" name="tab" class="find-id" checked><label for="tab-1"
                          class="tab">Find ID</label>
                      <input id="tab-2" type="radio" name="tab" class="find-pw"><label for="tab-2" class="tab">Find
                          PW</label>
                      <div class="findid-space">
	                         <div class="findid">
	                             <div class="group">
	                                 <label for="user" class="label">Username</label>
	                                 <input id="name" type="text" class="input" name="name" placeholder="Enter your username">
	                             </div>
	                             <div class="group">
	                                 <label for="user" class="label">Email Address</label>
	                                 <input id="email" type="text" class="input" name="email" placeholder="Enter your password">
	                             </div>
	                             <div class="group">
	                                 <input id="check" type="checkbox" class="check" checked>
	                             </div>
	                             <div class="group">
	                                 <button type="submit" id="findIdBtn" onclick="findId_click()" class="button">find Id</button>
	                             </div>
	                             <div class="hr"></div>
	                             <div class="foot">
	                                 <p>확인이 되지 않으시면 WFF 고객센터 1661-8686 로 연락주세요.<br>(평일 AM10시-PM6시 / 점심시간 PM1시-2시 제외)</p>
	                                 <p><a class="logo" href="#"><img src="/resources/images/logo.svg" alt="fww로고"></a></p>
	                             </div>
	                         </div>
	                     
	                     <form id="findPwdForm" role="form" method="post" action="/member/findPwd">
                          <div class="find-pw-form">
                              <div class="group">
                                  <label for="user" class="label">ID</label>
                                  <input id="user" type="text" name="id" class="input" placeholder="Enter your Username">
                              </div>
                              <div class="group">
                                  <label for="pass" class="label">Email Address</label>
                                  <input id="pass" type="text" name="email" class="input" placeholder="Enter your email address">
                              </div>
                              <c:if test="${success == 1}">
	                             	<label style="color: blue;">찾으시는 비밀번호는 ${userPwd}입니다.<br> 로그인 후 비밀번호를 변경해주세요.</label>
	                             </c:if>
	                             <c:if test="${fail == 0}">
	                             	<label style="color: red;">해당 정보로 가입된 아이디 존재하지 않습니다.</label>
	                             </c:if>
                              <div class="group">
	                                 <button type="submit" id="findPwdBtn" onclick="findPwd_click()" class="button">find Pwd</button>
                              </div>
                              <div class="hr"></div>
                              <div class="foot">
                                  <p>확인이 되지 않으시면 WFF 고객센터 1661-8686 로 연락주세요.<br>(평일 AM10시-PM6시 / 점심시간 PM1시-2시 제외)</p>
	                              <p><a class="logo" href="#"><img src="/resources/images/logo.svg" alt="fww로고"></a></p>
                              </div>
                          </div>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
</div>


<script type="text/javascript">
	$(document).ready(function(){
		
		$("#findPwdBtn").on("click", function(){
			$("#findPwdForm").submit();	
		});
	});
</script>
<!--==============end find id/pw=============-->


<%@ include file="../includes/footer.jsp"%>
