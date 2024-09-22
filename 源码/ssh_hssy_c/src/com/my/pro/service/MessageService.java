package com.my.pro.service;


import java.util.List;

import com.my.pro.dto.MessageDto;
import com.my.pro.model.Message;


public interface MessageService {

	List<MessageDto> updateMessageJIluList(int userId);

	int saveMessage(int userId, Message message);

	void updatejinggao(int userId);

	List<MessageDto> updateMessage(int userId);

}
