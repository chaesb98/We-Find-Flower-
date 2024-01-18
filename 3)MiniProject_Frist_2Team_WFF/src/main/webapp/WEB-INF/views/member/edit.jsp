<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %> 

	 <!--edit CSS-->
	 <link rel="stylesheet" href="../resources/member/edit.css">

</head>

<%@ include file="../includes/nav.jsp"%>

<!--===============edit/leave===============-->
<div class="maint_empty">
  <div class="row">
      <div class="col-md-6 mx-auto p-0" >
      <form action="/member/edit" role = "form" method="post">
          <div class="card">
              <div class="edit-box">
                  <div class="edit-snip">
                      <input id="tab-1" type="radio" name="tab" class="edit-in" checked><label for="tab-1"
                          class="tab">Edit</label>
                      <input id="tab-2" type="radio" name="tab" class="leave-in"><label for="tab-2" class="tab">leave</label>
                      <!--====edit-->
                     
                      <div class="edit-space">
                        <div class="edit">
                        <div class="group">
                                <label for="id" class="label">ID</label>
                                <input id="id" type="text" class="input" placeholder="Enter your ID" name="id" value='<c:out value="${member.id}"/>' readonly="readonly">
                            </div>
                        
                            <div class="group">
                                <label for="user1" class="label">Username</label>
                                <input id="user1" type="text" class="input" placeholder="Enter your username" name="name"  value='<c:out value="${member.name}"/>' readonly="readonly">
                            </div>
                            <div class="group">
                                <label for="pass2" class="label">Password</label>
                                <input id="pass2" type="password" class="input" data-type="password" name="password"
                                    placeholder="Enter your password">
                            </div>
                            <div class="group">
                              <label for="pass3" class="label">Repeat Password</label>
                              <input id="pass3" type="password" class="input" data-type="password"
                                  placeholder="Repeat your password">
                          </div>
                          <div class="group">
                              <label for="pass4" class="label">Email Address</label>
                              <input id="pass4" type="text" class="input" placeholder="Enter your email address" name="email">
                          </div>
                          <div class="group">
                                    <label for="pass" class="label address2" >Address</label>
                                    <!-- kakao 주소 api-->
                                    <input type="text" id="sample6_postcode" placeholder="우편번호" class="label post" name="address1">
                                    <input type="button" onclick="sample6_execDaumPostcode();" value="우편번호 찾기" class="label findpost" ><br>
                                    <input type="text" id="sample6_address" placeholder="주소" class="label ditailadd" name="address2">
                                    <input type="text" id="sample6_detailAddress" placeholder="상세주소" class="label ditailadd2" name="address3">
                                    <input type="hidden" id="sample6_extraAddress" placeholder="참고항목">

                              <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                              <script>
                                  function sample6_execDaumPostcode() {
                                      new daum.Postcode({
                                          oncomplete: function(data) {
                                              // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                                              // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                                              // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                                              var addr = ''; // 주소 변수
                                              var extraAddr = ''; // 참고항목 변수

                                              //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                                              if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                                                  addr = data.roadAddress;
                                              } else { // 사용자가 지번 주소를 선택했을 경우(J)
                                                  addr = data.jibunAddress;
                                              }

                                              // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                                              if(data.userSelectedType === 'R'){
                                                  // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                                                  // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                                                  if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                                                      extraAddr += data.bname;
                                                  }
                                                  // 건물명이 있고, 공동주택일 경우 추가한다.
                                                  if(data.buildingName !== '' && data.apartment === 'Y'){
                                                      extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                                  }
                                                  // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                                                  if(extraAddr !== ''){
                                                      extraAddr = ' (' + extraAddr + ')';
                                                  }
                                                  // 조합된 참고항목을 해당 필드에 넣는다.
                                                  document.getElementById("sample6_extraAddress").value = extraAddr;
                                              
                                              } else {
                                                  document.getElementById("sample6_extraAddress").value = '';
                                              }

                                              // 우편번호와 주소 정보를 해당 필드에 넣는다.
                                              document.getElementById('sample6_postcode').value = data.zonecode;
                                              document.getElementById("sample6_address").value = addr;
                                              // 커서를 상세주소 필드로 이동한다.
                                              document.getElementById("sample6_detailAddress").focus();
                                          }
                                      }).open();
                                  }
                              </script><!--/ kakao 주소 api-->
                        </div>

                          <div class="group">
                                <input type="submit" class="button" value="success">
                          </div>
                          </form>
                            <!-- <div class="hr"></div>
                            <div class="foot">
                                <a href="#">Forgot ID?</a><br><br>
                                <a href="#">Forgot Password?</a>
                                <p><a class="logo" href="#"><img src="./assets/images/logo.svg" alt="fww로고"></a></p>
                            </div> -->
                        </div>
                        <div class="leave-in-form">
                            <div class="group">
                                <label for="user5" class="label">Username</label>
                                <input id="user5" type="text" class="input" placeholder="Enter your Username">
                            </div>
                            <div class="group">
                                <label for="pass6" class="label">Password</label>
                                <input id="pass6" type="password" class="input" data-type="password"
                                    placeholder="Enter your password">
                            </div>
                            <div class="group">
                                <label for="pass7" class="label">Repeat Password</label>
                                <input id="pass7" type="password" class="input" data-type="password"
                                    placeholder="Repeat your password">
                            </div>
                            <div class="group">
                                <label for="pass8" class="label">Email Address</label>
                                <input id="pass8" type="text" class="input" placeholder="Enter your email address">
                            </div>

                            <div class="group">
                                <input type="submit" class="button" value="Sign Up">
                            </div>
                            <div class="hr"></div>
                            <div class="foot">
                                <label for="tab-1">Are you sure you want to leave?</label>
                            </div>
                        </div>
                    </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
</div>
<!--==============end edit/leave=============-->


<%@ include file="../includes/footer.jsp"%>
