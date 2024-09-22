package com.my.pro.service.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.pro.dao.MessageDao;
import com.my.pro.dao.UserDao;
import com.my.pro.dao.UserMessageDao;
import com.my.pro.dto.MessageDto;
import com.my.pro.model.Message;
import com.my.pro.model.User;
import com.my.pro.model.UserMessage;
import com.my.pro.service.MessageService;

import freemarker.template.SimpleDate;

@Service("messageService")
public class MessageServiceImpl implements MessageService{
    @Autowired
	private MessageDao messageDao;
    @Autowired
	private UserDao userdao;
    @Autowired
    private UserMessageDao userMessageDao;
	@Override
	public int saveMessage(int userId, Message message) {
		 User u = userdao.load(userId);
		 Message me = new Message();
		 me.setContent(message.getContent());
		 me.setCreateTime(new Date());
		 me.setSendUser(u);
		 messageDao.add(me);
		 //抽取所有现在注册的所有用户
		List<User> us = userdao.findAll();
		if(us!=null && us.size()>0){
			for(User user : us){
				UserMessage um = new UserMessage();	
				um.setIsRead(2);
				um.setSendUser(u);
				um.setResivrUser(user);
				um.setMessage(me);
				um.setCreateTime(new Date());
				userMessageDao.add(um);
			}
		}
		 
		 return 1;
	}
	@Override
	public void updatejinggao(int userId) {
		// TODO Auto-generated method stub
		User u =userdao.load(userId);
		//查看这个用户还有没有警告，如果有就不加了，如果美誉。。。
		Message me = messageDao.findJGByUserId(userId);
		if(me == null){
			Message mes = new Message();
			mes.setCreateTime(new Date());
			mes.setContent("警告");
			mes.setSendUser(u);
//			mes.setType(3);
			messageDao.add(mes);
		}
	}
	@Override
	public List<MessageDto> updateMessageJIluList(int userId) {
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd : HH:ss:mm");
		 List<UserMessage> us = userMessageDao.findMessageJIluList(userId);
		 List<MessageDto> mes = new ArrayList<MessageDto>();
		if(us!=null&&us.size()>0){
			for(UserMessage um : us){
				um.setIsRead(1);
				userMessageDao.update(um);
				//返回message
				MessageDto td = new MessageDto();
				td.setContent(um.getMessage().getContent());
				td.setCreateTime(um.getCreateTime());
				td.setResivrUserId(um.getResivrUser().getId());
				td.setSendUserId(um.getSendUser().getId());
				td.setSendUserName(um.getSendUser().getUserName());
				td.setCreateTimeStr(sp.format(um.getCreateTime()));
				mes.add(td);
			}
		}
		return mes;
	}
	@Override
	public List<MessageDto> updateMessage(int userId) {
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd : HH:ss:mm");
		 List<UserMessage> us = userMessageDao.findMessage(userId);
		 List<MessageDto> mes = new ArrayList<MessageDto>();
			if(us!=null&&us.size()>0){
				for(UserMessage um : us){
					um.setIsRead(1);
					userMessageDao.update(um);
					//返回message
					if(um.getMessage().getSendUser().getId() != userId){
						MessageDto td = new MessageDto();
						td.setContent(um.getMessage().getContent());
						td.setCreateTime(um.getCreateTime());
						td.setResivrUserId(um.getResivrUser().getId());
						td.setSendUserId(um.getSendUser().getId());
						td.setSendUserName(um.getSendUser().getUserName());
						td.setCreateTimeStr(sp.format(um.getCreateTime()));
						mes.add(td);
					}
					
				}
			}
			return mes;
	}

}
