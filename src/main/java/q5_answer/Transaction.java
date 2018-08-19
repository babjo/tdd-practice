package q5_answer;

import com.google.common.base.Objects;

public class Transaction {
    private String date;
    private int amount;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Transaction that = (Transaction) o;
        return amount == that.amount &&
               Objects.equal(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date, amount);
    }

    public int amount() {
        return amount;
    }

    public String date() {
        return date;
    }
}
