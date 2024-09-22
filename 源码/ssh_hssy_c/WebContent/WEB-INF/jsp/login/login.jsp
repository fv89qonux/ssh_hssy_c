<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="/ssh_hssy_m/resource/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/ssh_hssy_m/resource/static/h-ui/js/H-ui.js"></script> 


<link href="${ctx}/resource/u/css/public.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/resource/u/css/register.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function initMenu() {
  $('#piece0 ul').hide();
  $('#piece0 ul:first').show();
   $('#menu ul').hide();
  $('#menu ul:first').show();
  $('#menu li a').click(
    function() {
      var checkElement = $(this).next();
      if((checkElement.is('ul')) && (checkElement.is(':visible'))) {
        return false;
        }
      if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
        $('#menu ul:visible').slideUp('normal');
        checkElement.slideDown('normal');
        return false;
        }
      }
    );
  }
$(document).ready(function() {
initMenu();
$(".close").click(
			function () {
				$(this).parent().fadeTo(400, 0, function () { // Links with the class "close" will close parent
					$(this).slideUp(400);
				});
				return false;
			}
		);
});
<!--
/*第一种形式 第二种形式 更换显示样式*/
function setTab(m,n){
 var tli=document.getElementById("menu"+m).getElementsByTagName("li");
 var mli=document.getElementById("piece"+m).getElementsByTagName("ul");
 for(i=0;i<tli.length;i++){
  tli[i].className=i==n?"hover":"";
  mli[i].style.display=i==n?"block":"none";
 }
}
//-->
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆登陆</title>
</head>

<body>
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="mian" style="height: 500px">
	<div id="tabs0">
        <div class="hdk">
         <ul class="menu0" id="menu0">
          <li onClick="setTab(0,0)" class="hover">登录</li>
         </ul>
         </div>
         <div class="piece" id="piece0">
          <ul class="block">
          <li>
          	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td>&nbsp;</td>
                <td><label for="checkbox"></label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <form action="login_utlogin.do" method="post">
              <tr>
                <td width="6%">&nbsp;</td>
                <td width="31%" align="right" style="color:#000; font-size:14px; line-height:50px; line-height:50px;">用户名：</td>
                <td width="57%"><input type="text" name="userName" id="textfield" / class="yanse"></td>
                <td width="6%">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td align="right" style="color:#000; font-size:14px; line-height:50px; line-height:50px;">密 码：</td>
                <td>
                <input type="text" name="passWord" id="textfield2" /class="yanse"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><table width="205" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="41"><div class="login">
                    <input style="background: #FFC815;border: none;" type="submit" value="登陆" /></div></td>
                  </tr>
                </table></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><label for="checkbox"></label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              </form>
            </table>
          </li>
		   </ul>
          <ul>
          <li><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td>&nbsp;</td>
                <td><label for="checkbox"></label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td width="6%">&nbsp;</td>
                <td width="31%" align="right" style="color:#000; font-size:14px; line-height:50px; line-height:50px;">用户名：</td>
                <td width="57%"><input type="text" name="textfield" id="textfield" / class="yanse"></td>
                <td width="6%">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td align="right" style="color:#000; font-size:14px; line-height:50px; line-height:50px;">邮箱：</td>
                <td>
                <input type="text" name="textfield2" id="textfield2" /class="yanse"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td width="6%">&nbsp;</td>
                <td width="31%" align="right" style="color:#000; font-size:14px; line-height:50px; line-height:50px;">头像：</td>
                <td width="57%"><div style="height:0px; overflow:hidden; width:0;">
<input type="file"   id="a1" onChange="alert(this.value);document.getElementById('t1').value = this.value;"   /></div>
<input type="text"  id="t1"/ class="yanse"><input type="submit"  onclick="document.getElementById('a1').click();"  value="浏览"/ class="yanse1"></td>
                <td width="6%">&nbsp;</td>
              </tr>
              <tr>
                <td width="6%">&nbsp;</td>
                <td width="31%" align="right" style="color:#000; font-size:14px; line-height:50px; line-height:50px;">电话：</td>
                <td width="57%"><input type="text" name="textfield" id="textfield" / class="yanse"></td>
                <td width="6%">&nbsp;</td>
              </tr>
              <tr>
                <td width="6%">&nbsp;</td>
                <td width="31%" align="right" style="color:#000; font-size:14px; line-height:50px; line-height:50px;">密码：</td>
                <td width="57%"><input type="password" name="textfield" id="textfield" / class="yanse"></td>
                <td width="6%">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><table width="205" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="89"><div class="login"><a href="#">免费注册</a></div></td>
                    <td width="6">&nbsp;</td>
                    <td width="66">已经注册请</td>
                    <td width="10" align="center" style="color:#999">&nbsp;</td>
                    <td width="28"><a href="#" style="color:#999">登录</a></td>
                    <td width="12">&nbsp;</td>
                  </tr>
                </table></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><label for="checkbox"></label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table></li>
 		</ul>
        <ul class="block">
          <li>
          	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td>&nbsp;</td>
                <td><label for="checkbox"></label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td width="6%">&nbsp;</td>
                <td width="31%" align="right" style="color:#000; font-size:14px; line-height:50px; line-height:50px;"> 注册邮箱 ：</td>
                <td width="57%"><input type="text" name="textfield" id="textfield" / class="yanse"></td>
                <td width="6%">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td align="right" style="color:#000; font-size:14px; line-height:50px; line-height:50px;">重复邮箱：</td>
                <td>
                <input type="text" name="textfield2" id="textfield2" /class="yanse"></td>
                <td>&nbsp;</td>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><table width="205" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="41"><div class="login"><a href="#">找回密码</a></div></td>
                    <td width="10">&nbsp;</td>
                    <td width="69">&nbsp;</td>
                    <td width="14">&nbsp;</td>
                    <td width="47">&nbsp;</td>
                    <td width="17">&nbsp;</td>
                  </tr>
                </table></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><label for="checkbox"></label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>
          </li>
		   </ul>
          <ul>
         </div>
        </div>
 </div>
 <jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
