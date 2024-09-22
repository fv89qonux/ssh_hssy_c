package com.my.pro.dao;
import java.util.List;
import java.util.Set;

import com.my.pro.base.BaseDao;
import com.my.pro.model.Message;


public interface MessageDao extends BaseDao<Message>{

	List<Message> findMessageJIluList(Set<Integer> sets);

	Message findJGByUserId(int userId);

}
