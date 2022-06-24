package dev.bank;

import java.io.IOException;

public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		
//		final BankStatementParser parser = new BankStatementCSVParser();
//
//		// Analyzer 생성
//		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer(parser);
	
		BankStatementFactory factory = new BankStatementFactory();
		BankStatementAnalyzer analyzer = factory.bankStatementAnalyzer();
		
		
		
		// 분석 수행
		analyzer.analyze("bank-data-simple.csv");
	}
	
	
}
