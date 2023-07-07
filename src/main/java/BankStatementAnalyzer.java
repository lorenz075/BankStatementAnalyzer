package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

	private static final String RESOURCES = "src/main/resources/";

	
	public void analyze(String fileName, final BankStatementParser bankStatementParser) throws IOException {
		final Path path = Paths.get(RESOURCES + fileName);
		final List<String> lines = Files.readAllLines(path);

		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		
		collectSummary(bankStatementProcessor);
	}
	

	private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
		System.out.println("The total for all transactions is: " + bankStatementProcessor.calculateTotalAmount());

		System.out.println("Total in January " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("Total in February " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		
		System.out.println("The total salary received is R$" + bankStatementProcessor.calculateTotalForCategory("Salary"));
		
	}

}
