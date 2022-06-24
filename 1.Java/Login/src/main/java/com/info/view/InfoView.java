package com.info.view;

import java.util.List;

import com.info.model.Info;

public class InfoView {
	//실제 결과값 출력을 담당하는 역할
	
	// 1. 전체 조회 결과 출력
	public void findAll(List<Info> infos) {
		System.out.println("전체 조회 결과입니다. 사장님");
		for (Info info : infos) {
		      System.out.println();
		}
		
	}
	//2. 하나의 조회 결과 출력
	public void findByInfo_number(Info info) {
	      System.out.println();
	}
	
	//3. 등록 처리 여부 결과 출력
	public void successPage() {
		System.out.println("정상등록 되었습니다.");
	}
	
	//4. 에러 결과 출력
	public void errorPage() {
		System.out.println("문제가 발생하였습니다.");
	}
	
	public void errorPage(Exception error) {
		System.out.println("문제가 발생하였습니다."+ error.getMessage());
	}
	public void update(Info previousInfo) {
		System.out.println("정상수정되었다.");
		System.out.println("수정되기 이전 값:" + previousInfo);
	}
	public void delete(Info deletedInfo) {
		System.out.println("정상삭제되었다.");
		System.out.println("삭제되기 이전 값:" + deletedInfo);
	}
	
	
}
