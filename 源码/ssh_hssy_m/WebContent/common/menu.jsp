<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglibs.jsp"%>
   
   <header>
  <div class="headtop">
  </div>
<!-- /**
	 * 大类--
	 *  走进环保
	 *    --环境质量 1
	 *    --污染防治 2
	 *    --生态保护 3
	 *  资讯
	 *    --绿色产品 4
	 *    --节能技术 5
	 *  市场
	 *    --投资 6
	 *    --项目 7
	 *  品牌企业 
	 *    --品牌企业 8
	 *  公益
	 *    --进行中 9
	 *    --精彩回顾 10
	 *  相关法规
	 *    --国家法规 11
	 *    --地方法规 12
	 */ -->
  <div class="box">
   <h1>
    <span style="color: #0772c5;font-size: 40px;line-height: 60px;display: block;margin-top: 5px;margin-bottom: 10px;font-family: '微软雅黑'"> 新乡市绿色环保网站</span>
   </h1>
   <div class="ser" style="float: right;margin-top:-30px">
          <c:if test="${userName == null}">
          <span class=""><a href="${ctx}/login_ulogin.do"><span>注册/登陆</span></a></span>
          </c:if>
          <c:if test="${userName != null}">
                           欢迎您：${userName}
          </c:if>
		  
  </div>
  </div>
  <nav id="nav" class="box">
    <ul>
      <li><a href="login_uIndex.do">网站首页</a></li>
      <li><a href="news_newList2.do?type=1">走进环保</a></li>
      <li><a href="news_newList2.do?type=4">资讯</a></li>
      <li><a href="news_newList2.do?type=6">市场</a></li>
      <li><a href="news_newList2.do?type=8">品牌企业</a></li>
      <li><a href="news_newList2.do?type=9">公益</a></li>
      <li><a href="news_newList2.do?type=11"> 相关法规</a></li>
       <li><a href="message_add.do">留言</a></li>
    </ul>
  </nav>
  <script src="js/silder.js"></script> 
</header>
