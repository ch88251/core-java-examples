package collections;

import java.time.LocalDateTime;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TransactionExample {

    public static void main(String[] args) {

        var transactions = new TreeMap<LocalDateTime, String>();

        transactions.put(
            LocalDateTime.of(2026, 11, 27, 9, 0),
            "Deposit $500"
        );

        transactions.put(
            LocalDateTime.of(2026, 11, 27, 10, 0),
            "Withdrawal $100"
        );

        transactions.put(
            LocalDateTime.of(2026, 11, 27, 11, 0),
            "Deposit $250"
        );

        transactions.put(
            LocalDateTime.of(2026, 11, 27, 12, 0),
            "Transfer $75"
        );

        transactions.put(
            LocalDateTime.of(2026, 11, 27, 13, 0),
            "Withdrawal $200"
        );

        var start = LocalDateTime.of(2026, 11, 27, 10, 0);
        var end = LocalDateTime.of(2026, 11, 27, 12, 0);

        NavigableMap<LocalDateTime, String> results =
            transactions.subMap(start, true, end, true);

        results.forEach((time, transaction) ->
            System.out.println(time + " : " + transaction)
        );
    }
}