package dev.bank.data;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.bank.domain.BankTransaction;

// �ϳ��� å��, ���޹��� �����͸� �Ľ�(��ȯ) �� ��ȯ�ϴ� ����
@Component("parser")
public class BankStatementCSVParser implements BankStatementParser{
	
	// ��¥ Ÿ�Կ� ���� ���� �ʵ�
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// 2������ �޼���(������ �Ľ�)
	
	// 1. �� �ٸ� �Ľ�, �� Ŭ���� �������� ����� ����
	public BankTransaction parseFrom(final String line) {
		String[] columns = line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		return new BankTransaction(date, amount, description);
	}
	
	// 2. �� �پ� �Ľ� ��, ����Ʈ�� �߰�
	// BankTransaction -> model Ŭ����
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		
		for (String line: lines) {
			BankTransaction bankTransaction = parseFrom(line);
			bankTransactions.add(bankTransaction);
		}
		
		return bankTransactions;
	}
	
}