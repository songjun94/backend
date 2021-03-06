package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;

public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		// Analyzer 생성
		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		// Parser 지정
		final BankStatementParser parser = new BankStatementCSVParser();
	
		// 분석 수행
		analyzer.analyze("bank-data-simple.csv", parser);
	}
	
	
}
