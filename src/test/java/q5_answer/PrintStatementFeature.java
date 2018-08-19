package q5_answer;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrintStatementFeature {

    private Account account;

    @Mock
    Console console;

    @Spy
    Clock clock = new Clock();

    @BeforeEach
    public void setUp() {
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        this.account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void print_statement_containing_all_transactions() {
        given(clock.todayAsString()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }

}
