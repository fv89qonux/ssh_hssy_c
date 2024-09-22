<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="/ssh_hssy_m/resource/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/ssh_hssy_m/resource/static/h-ui/js/H-ui.js"></script> 

<link href="${ctx}/resource/u/css/public.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/u/css/photo.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="/ssh_hssy_m/resource/u/js/jquery.Xslider.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	// 焦点图片水平滚动
	$("#slider1").Xslider({
		// 默认配置
		affect: 'scrollx', //效果  有scrollx|scrolly|fade|none
		speed: 800, //动画速度
		space: 6000, //时间间隔
		auto: true, //自动滚动
		trigger: 'mouseover', //触发事件 注意用mouseover代替hover
		conbox: '.conbox', //内容容器id或class
		ctag: 'div', //内容标签 默认为<a>
		switcher: '.switcher', //切换触发器id或class
		stag: 'a', //切换器标签 默认为a
		current:'cur', //当前切换器样式名称
		rand:false //是否随机指定默认幻灯图片
	});
	
	// 焦点图片垂直滚动
	$("#slider2").Xslider({
		affect:'scrolly',
		ctag: 'div',
		speed:400
	});
	
	// 焦点图片淡隐淡现
	$("#slider3").Xslider({
		affect:'fade',
		ctag: 'div'
	});
	
	// 选项卡
	$("#slider4").Xslider({
		affect:'none',
		ctag: 'div',
		speed:10
	});
	
	
});
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>

<body>
<jsp:include page="/common/menu.jsp"></jsp:include>
 <div class="wrap_banner">
     	<div class="banner"></div>
     </div>
     
<div class="mian">
<div class="matter2">
            	<div class="info">
                	<div class="title"></div>
                </div>
                <div class="choose">
                    <div class="select2">
                    </div>
                </div>
              <div class="content">
              
               <c:forEach items="${pagers.datas}" var="man" varStatus="l">
                 <div class="prod">
                        <div class="tip"><a href="${ctx}/kz_view.do?id=${man.id}"><img src="/ssh_hssy_m/${man.urls}" width="205" height="125" onload="javascript:DrawImage(this,205,125)"></a></div>
                        <div class="scrt"><div class="zt"><a href="#">${man.name}</a></div><div class="rq"></div>
                        </div>
              		</div>
               </c:forEach>
                </div>
                <div class="digg">
                
                 <pg:pager  url="${ctx}/kz_kz.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="16" export="curPage=pageNumber" >
		<pg:last>  
			共${pagers.total}记录,共${pageNumber}页,  
		</pg:last>  
			当前第${curPage}页 
  
        <pg:first>  
    		<a href="${pageUrl}">首页</a>  
		</pg:first>  
		<pg:prev>  
    		<a href="${pageUrl}">上一页</a>  
		</pg:prev>  
      
       	<pg:pages>  
        	<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">[${pageNumber }]</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">${pageNumber}</a>  
            	</c:otherwise>  
        	</c:choose>  
    	</pg:pages>
             
        <pg:next>  
    		<a href="${pageUrl}">下一页</a>  
		</pg:next>  
		<pg:last>  
			<c:choose>  
            	<c:when test="${curPage eq pageNumber}">  
                	<font color="red">尾页</font>  
            	</c:when>  
            	<c:otherwise>  
               		<a href="${pageUrl}">尾页</a>  
            	</c:otherwise>  
        	</c:choose> 
    		  
		</pg:last>
	</pg:pager>
                </div>
            </div>
 </div>
 <jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
