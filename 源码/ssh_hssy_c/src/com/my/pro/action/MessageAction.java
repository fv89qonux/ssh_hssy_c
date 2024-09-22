package com.my.pro.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.my.pro.dto.MessageDto;
import com.my.pro.model.Message;
import com.my.pro.service.MessageService;
import com.my.pro.service.UserService;
import com.my.pro.utils.UserUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller("messageAction")
@Scope("prototype")
public class MessageAction extends ActionSupport implements ModelDriven<Message> {
	@Autowired
	private UserService userService;
	private int otherId;
	private Message message;
	
	@Autowired
	private MessageService messageService;
	@Override
	public Message getModel() {
		if(message==null) message = new Message();
		return message;
	}
	/**
	 * 页面一开始加载的时候，就进行聊天记录查询
	 * @throws IOException 
	 */
	public void findMessageJIluList() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			List<MessageDto> messages = messageService.updateMessageJIluList(userId);
			out = resp.getWriter();
			 System.out.println(JSONArray.fromObject(messages).toString());
			 out.write(JSONArray.fromObject(messages).toString());
	    }
	}
	
	public String message(){
		Integer loginId = UserUtils.getLoginId();
		if(loginId == null){
			ActionContext.getContext().put("url", "/login_login.do");
			return "redirect";
		}
		return SUCCESS;
	}
	
	/**
	 * 发送消息
	 * @throws IOException
	 */
	public void sendMessage() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			JSONObject json  = new JSONObject();
			String c = new String(message.getContent().getBytes("ISO-8859-1"),"UTF-8");
			
			message.setContent(c);
			int re = messageService.saveMessage(userId,message);
			if(re<0){//失败
				json.put("result", 2);
			}else{
				json.put("result", 1);
			}
			out = resp.getWriter();
			/* System.out.println(JSONArray.fromObject(messages).toString());*/
			 out.write(json.toString());
	    }
		
	}
	
	public void findMessage() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		HttpSession session =	ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userId") != null){
			int userId = Integer.parseInt( session.getAttribute("userId").toString());
			List<MessageDto> messages = messageService.updateMessage(userId);
			out = resp.getWriter();
			 System.out.println(JSONArray.fromObject(messages).toString());
			 out.write(JSONArray.fromObject(messages).toString());
	    }
	}
}
