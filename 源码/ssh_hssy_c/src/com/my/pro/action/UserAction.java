package com.my.pro.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.my.pro.model.User;
import com.my.pro.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;


@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	@Autowired
	private UserService userService;
	private int otherId;
	
	public int getOtherId() {
		return otherId;
	}
	public void setOtherId(int otherId) {
		this.otherId = otherId;
	}

	private int groupId;
	private int friendId;

	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	private static final long serialVersionUID = 1L;

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private User user;
	//========================图片上传
    private File file;
    
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

	//提交过来的file的名字
    private String fileFileName;
    
    //提交过来的file的MIME类型
    private String fileContentType;

	//========================图片上传
	public User getModel() {
		if(user==null) user = new User();
		return user;
	}
	public String index(){
		return "index";
	}
	//登陆
	public void login() throws IOException{
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("application/json;charset=UTF-8");
			PrintWriter out = null;
			JSONObject js = new JSONObject();
		User u =userService.load(user);
		if(u == null){
			js.put("message", 1);
		}else{
		HttpSession session =	ServletActionContext.getRequest().getSession();
		session.setAttribute("userName", u.getUserName());
		session.setAttribute("userId", u.getId());
		js.put("message", 2);
		}
		out = resp.getWriter();
		 out.write(js.toString());
		
	}
	public String list() throws IllegalAccessException, InvocationTargetException {
		User tu = (User)ActionContext.getContext().getSession().get("loginUser");
		ActionContext.getContext().put("list", userService.listAllCanSendUser(1));
		return SUCCESS;
	}
	public String add() {
		userService.add(user);
		return "success";
	}
	

}  
