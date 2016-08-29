package com.multi.contacts.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.contacts.biz.dao.ContactDAO;
import com.multi.contacts.biz.domain.Contact;

@Service
public class ContactService {
	
	@Autowired
	private ContactDAO contactDAO;
	
	public List<Contact> selectAll() {
		return contactDAO.selectAll();
	}
	
	public int selectCnt() {
		return contactDAO.selectCnt();
	}
	
	public List<Contact> selectAll(int pageNo, int pageSize) {
		return contactDAO.selectAll(pageNo, pageSize);
	}
	
	public Contact selectOne(Contact c) {
		return contactDAO.selectOne(c);
	}
	
	public int insert(Contact c) {
		return contactDAO.insert(c);
	}
	
	public int update(Contact m) {
		return contactDAO.update(m);
	}
	
	public int delete(Contact m) {
		return contactDAO.delete(m);
	}
}
