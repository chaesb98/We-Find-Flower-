<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="/WEB-INF/views/includes/header.jsp" %> 

	 <!--index CSS-->
	 <link rel="stylesheet" href="/resources/pages/main.css">

</head>

<%@ include file="/WEB-INF/views/includes/nav.jsp"%>

<!--===============index===============-->
<div class="main-banner" id="top">
    <div class="container">
      <div class="row">
        <div class="col-lg-7">
          <div class="caption header-text">
            <div class="line-dec">
              <img src="/resources/images/top_flower.png" alt="컨텐츠1 꽃 사진">
            </div>
            <h4><em class="eng_stress orange">Hi I'm Lilly!</em></h4>
            <b class="kor">오늘은 행운가득, <br> 화사한 하루가 될거에요!</b> <br><br><br>
            <div class="more scroll-to-section"><a href="about.html">show more</a></div>
            
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="projects section" id="projects">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <div class="section-heading">
            <h2 class="orange eng_stress">We find flower</h2>
            <h3 class="kor">다양한 꽃으로 향기로운 하루같은 문구</h3>
          </div>
        </div>
      </div>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-12">
          <div class="owl-features owl-carousel">
            <div class="item">
              <img src="/resources/images/secondimg1.png" alt="">
              <div class="down-content">
                <h4 class="kor">해바라기</h4>
                <p class="kor">당신만 바라볼게요</p>
                <a href="#"><i class="fa fa-link"></i></a>
              </div>
            </div>
            <div class="item">
              <img src="/resources/images/secondimg2.png" alt="">
              <div class="down-content">
                <h4 class="kor">라넌큘러스</h4>
                <p class="kor">당신은 매력적이에요</p>
                <a href="#"><i class="fa fa-link"></i></a>
              </div>
            </div>
            <div class="item">
              <img src="/resources/images/secondimg3.png" alt="">
              <div class="down-content">
                <h4 class="kor">데이지</h4>
                <p class="kor">평화와 희망을 상징해요</p>
                <a href="#"><i class="fa fa-link"></i></a>
              </div>
            </div>
            <div class="item">
              <img src="/resources/images/secondimg4.png" alt="">
              <div class="down-content">
                <h4 class="kor">튤립</h4>
                <p class="kor">영원한 사랑을 고백합니다</p>
                <a href="#"><i class="fa fa-link"></i></a>
              </div>
            </div>
            <div class="item">
              <img src="/resources/images/secondimg5.png" alt="">
              <div class="down-content">
                <h4 class="kor">수국</h4>
                <p class="kor">당신은 변덕스럽군요</p>
                <a href="#"><i class="fa fa-link"></i></a>
              </div>
            </div>
            <div class="item">
              <img src="/resources/images/secondimg6.png" alt="">
              <div class="down-content">
                <h4 class="kor">프리지아</h4>
                <p class="kor">당신의 시작을 응원합니다</p>
                <a href="#"><i class="fa fa-link"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  

  <div class="infos section" id="infos">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="main-content">
            <div class="row">
              <div class="col-lg-6">
                <div class="left-image">
                  <img src="/resources/images/left-infos.jpg" alt="">
                </div>
              </div>
              <div class="col-lg-6">
                <div class="section-heading">
                  <h2 class="orange eng">WFF LAB</h2>
                  <h4 class="kor">국내최초 플라워 케어 시스템</h4> <br>
                  <h4 class="eng_stress orange">before& After</h4>
                </div>
                <!-- <div class="skills">
                  <div class="skill-slide marketing">
                    <div class="fill"></div>
                    <h6>Marketing</h6>
                    <span>90%</span>
                  </div>
                  <div class="skill-slide digital">
                    <div class="fill"></div>
                    <h6>Ditigal Media</h6>
                    <span>80%</span>
                  </div>
                  <div class="skill-slide media">
                    <div class="fill"></div>
                    <h6>Social Media Managing</h6>
                    <span>95%</span>
                  </div>
                </div> -->
                <div class="review">
                  <div class="re_div">
                    <div class="re_text"><span class="kor">제가 동네에서 소문난 똥손이었는데 WFF 플라워 케어 시스템 덕분에 꽃이 시들지 않아서 너무 좋아요!</span></div>
                    <div class="re_more">
                      <a href="#"><img src="/resources/images/plus.png" alt=""></a>
                    </div>
                  </div>
                  <div class="re_div">
                    <div class="re_text"><span class="kor">요즘 프로젝트때문에 집에 있던 꽃을 신경을 쓰지 못했는데 플라워 케어 시스템 덕분에 맘놓고 일 할 수 있어요!</span></div>
                    <div class="re_more">
                      <a href="#"><img src="/resources/images/plus.png" alt=""></a>
                    </div>
                  </div>
                  <div class="re_div re_last">
                    <div class="re_text"><span class="kor">꽃을 선물 받으면 어떻게 관리해야 할지 곤란했었는데 WFF 플라워 케어 시스템을 이용하니 마음이 편해졌어요!</span></div>
                    <div class="re_more">
                      <a href="#"><img src="/resources/images/plus.png" alt=""></a>
                    </div>
                  </div>
                </div>
                <!-- <p class="more-info">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed doers eiusmod tempor
                  incididunt ut labore et dolore dolor dolor sit amet, consectetur adipiscing elit, sed doers eiusmod.
                </p> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

