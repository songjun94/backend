// Controller.java
package com.info.controller;

import java.util.List;

import com.info.model.Info;
import com.info.service.InfoService;
import com.info.view.InfoView;

public class InfoController {
	// 사용자의 요청에 따라 액션을 분기'만' 해주는 역할
	
	// todos 리스트를 필드로 선언
	private List<Info> infos;
	private final InfoView infoView; // 구성관계(Composition)
	private final InfoService infoService;
	private Exception errorObject;
	
	// 기본 생성자
	public InfoController() {
		this.infoView = new InfoView();
		this.infoService = new InfoService();
	}
	
	// 전체 데이터 조회 처리를 위한 분기
	public void findAll() {
		infos = infoService.findAll();
		infoView.findAll(infos);
	}
	
	// 하나의 데이터 조회 처리를 위한 분기
	public void findByInfo_number(Long info_number) {
		Info info = infoService.findByInfo_number(info_number);
		
		if(info != null) {
			infoView.findByInfo_number(info);
		} else {
			// 해당하는 Todo 데이터가 존재하지 않습니다., 예외 객체 생성
			errorObject = new Exception("해당하는 info 데이터가 존재하지 않습니다."); 
			infoView.errorPage(errorObject);
		}
	}
	
	public void save(Info newInfo) {
		int result = infoService.save(newInfo);
		
		if(result > 0) {
			infoView.successPage();
		} else {
			infoView.errorPage();
		}
	}

	public void updateByInfo_number(Long infoNumber, Info info) {
		Info previousInfo = infoService.updateByInfo_number(infoNumber, info);
		
		if(previousInfo != null) {
			infoView.update(previousInfo);
		} else {
			errorObject = new Exception("수정 실패");
			infoView.errorPage(errorObject);
		}
	}

	public void deleteByInfo_number(Long infoNumber) {
		Info deletedInfo = infoService.deleteByInfo_number(infoNumber);
		
		if(deletedInfo != null) {
			infoView.delete(deletedInfo);
		} else {
			errorObject = new Exception("삭제 실패");
		}
	}
}

