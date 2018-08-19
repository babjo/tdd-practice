package q5_answer;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    private final Clock clock;
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(int amount) {
        transactions.add(new Transaction(clock.todayAsString(), amount));
    }

    public void addWithdrawal(int amount) {
        transactions.add(new Transaction(clock.todayAsString(), -amount));
    }

    public List<Transaction> allTransactions() {
        return unmodifiableList(transactions);
    }
}
