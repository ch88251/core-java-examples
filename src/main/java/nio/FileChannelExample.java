package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileChannelExample {

    public static void main(String[] args) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocateDirect(64 * 1024);

        try (FileChannel channel = FileChannel.open(
                Path.of("transactions.bin"),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            for (int i = 0; i < 1_000_000; i++) {

                if (buffer.remaining() < Long.BYTES) {
                    flushBuffer(channel, buffer);
                }

                buffer.putLong(i);
            }

            flushBuffer(channel, buffer);
        }
    }

    private static void flushBuffer(
            FileChannel channel,
            ByteBuffer buffer) throws IOException {

        buffer.flip();

        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }

        buffer.clear();
    }
}
