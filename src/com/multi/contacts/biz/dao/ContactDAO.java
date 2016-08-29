package com.multi.contacts.biz.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.multi.contacts.biz.domain.Contact;

@Repository
public class ContactDAO extends SqlMapClientDaoSupport {
	
	@Autowired
	public void setSqlMapClientWorkAround(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> selectAll() {
		return (List<Contact>) this.getSqlMapClientTemplate().queryForList("contact.selectAll");
	}

	@SuppressWarnings("unchecked")
	public List<Contact> selectAll(int pageNo, int pageSize) {
		int skip = (pageNo-1) * pageSize;
		int max = pageSize;
		return (List<Contact>) this.getSqlMapClientTemplate().queryForList("contact.selectAll", skip, max);
	}
	
	public Contact selectOne(Contact m) {
		return (Contact) this.getSqlMapClientTemplate().queryForObject("contact.selectAll", m);
	}
	
	public int selectCnt() {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("contact.selectCnt");
	}
	
	public int insert(Contact m) {
		return (Integer) this.getSqlMapClientTemplate().insert("contact.insert", m);
	}
	
	public int update(Contact m) {
		return (Integer) this.getSqlMapClientTemplate().update("contact.update", m);
	}
	public int delete(Contact m) {
		return (Integer) this.getSqlMapClientTemplate().update("contact.delete", m);
	}
	
	
	
}
