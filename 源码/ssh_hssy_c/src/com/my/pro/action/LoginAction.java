package com.my.pro.action;
/**
 * 和登陆有关的都在这里
 */

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.my.pro.model.Comment;
import com.my.pro.model.Manage;
import com.my.pro.model.User;
import com.my.pro.model.Yp;
import com.my.pro.service.CommentService;
import com.my.pro.service.ManageService;
import com.my.pro.service.UserService;
import com.my.pro.service.YpService;
import com.my.pro.utils.UserUtils;
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
			@Autowired
			private CommentService commentService;
			private String phone;
			@Autowired
			private YpService ypService;
			
			//===========依赖注入end==================
			
			//-------------------------华丽分割线---------------------------------------------
			
			public String getPhone() {
				return phone;
			}
			public void setPhone(String phone) {
				this.phone = phone;
			}

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
			//============自定义参数end=============
			
			//-------------------------华丽分割线---------------------------------------------
			
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
			public String res() {
				return "success";
			}
			public String uIndex() {
				//最新5个样片
				List<Yp> subList = null;
				List<Yp> listByAlias = ypService.listByAlias("from Yp where isDelete = 0 order by id desc", null);
				if(listByAlias != null && listByAlias.size()>0){
					if(listByAlias.size() > 5 ){
						 subList = listByAlias.subList(0, 5);
							ActionContext.getContext().put("yps", subList);
					}else{
						ActionContext.getContext().put("yps", listByAlias);
					}
					
					 System.out.println("=================");
					 System.out.println(subList.size());
				}
				//查询最新评论
				List<Comment> listByAlias2 = commentService.listByAlias("from Comment order by id desc", null);
				List<Comment> subList2 = null;
				if(listByAlias2 != null && listByAlias2.size()>0){
					if(listByAlias2.size() > 7 ){
						subList2 = listByAlias2.subList(0, 7);
						ActionContext.getContext().put("pls", subList2);
					}else{
						ActionContext.getContext().put("pls", listByAlias2);
					}
					 
				}
			
				
				return "success";
			}
			//注册
			public String tores(){
				User u = new User();
				
				u.setCreateTime(new Date());
				u.setPassWord(passWord);
				u.setPhone(phone);
				u.setRealName(realName);
				u.setUserName(userName);
				userService.save(u);
				ActionContext.getContext().put("url", "/login_login.do");
				return "redirect";
			}
			
			//用户登陆
			public String utlogin(){
				String hql = "from User where userName = :userName and passWord = :passWord";
				  Map<String,Object> alias = new HashMap<String,Object>();
				  alias.put("userName",userName);
				  alias.put("passWord", passWord);
				  List<User> manageList=userService.getByHQL(hql, alias);
				if(manageList.size()>0){
					//将用户信息放入session
					HttpSession session = ServletActionContext.getRequest()
							.getSession();
					session.setAttribute("userName", manageList.get(0).getRealName());
					session.setAttribute("userId",manageList.get(0).getId() );
					session.setAttribute("manage", manageList.get(0));
					session.setAttribute("roleId", role);
					ActionContext.getContext().put("url", "/login_uIndex.do");
					return "redirect";
				}else{
					ActionContext.getContext().put("url", "/login_login.do");
					return "redirect";
				}
			}
	       //登录
			public String toLogin(){
						String hql = "from Manage where name = :userName and passWord = :passWord";
						  Map<String,Object> alias = new HashMap<String,Object>();
						  alias.put("userName",userName);
						  alias.put("passWord", passWord);
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
				
		public String up(){
			Integer loginId = UserUtils.getLoginId();
			if(loginId == null){
				ActionContext.getContext().put("url", "/login_login.do");
				return "redirect";
			}
			User byId = userService.getById(loginId);
			ActionContext.getContext().put("Obj", byId);
			return "success";
		}
		
		public String xg(){
			Integer loginId = UserUtils.getLoginId();
			if(loginId == null){
				ActionContext.getContext().put("url", "/login_login.do");
				return "redirect";
			}
			User u = userService.getById(loginId);
			u.setPassWord(passWord);
			u.setPhone(phone);
			u.setRealName(realName);
			u.setUserName(userName);
			userService.update(u);
			ActionContext.getContext().put("url", "/login_login.do");
			return "redirect";
		}
}
