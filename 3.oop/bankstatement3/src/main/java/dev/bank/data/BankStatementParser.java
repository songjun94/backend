package dev.bank.data;

import java.util.List;

import dev.bank.domain.BankTransaction;

//Parser ���赵
public interface BankStatementParser {
	BankTransaction ParseFrom(String line);
	List<BankTransaction> parseLineFrom(List<String> lines);
	
}
