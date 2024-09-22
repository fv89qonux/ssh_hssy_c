<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <link href="${ctx}/resource/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ssh_hssy_m/resource/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/ssh_hssy_m/resource/static/h-ui/js/H-ui.js"></script> 
<link rel="stylesheet" type="text/css" href="${ctx}/resource/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resource/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resource/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resource/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resource/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${ctx}/resource/static/h-ui.admin/css/style.css" />
<script type="text/javascript">
$(document).ready(function(){
	
});
</script>
<head>
<style>
#doc-topbar-collapse-3 a{
font-weight: bold;
font-size: 14px;
}
.headers{
height: 30px;width: 200px;
z-index:999;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论</title>
</head>
<body>
<div class="page-container">
 <form action="comment_comment.do" method="post">
   <div class="text-c"> 
		<input type="text" class="input-text" style="width:250px" placeholder="输入名称" id="" name="user.realName" value="${Obj.user.realName}"  >
		<button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
   </form>
	<form action="">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	    <span class="l">  
	                      <a href="javascript:;" onclick="admin_add('添加专题','${ctx}/special_addManage.do','600','300')" class="">
	                    </a></span>
	                     <span class="r">
	                     <div class="panel-foot text-center">
      <pg:pager  url="${ctx}/comment_comment.do" maxIndexPages="5" items="${pagers.total}"  maxPageItems="15" export="curPage=pageNumber" >
		<pg:param name="otherId" value="${otherId}"/>
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
	                     
	                     
	                     </span> </div>
	<table class="table table-border table-bordered table-bg">
		<thead>
	<!-- private Integer  id;
	private String content;//内容
	private User user;//评论人
	private Date createTime; -->
			<tr>
				<th scope="col" colspan="9">评论列表</th>
			</tr>
			<tr class="text-c">
				<th width="150">评论内容</th>
				<th width="150">评论人</th>
				<th width="150">评论时间</th>
			</tr>
		</thead>
		<tbody>
		 <c:forEach items="${pagers.datas}" var="data" varStatus="l">
		 <tr class="text-c">
				
				<td>${data.content}</td>
				<td> 
				${data.user.realName}
				</td>
				 <td><fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		 </c:forEach>
		</tbody>
		
	</table>
	</form>
</div>
<script type="text/javascript" src="/ssh_hssy_m/resource/lib/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript" src="/ssh_hssy_m/resource/lib/layer/2.1/layer.js"></script> 
<script type="text/javascript" src="/ssh_hssy_m/resource/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="/ssh_hssy_m/resource/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="/ssh_hssy_m/resource/static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="/ssh_hssy_m/resource/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript">
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*管理员-增加*/
function admin_add(title,url,w,h){
	window.location.href=ctx+"/extension_addExtension.do"
}
/*管理员-删除*/
function admin_del(id){
	layer.confirm('确认要删除吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		/* 
		$(obj).parents("tr").remove();
		
		
		layer.msg('已删除!',{icon:1,time:1000}); */
		window.location.href=ctx+"/comment_delComment.do?id="+id;
	});
}
/*管理员-编辑*/
function admin_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*管理员-停用*/
function admin_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*管理员-启用*/
function admin_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		
		
		$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!', {icon: 6,time:1000});
	});
}
</script>
</body>
</html>
