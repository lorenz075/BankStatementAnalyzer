package test.java;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

import main.java.BankStatementCSVParser;
import main.java.BankStatementParser;
import main.java.BankTransaction;

public class BankStatementCSVParserTest {

	private final BankStatementParser statementParser = new BankStatementCSVParser();
	
	@Test
	public void shouldParseOneCorrectLine() {
		final String line = "30-01-2017,-50,Tesco";
		
		final BankTransaction result = statementParser.parseFrom(line);
		
		final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
		final double tolerance = 0.0d;
		
		Assert.assertEquals(result.getDate(), expected.getDate());
		Assert.assertEquals(result.getAmount(), expected.getAmount(), tolerance);
		Assert.assertEquals(result.getDescription(), expected.getDescription());
	}

}
