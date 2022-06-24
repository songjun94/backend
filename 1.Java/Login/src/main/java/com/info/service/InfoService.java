
// todoservice.java
package com.info.service;

import java.util.List;

import com.info.dao.InfoDAO;
import com.info.model.Info;

public class InfoService {
	
	private final InfoDAO infoDAO;
	
	public InfoService() {
		infoDAO = new InfoDAO();
	}
	
	// 1. 전체 조회 기능 findAll()
	public List<Info> findAll() {
		return infoDAO.findAll();
	}
	
	// 2. 조회기능2, 할 일 순서 번호로 하나의 Info 조회 메서드
	public Info findByInfo_number(Long info_number) {
		return infoDAO.findByInfo_number(info_number);
	}

	public int save(Info newInfo) {
		return infoDAO.save(newInfo);
	}

	public Info updateByInfo_number(Long infoNumber, Info info) {
		return null;
	}

	public Info deleteByInfo_number(Long infoNumber) {
		return null;
	}
}
