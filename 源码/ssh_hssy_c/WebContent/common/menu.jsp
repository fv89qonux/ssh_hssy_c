<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglibs.jsp"%>
   
  <div class="wrap_top">
    	<div class="top">
        	<div class="logo" style="text-align: center;margin-top: 10px"><a href="#"></a><span style="font-size: 30;color: #fff;font-weight: bold;">拾光·印记婚纱摄影</span></div>
            <div id="navMenu">
                <UL class="menu1">
                    <li class="onelink"><a href="${ctx}/login_uIndex.do">网站首页</a></li>
                    <li class="navthis1"><a href="${ctx}/yp_yp.do"  rel='dropmenu1'>样片欣赏</a>
                    </li> 
                     <li class="navthis22"><a href="${ctx}/kz_kz.do" >每日客照</a></li>
                    <li class="navthis8"><a href="${ctx}/message_message.do"  rel='dropmenu8'>群聊</a>
                    <li class="navthis8"><a href="${ctx}/comment_comment.do"  rel='dropmenu8'>留言板</a>
                    <li class="navthis8"><a target="_blank" href="/ssh_hssy_m"  rel='dropmenu8'>后台管理登录</a>
                  <!--   
                    <li class="navthis8"><a href="activity.html"  rel='dropmenu8'>群聊</a>
                    <li class="navthis8"><a href="activity.html"  rel='dropmenu8'>群聊</a>
                    <li class="navthis8"><a href="activity.html"  rel='dropmenu8'>群聊</a> -->
                    </li>
                    </ul>
			</div>
			<div style="float: right;clear: both;margin-right: 50px;margin-top: -30px">
			 <ul >
                  <c:if test="${userName == null }">
                     未登录  <li style="float: left;"><a href="${ctx}/login_login.do"><span style="font-size: 15px;color: #fff">登陆&nbsp;|</span></a></li>
                  <li style="float: left;"><a href="${ctx}/login_res.do"><span style="font-size: 15px;color: #fff">注册&nbsp;|</span></a></li>
                  <li style="float: left;"><a href="${ctx}/login_up.do"><span style="font-size: 15px;color: #fff">我的信息&nbsp;|</span></a></li>
                   </c:if>
                   <li style="float: left;"><a href="${ctx}/login_up.do"><span style="font-size: 15px;color: #fff">
                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 
                    <c:if test="${userName != null }">
                      欢迎您：${userName }&nbsp;
                   </c:if>
                 
                   
                   </span></a></li>
              </ul>
			</div>
        </div>
	 </div>