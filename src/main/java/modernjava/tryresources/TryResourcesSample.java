package modernjava.tryresources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryResourcesSample {

    private final static int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        System.out.println("-- BAD PRACTICE --");
        copyBadPractice("from.txt", "to.txt");

        System.out.println("\n-- GOOD PRACTICE --");
        copyGoodPractice("from.txt", "to.txt");
    }

    private static void copyBadPractice(String from, String to) throws IOException {
        Path fromPath = Paths.get("src/main/resources", from);
        Path toPath = Paths.get("src/main/resources", to);

        InputStream inStream = Files.newInputStream(fromPath);
        try {
            OutputStream outStream = Files.newOutputStream(toPath);
            try {
                byte[] buffer = new byte[BUFFER_SIZE];
                int byteCount;
                while ((byteCount = inStream.read(buffer)) >= 0) {
                    outStream.write(buffer, 0, byteCount);
                }
            } finally {
                outStream.close();
            }
        } finally {
            inStream.close();
        }

        System.out.println("Finished copying the file.");
    }

    private static void copyGoodPractice(String from, String to) throws IOException {
        Path fromPath = Paths.get("src/main/resources", from);
        Path toPath = Paths.get("src/main/resources", to);

        try (InputStream inStream = Files.newInputStream(fromPath);
             OutputStream outStream = Files.newOutputStream(toPath)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int byteCount;
            while ((byteCount = inStream.read(buffer)) >= 0) {
                outStream.write(buffer, 0, byteCount);
            }
        }

        System.out.println("Finished copying the file.");
    }

}
