package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

// 하나의 책임, 전달받은 데이터를 파싱(변환) 후 반환하는 역할
public class BankStatementTSVParser implements BankStatementParser{
	
	// 날짜 타입에 대한 패턴 필드
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// 2가지의 메서드(데이터 파싱)
	
	// 1. 한 줄만 파싱, 이 클래스 내에서만 사용할 예정
	public BankTransaction parseFrom(final String line) {
		String[] columns = line.split("\t");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		return new BankTransaction(date, amount, description);
	}
	
	// 2. 한 줄씩 파싱 후, 리스트에 추가
	// BankTransaction -> model 클래스
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		
		for (String line: lines) {
			BankTransaction bankTransaction = parseFrom(line);
			bankTransactions.add(bankTransaction);
		}
		
		return bankTransactions;
	}
}
