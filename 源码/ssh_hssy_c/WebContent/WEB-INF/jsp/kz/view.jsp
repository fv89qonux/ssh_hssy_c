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
	<div class="matter3">
   	  <div class="left" style="width: 100%">
            <div class="a02" style="width: 1000px;background-color: #fff">
              ${Obj.content}
            </div>
        <div class="dianza">
             	<div class="xianh" style="margin-left: 272px"><a href="${ctx}/kz_dz.do?id=${Obj.id}">${Obj.dzNum }</a></div>
      </div>

    </div>
 </div>
 <jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
