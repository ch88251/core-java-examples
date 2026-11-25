package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BufferedWriteExample {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("transactions.csv");

        long start = System.nanoTime();

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            for (int i = 0; i < 1_000_000; i++) {
                writer.write("TX-" + i + ",DEPOSIT,100.00");
                writer.newLine();
            }
        }

        double elapsed = (System.nanoTime() - start) / 1e9;

        System.out.printf("Elapsed time: %.3f seconds%n", elapsed);
    }
}
