package dev.bank.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

// ����� ���� ������(����Ͻ�) ������ ó���ϴ� Ŭ����
public class BankStatementProcessor {

	// �ʵ� ����
	// ���� ��� ���꿡�� ����� ���� ���(List<BankTransaction>)�� ����� ���̱� ������ Processor Ŭ������ �ʵ�� ����
	private final List<BankTransaction> bankTransactions; // �ʱ�ȭ�� ���� ���� ����

	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions; // �����ڸ� ���� �ʵ� �ʱ�ȭ
	}

	// 1. �� ����� ���� ��� ����
	public double calculateTotalAmount() {
		double total = 0d;

		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}

		return total;
	}

	// 2. �� �� ����� ���� ��� ����
	public List<BankTransaction> calculateListInMonth(Month month) {
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
		}

		return bankTransactionsInMonth;
	}

	// 3. ī�װ��� �� �� ����� ���� ��ȸ ��� ����
	public double calculateTotalForCategory(String category) {
		double total = 0d;
		
		for (BankTransaction bankTransaction : bankTransactions) {
//			if(bankTransaction.getDescription().equals(category)) total += bankTransaction.getAmount();
			
			if(bankTransaction.getDescription().equals(category)) {
				total += bankTransaction.getAmount();
			}
		}
		
		return total;
	}
}