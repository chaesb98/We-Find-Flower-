<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %> 

	 <!--login CSS-->
	 <link rel="stylesheet" href="../resources/member/login.css">

</head>

<%@ include file="../includes/nav.jsp"%>

<!--=============login/logout===============-->
<div class="maint_empty">
  <div class="row">
      <div class="col-md-6 mx-auto p-0" >
          <div class="card">
              <div class="login-box">
                  <div class="login-snip">
                      <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1"
                          class="tab">Login</label>
                      <a href="/member/join">SIGN UP</a>
                      <div class="login-space">
                      <form id='loginForm' name='loginForm' method="post" action="/member/login">
	                      <div class="group">
	                          <label for="user" class="label">Id</label>
	                          <input id="id" name="id" type="text" class="input" placeholder="Input your id">
	                      </div>
	                      <div class="group">
	                          <label for="user" class="label">Password</label>
	                          <input id="password" name="password" type="password" class="input" data-type="password"
	                              placeholder="Input your password">
	                      </div>
	                      <div class="group">
                                  <input id="check" type="checkbox" class="check" checked>
                                  <label class="keep" for="check"><span class="icon"></span> Keep me Logined in</label>
                              </div>
                              <div class="group">
			                      <button type="submit" data-oper='login' class="button" >LogIn</button>
                              </div>
                      </form>
                              <div class="hr"></div>
                              <div class="foot">
                                  <a href="/member/findId">Forgot ID?</a><br><br>
                                  <a href="/member/findPwd">Forgot Password?</a>
                                  <p><a class="logo" href="#"><img src="/resources/images/logo.svg" alt="fww로고"></a></p>
                              </div>
                          </div>
                          
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
</div>



<!--==============end login/logout=============-->


<%@ include file="../includes/footer.jsp"%>
