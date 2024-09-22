package com.my.pro.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.my.pro.base.impl.BaseDaoImpl;
import com.my.pro.dao.MessageDao;
import com.my.pro.model.Message;
@Repository("mesageDao")
@SuppressWarnings("unchecked")
public class MessageDaoImpl extends BaseDaoImpl<Message>  implements MessageDao{

	/**
	 * 查询所群里所有人聊天记录
	 */
	@Override
	public List<Message> findMessageJIluList(Set<Integer> sets) {
		String hql ="from Message where sendUser.id in (:alist) and type=1 order by createTime asc";
		Query query = getSession().createQuery(hql);   
		query.setParameterList("alist", sets); 
		return query.list();
	}

	@Override
	public Message findJGByUserId(int userId) {
		String hql ="from Message where sendUser.id =:id and type= 3 order by createTime asc";
		Query query = getSession().createQuery(hql);   
		query.setParameter("id", userId); 
		return (Message)query.uniqueResult();
	}

}
