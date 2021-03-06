package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementParser;
import dev.bank.data.BankStatementTSVParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer { // Analyzer : 분석기
	// -> 분석기는 결과 분석의 역할만 수행해야하는데, Parsing의 역할도 수행하고 있음.
	// TSVParser를 CSVParser로 변경하기 위해서는 Analyzer 클래스의 변경도 함께 발생 

	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";
	
	// before, Analyzer 클래스 내부에서 직접 생성, 수정하는 방식
	// private final BankStatementParser parser = new BankStatmentCSVParser();
	
	// after, 외부에서 생성자를 통해 인스턴스를 주입(Injection)받도록 수정
	private final BankStatementParser parser;
	
	public BankStatementAnalyzer(BankStatementParser parser) {
		this.parser = parser;
	}

	// 입출금 내역 분석 수행 메서드
	public void analyze(String fileName) throws IOException {
		// 파일 입출력
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);

		// 읽어들인 데이터 파싱(변환)
		List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);

		// 변환된 데이터(실제 데이터 -> Java 객체 BankTransaction)를 활용하여 입출금 내역 연산
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

		// 입출금 내역 결과 출력
		collectSummary(processor);
	}

	// 입출금 내역 분석 결과 출력 메서드
	private static void collectSummary(BankStatementProcessor processor) {
		System.out.println("총 사용 금액은" + processor.calculateTotalAmount() + "입니다.");

		System.out.println("2월의 입출금 내역은 " + processor.calculateListInMonth(Month.FEBRUARY) + "입니다.");

		System.out.println("Salary(급여) 카테고리의 총 입출금 내역은 " + processor.calculateTotalForCategory("Salary") + "입니다.");
	}

}
