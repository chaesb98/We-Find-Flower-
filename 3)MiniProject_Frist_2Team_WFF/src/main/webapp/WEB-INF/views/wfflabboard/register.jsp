<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %> 

	 <!--register CSS-->
	<link rel="stylesheet" href="/resources/wfflabboard/register.css">

</head>

<%@ include file="../includes/nav.jsp"%>

<!--=============register(insert)================-->
<div class = "row">
  <div class = "col-lg-12">
     <div class = "panel panel-ddefault">
        <!-- /.panel-heading -->
        <div class = "panel-body">
          <p>write</p>
           <form action="/wfflabboard/register" role = "form" method="post">
           <div class="form-group">
                 <label>ID</label>                 
                 <input class = "form-control" name = "id" value="${member.id}" readonly="readonly">
              </div>
              <div class="form-group">
                 <label>제목</label>
                 <input class = "form-control" name = "title">
              </div>
              <div class="form-group">
                 <label>내용</label>
                 <textarea rows="5" class="form-control" name = "content"></textarea>
              </div>
              <div class="form-group">
                 <label>작성자</label>
                 <input class = "form-control" name = "writer">
              </div>
              <div class="input-group mb-3">
                <!-- <label>첨부파일</label> -->
                <input type="file" class="form-control" id="inputGroupFile02">
                <label class="input-group-text" for="inputGroupFile02">Upload</label>
              </div>
              <button type="submit" class="sub_btn btn-default">Submit Button</button>
              <button type="reset" class="reset_btn btn-default">Reset Button</button>
           </form>
        </div> <!-- end panel-body -->
     </div> <!-- end panel -->
  </div> <!-- end col-log-12 -->
</div> <!-- end row -->
<!--=============end register(insert)================-->
<script type="text/javascript">
	$(document).ready(
		function(){
			$("#listBtn").on("click", function(){
				self.location = "/wfflabboard/list";
			});
		});
</script>


<%@ include file="../includes/footer.jsp"%>
