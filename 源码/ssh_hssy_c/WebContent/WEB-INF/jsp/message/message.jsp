<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="/ssh_hssy_m/resource/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/ssh_hssy_m/resource/static/h-ui/js/H-ui.js"></script> 

<link href="${ctx}/resource/u/css/public.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/u/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="/ssh_hssy_m/resource/u/js/jquery.Xslider.js"></script>

<style>
.uli{


}
.uli li{
float: left;
margin-left:10px;
}

.messtime{
color: blue;
}
.message_left_con{
width: 50%;
}
.message_left_con{
    margin-left: 10px;
     margin-top:15px;
     background: grey;
     color: white;
      -moz-border-radius: 10px;
    -webkit-border-radius: 10px;
    border-radius: 10px;
    padding:5px;
}
.mess_right{
clear: both;
}
.mess_left{
clear: both;
}
.message_right_con{
clear:both;
 background: grey;
     color: white;
width: 50%;
float: right;
 -moz-border-radius: 10px;
    -webkit-border-radius: 10px;
    border-radius: 10px;
    margin-left: 10px;
    margin-top:15px;
  padding:5px;
}
.nameMe{
float: right;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>

<body>
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="mian">
  <div class="person_r" style="width: 800px;margin: 0 auto;margin-bottom: 30px;background: white;">
        	<div class="person_h" style="background:#1693FF;color: white;">
            	&nbsp;&nbsp;&nbsp;<span style="font-size: 20px;font-weight: bold;">群聊大厅</span>
<%--             	<input type="hidden" name="hname" id="hname" value="${userName}"> --%>
            </div>
            <div class="person_rmain" style="border: 1px solid #1693FF ">
            	<div class="news_d" style="height: 350px;overflow:auto;overflow-x:hidden;">
                </div>
            </div>
             <div class="news_d2" style="height: 200px;border: 1px solid #ddd;">
                  <textarea name="content" id="content"  style="width: 100%;height: 80%;border: 1px solid white;"></textarea>
                  
                  <div style="width: 200px;float: right;">
                     <button onclick="sendMessage('${userName}')" style="width: 100px;background:#1693FF;color: white;">发送</button>
                  </div>
             </div>
        </div>
    </div>
</div>
 <jsp:include page="/common/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
$("#yue").change(function(){
	 var s =  $(this).val();
	 $("#jine").val(s*25);
	});

$("#sendMessage").click(function(name){
	
	 
});

function sendMessage(name){
	var con = $("#content").val();
//	${ctx}/sayMood_photoDetail.do?id=${data.id}
  var date = getNowFormatDate();
	 $.ajax({
		type : 'post',
		url : ctx+"/message_sendMessage.do?content="+con,
		dataType : "json",
		success : function(data) {
			if(data.result == 2){
				alert("您会员已经到期了，暂时不能聊天，请充值后再聊天！！！")
				return false;
			}else{
				$(".news_d").append(" <div class='mess_right'><div class='nameMe'><span class='messtime'>"+name+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+date+"</span></div><div class='message_right_con'>"+con+"</div> </div>");
				$("#content").val("");
				$('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			}
		},
		error : function() {
			alert("error");
		}
	});
}
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}
$(function(){
	
	  $("body").keydown(function() {
          if (event.keyCode == "13") {//keyCode=13是回车键
        	 // var name=${userName};
        	 // alert(name);
        	 var name= ${userName};
        	  sendMessage(name);
          }
      });
	resive();
	
	//聊天的先注释掉
	
	  setTimeout(function () {
		setInterval(resive2,4000);
	}, 2000);  
	
function resive(){
	var uid = ${userId}
	$.ajax({
		type : 'post',
		url : ctx+"/message_findMessageJIluList.do",
		dataType : "json",
		success : function(data) {
			for (var i=0;i<data.length;i++)
			{
			 if(data[i].sendUserId == uid ){
				 $(".news_d").append(" <div class='mess_right'><div class='nameMe'><span class='messtime'>"+data[i].sendUserName+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+data[i].createTimeStr+"</span></div><div class='message_right_con'>"+data[i].content+"</div> </div>");
				 $("#content").val("");
				 $('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			 }else{//别人发的
				 $(".news_d").append("<div class='mess_left'><div><span class='messtime'>"+data[i].sendUserName+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+data[i].createTimeStr+"</span></div> <div class='message_left_con' >"+data[i].content+"</div></div>");
				 $("#content").val("");
				 $('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			 }
			
			}
		},
		error : function() {
			alert("error");
		}
	});
	
	
}
function resive2(){
	var uid = ${userId}
	$.ajax({
		type : 'post',
		url : ctx+"/message_findMessage.do",
		dataType : "json",
		success : function(data) {
			for (var i=0;i<data.length;i++)
			{
			//document.write(cars[i] + "<br>");
			//自己发的
			 if(data[i].sendUserId == uid ){
				 $(".news_d").append(" <div class='mess_right'><div class='nameMe'><span class='messtime'>"+data[i].sendUserName+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+data[i].createTimeStr+"</span></div><div class='message_right_con'>"+data[i].content+"</div> </div>");
				 $('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			 }else{//别人发的
				 $(".news_d").append("<div class='mess_left'><div><span class='messtime'>"+data[i].sendUserName+"</span>&nbsp;&nbsp;:&nbsp;&nbsp;<span class='messtime'>"+data[i].createTimeStr+"</span></div> <div class='message_left_con' >"+data[i].content+"</div></div>");
				 $('.news_d').scrollTop( $('.news_d')[0].scrollHeight );
			 }
			
			}
		},
		error : function() {
			alert("error");
		}
	});
	
	
}
});
</script>
</html>
