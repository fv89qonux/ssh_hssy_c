<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="${ctx}/resource/bootstrap/css/bootstrap.min.css" />




<script type="text/javascript" src="/ssh_hssy_m/resource/lib/jquery/1.9.1/jquery.min.js"></script> 

<link href="${ctx}/resource/u/css/public.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/u/css/message.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="/ssh_hssy_m/resource/u/js/jquery.Xslider.js"></script>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>

<body>
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="mian">

<div id="TB_overlayBG"></div>
    
    
 <div class="mian">
	<div class="matter">
        <div class="content2">
                <form id="fo" action="${ctx}/comment_exAdd.do" method="post">
             	<div class="inputLong"><textarea name="content" id="f" cols="" rows=""></textarea></div>
                <div class="commentFunc">还可以输入 2000 个字符 &nbsp;&nbsp;<a href="#" href="" class="showbox" onclick="su()">
                <img src="/ssh_hssy_m/resource/u/images/pj.jpg" width="89" height="27" /></a></div>
             </div>
              </form>
      <div class="liuyan">
        	<div class="title"><a href="#">留言（${pagers.total }）</a></div>
            <div class="recListS borderTop">
     	<ul>
     		
         	<li>
         	 <c:forEach items="${pagers.datas}" var="data" varStatus="l">
         	<!--  private Integer  id;
	private String content;//内容
	private User user;//评论人
	private Date createTime; -->
         	  <div class="layout recListLeft f14">
                     <div class="recDes">
						<div class="vm bold c999">
	                   		<p class="rightFloor"><span class="cf90" style=" color:#ffb900;"></span></p>
	                   		<a class="c4095ce" target="_blank" href="#">${data.user.userName}</a>	
	                   		<span><fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
	                   	</div>
                       <p class="recBox">
                       ${data.content}
                       </p>
                       <div class="mblFunc mt10 f12 downWh">
                        <c:if test="${userId ==  data.user.id}">
                         <a  style="color:#4095ce" href="${ctx}/comment_delete.do?id=${data.id}">删除</a>|
                         
                         <%--  <a style="background-color: #ffa800" 
                           	   	    href="11112/detail.html" class="pro_btn"
                           	   	     data-toggle="modal" data-target="#myModal" id="dj" onclick="hh('${data.code}','${data.id}')">查看歌曲</a> --%>
                        <a  style="color:#4095ce" data-toggle="modal" data-target="#myModal" id="dj" onclick = "hh('${data.content}','${data.id}')" href="#">编辑</a>
                        </c:if>           
                       
                       </div>
                     </div>
                 </div>
                 
         	 </c:forEach>
             </li> 
         </ul>
      </div>
      <div class="digg"><span class="disabled">
       <pg:pager  url="${ctx}/comment_comment.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="16" export="curPage=pageNumber" >
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
</div>









<!-- 按钮触发模态框 -->
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true";">
	<div class="modal-dialog modal-lg">
	    <form action="${ctx}/comment_exUpdate.do" id="jj" method="post">
	     
	      <input type="hidden" name="id" id="id2" value="">
	    
	   
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<div class="modal-body">
                <textarea rows="" cols="" name="content" id="text2" style="height: 300px;width: 100%"></textarea>
                </div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" id="tj">提交</button>
			</div>
			 </form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


</body>
<script type="text/javascript">
function su(){
	if($("#f").val() == "" || $("#f").val() == null){
		alert("请填写内容");
		return ;
	}
	$("#fo").submit();
}
function hh(c,id){
	 $("#id2").val(id);
	 $("#text2").val(c);
}

$(function(){
	
	$("#tj").click(function(){
		$("#jj").submit();
	});
	
	
});

</script>
</html>
