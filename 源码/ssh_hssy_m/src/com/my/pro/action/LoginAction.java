package com.my.pro.action;
/**
 * 和登陆有关的都在这里
 */

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.my.pro.model.Manage;
import com.my.pro.service.ManageService;
import com.my.pro.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {
	//============依赖注入start================
			@Autowired
			private ManageService manageService;//管理
			@Autowired
			private UserService userService;//用户
			
			//===========依赖注入end==================
			
			//-------------------------华丽分割线---------------------------------------------
			
			//============自定义参数start=============
			private Integer role;
			public Integer getRole() {
				return role;
			}
			public void setRole(Integer role) {
				this.role = role;
			}

			private String userName;//用户名
			private String passWord;//密码
			private String realName;
			private Integer type;
			
			//============自定义参数end=============
			
			//-------------------------华丽分割线---------------------------------------------
			
			public Integer getType() {
				return type;
			}
			public void setType(Integer type) {
				this.type = type;
			}
			public String getRealName() {
				return realName;
			}
			public void setRealName(String realName) {
				this.realName = realName;
			}
			public String getUserName() {
				return userName;
			}
			public void setUserName(String userName) {
				this.userName = userName;
			}
			public String getPassWord() {
				return passWord;
			}
			public void setPassWord(String passWord) {
				this.passWord = passWord;
			}

			//============文件上传start=============
			private File file;
			//提交过来的file的名字
		    private String fileFileName;
		    //提交过来的file的MIME类型
		    private String fileContentType;
		    public File getFile() {
				return file;
			}
			public void setFile(File file) {
				this.file = file;
			}
			public String getFileFileName() {
				return fileFileName;
			}
			public void setFileFileName(String fileFileName) {
				this.fileFileName = fileFileName;
			}
			public String getFileContentType() {
				return fileContentType;
			}
			public void setFileContentType(String fileContentType) {
				this.fileContentType = fileContentType;
			}
			//============文件上传end=============
			
			//-------------------------华丽分割线---------------------------------------------

			public String login() {
				return "login";
			}
			public String login2() {
				return "success";
			}
			//用户登陆
			public String ulogin() {
				return "success";
			}
			public String home() {
				return "success";
			}
			
			//注册
			public String res(){
				Manage m = new Manage();
				m.setName(userName);
				m.setPassWord(passWord);
				m.setRealName(realName);
				m.setType(2);
				manageService.save(m);
				ActionContext.getContext().put("url", "/login_ulogin.do");
				return "redirect";
			}
			
			//用户登陆
			public String utlogin(){
				String hql = "from Manage where name = :userName and passWord = :passWord and type = :type";
				  Map<String,Object> alias = new HashMap<String,Object>();
				  alias.put("userName",userName);
				  alias.put("passWord", passWord);
				  alias.put("type", type);
				List<Manage> manageList=manageService.getByHQL(hql, alias);
				if(manageList.size()>0){
					//将用户信息放入session
					HttpSession session = ServletActionContext.getRequest()
							.getSession();
					session.setAttribute("role",  manageList.get(0).getType());
					session.setAttribute("userName", manageList.get(0).getRealName());
					session.setAttribute("userId",manageList.get(0).getId() );
					session.setAttribute("manage", manageList.get(0));
					session.setAttribute("roleId", type);
					ActionContext.getContext().put("url", "/login_uIndex.do");
					return "redirect";
				}else{
					ActionContext.getContext().put("url", "/login_ulogin.do");
					return "redirect";
				}
				
			}
	       //登录
			public String toLogin(){
				String hql = "from Manage where name = :userName and passWord = :passWord and type = :type";
				  Map<String,Object> alias = new HashMap<String,Object>();
				  alias.put("userName",userName);
				  alias.put("passWord", passWord);
				  alias.put("type", type);
						List<Manage> manageList=manageService.getByHQL(hql, alias);
						if(manageList.size()>0){
							//将用户信息放入session
							HttpSession session = ServletActionContext.getRequest()
									.getSession();
							session.setAttribute("role",  manageList.get(0).getType());
							session.setAttribute("userName", manageList.get(0).getRealName());
							session.setAttribute("userId",manageList.get(0).getId() );
							session.setAttribute("manage", manageList.get(0));
							session.setAttribute("roleId", role);
							return "index";
						}else{
							return "login";
						}
			}
			
			   //退出
				public String tuichu() {
					ActionContext ac = ActionContext.getContext();
					Map session = ac.getSession();
					session.remove("userName");
					session.remove("userId");
					return "login";
				}
				
		
}
