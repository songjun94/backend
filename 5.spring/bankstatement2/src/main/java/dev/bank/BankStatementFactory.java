package dev.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.bank.data.BankStatementCSVParser;

@Configuration // �� Ŭ������ �� ��������(Ioc �����̳�) �� Ȱ���� �� �ֵ��� ���� or ����
public class BankStatementFactory {

//	@Bean // Bean ���� ���� ���� ��ϵǾ� �ִ� �ϳ��� Bean���� ����
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

