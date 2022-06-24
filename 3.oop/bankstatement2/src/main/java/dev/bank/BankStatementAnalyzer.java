package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Processor;

import deb.Bank.domain.BankTransaction;
import dev.bank.data.BankStatementTSVParser;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {

	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1��° ��� �䱸����, ��� �ŷ�����(BankStatement)�� �� ����ϱ� / Phase1

		// 1. ���� ��� Ȯ��, �б�
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		final List<String> lines = Files.readAllLines(path);

		// 2. �о���� ���� �Ľ�(parsing)
		final BankStatementTSVParser tsvParser = new BankStatementTSVParser();
		List<BankTransaction> bankTransactions = tsvParser.parseLinesFromTSV(lines);

		//3. ��ɺ�(�� ����� ���� or �� �� ����� ���� or ī�װ� �� ��) ����ó���� ��ü ����
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

		// ����� ���� �м�(Analazer) ���(summary) ���
		collectSummary(processor);
		
	}
	//�м� ��� summary
	private static void collectSummary(BankStatementProcessor processor) {
		System.out.println("�� ��� �ݾ���" + processor.calculateTotalAmount() + "�Դϴ�.");

		System.out.println("2���� ����� ������ " + processor.calculateListInMonth(Month.FEBRUARY) + "�Դϴ�.");
		
		System.out.println("salary(�޿�) ī�װ��� �� ����� ������" + processor.calculateTotalForCategory("Salary") + "�Դϴ�.");
		
	}
	
	
}
