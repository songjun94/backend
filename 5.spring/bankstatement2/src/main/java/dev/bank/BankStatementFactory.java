package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;

@Configuration // 이 클래스가 빈 구성정보(Ioc 컨테이너) 로 활용할 수 있도록 설정 or 지정
public class BankStatementFactory {

//	@Bean // Bean 구성 정보 냅에 등록되어 있는 하나의 Bean으로 지정
//	public BankStatementAnalyzer bankStatementAnalyzer() {
//		return new BankStatementAnalyzer(new BankStatementCSVParser());
//		
//	}
	
	@Bean
	public BankStatementCSVParser bankStatementCSVParser() {
		return new BankStatementCSVParser();
	}
	@Bean
	public BankStatementAnalyzer bankStatementAnalyzer() {
		return new BankStatementAnalyzer(bankStatementCSVParser());
	
	}

}


