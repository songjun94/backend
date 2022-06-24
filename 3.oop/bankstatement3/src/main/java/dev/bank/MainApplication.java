package dev.bank;

import java.io.IOException;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;

public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		// Analyzer ����
		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		// Parser ����
		final BankStatementParser parser = new BankStatementCSVParser();
	
		// �м� ����
		analyzer.analyze("bank-data-simple.csv", parser);
	}
	
	
}