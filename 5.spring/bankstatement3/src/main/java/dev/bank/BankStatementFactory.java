package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;

@Configuration // 이 클래스가 빈 구성정보(Ioc 컨테이) 로 활용할 수 있도록 설정 or 지정
@ComponentScan
public class BankStatementFactory {

//	@Bean
//	public BankStatementAnalyzer bankStatementAnalyzer(BankStatementCSVParser csvParser) {
//		return new BankStatementAnalyzer(csvParser);
//	
//	}

}


