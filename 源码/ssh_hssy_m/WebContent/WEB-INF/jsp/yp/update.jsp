<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!-- 评价界面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <link rel="stylesheet" type="text/css" href="${ctx }/resource/boot/css/bootstrap.min.css" /> --%>
<%--     <link rel="stylesheet" type="text/css" href="${ctx }/resource/css/bootstrap-responsive.css" /> --%>
<%--     <link rel="stylesheet" type="text/css" href="${ctx }/resource/css/style.css" /> --%>


<link href="${ctx }/resource/la/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx }/resource/la/css/datepicker3.css" rel="stylesheet">

<link href="css/styles.css" rel="stylesheet">
<script src="${ctx }/resource/la/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/ssh_hssy_m/resource/js/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="/ssh_hssy_m/resource/js/ueditor/ueditor.all.min.js"></script>
	<title>管理后台登陆</title>
  
	 <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }

.table th,
.table td {
  padding: 8px;
  line-height: 20px;
  text-align: left;
  vertical-align: top;
  border-top: 1px solid #dddddd;
}
    </style>

</head>
<body>

	<div class="col-sm-6 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">新增样片</h1>
			</div>
		</div><!--/.row-->
	<!-- 	private Integer id;
	
	private String name;//简介
	
	private String urls;//主图
	
	private String content;//内容
	
	private Integer isDelete;//是否删除 0 否 1 是 -->
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">发布基本信息</div>
					<div class="panel-body">
						<div class="col-md-6">
							<form role="form" id="myForm" action="yp_exUpdate.do" method="post" enctype="multipart/form-data">
							 <input type="hidden" name="id" value="${Obj.id}"> 
								<div class="form-group">
									<label>名称：</label>
									<input class="form-control" placeholder="请输入名称介" name="name" value="${Obj.name }">
								</div>
								<div class="form-group">
									<label>主图：</label>
									<input class="form-control" type="file" placeholder="请输入简介" name="file">
								</div>	
								
								<div class="form-group">
								<!-- 加载编辑器的容器 -->
							        <script id="remark_txt_1" name="content" type="text/plain" style="width:1000px;height:500px;">${Obj.content }</script>
								    <!-- 实例化编辑器 -->
								    <script type="text/javascript">
								        var editor = UE.getEditor('remark_txt_1');
								    </script> 
								    </div>
								<button type="button" class="btn btn-primary" id="save">发布</button>
								<button type="reset" class="btn btn-default">重置</button>
						</form>
					</div>
				</div>
			</div><!-- /.col-->
		</div><!-- /.row -->
		
	</div><!--/.main-->

	


</body>
<script>
$("#save").click(function(){
	$("#myForm").submit();
	
	
});
</script>