<div class="services section" id="services">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 offset-lg-6">
          <div class="row">
            <div class=""></div>
            <div class="col-lg-12">
              <div class="section-heading">
                <h2 class="orange eng_stress">We are WFF</h2>
                <h3 class="kor">꽃처럼 다양한 WFF를 만나보세요</h3>                
              </div>
            </div>
            <div class="col-lg-6 col-sm-6">
              <a href="#">
                <div class="service-item">
                  <div class="icon">
                    <img src="/resources/images/services-01.svg" alt="discover SEO" class="templatemo-feature">
                    <h4 class="kor"><span class="eng">'WFF'</span> 정기구독</h4>
                  </div>
                  <h4 class="kor">매 월 향기로운 꽃다발이 여러분의 하루를 반겨줍니다.</h4>
                </div>
              </a>
            </div>
            <div class="col-lg-6 col-sm-6">
              <a href="#">
                <div class="service-item">
                  <div class="icon">
                    <img src="/resources/images/services-02.svg" alt="data analysis" class="templatemo-feature">
                    <h4 class="kor">회원 정보</h4>
                  </div>
                  <h4 class="kor">WFF는 매일 싱그러운 곳에서 꽃을 재배합니다.</h4>
                </div>
              </a>
            </div>
            <div class="col-lg-6 col-sm-6">
              <a href="#">
                <div class="service-item">
                  <div class="icon">
                    <img src="/resources/images/services-03.svg" alt="precise data" class="templatemo-feature">
                    <h4 class="kor">원데이클래스</h4>
                  </div>
                  <h4 class="kor">정기적으로 모여 꽃과 친해지는 시간</h4>
                </div>
              </a>
            </div>
            <div class="col-lg-6 col-sm-6">
              <a href="#">
                <div class="service-item">
                  <div class="icon">
                    <img src="/resources/images/services-04.svg" alt="SEO marketing" class="templatemo-feature">
                    <h4 class="kor">자주 묻는 질문</h4>
                  </div>
                  <h4 class="kor">WFF에게 궁금한 점 모두 답하겠습니다</h4>
                </div>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

<script>
  (function(){var w=window;if(w.ChannelIO){return w.console.error("ChannelIO script included twice.");}var ch=function(){ch.c(arguments);};ch.q=[];ch.c=function(args){ch.q.push(args);};w.ChannelIO=ch;function l(){if(w.ChannelIOInitialized){return;}w.ChannelIOInitialized=true;var s=document.createElement("script");s.type="text/javascript";s.async=true;s.src="https://cdn.channel.io/plugin/ch-plugin-web.js";var x=document.getElementsByTagName("script")[0];if(x.parentNode){x.parentNode.insertBefore(s,x);}}if(document.readyState==="complete"){l();}else{w.addEventListener("DOMContentLoaded",l);w.addEventListener("load",l);}})();

  ChannelIO('boot', {
    "pluginKey": "0af7776f-577c-40f6-80f2-3ce63791f123"
  });
</script>
<!--==============end index=============-->


<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
