package exercise;

import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Files;

class App {

    // BEGIN
    private static Path getFullPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    private static CompletableFuture<String> getContent(String source) {
        return CompletableFuture.supplyAsync(() -> {
            String content;

            try {
                content = Files.readString(getFullPath(source));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return content;
        });
    }

    public static CompletableFuture<String> unionFiles(String source1, String source2, String dest) {
        CompletableFuture<String> content1 = getContent(source1);
        CompletableFuture<String> content2 = getContent(source2);

        return content1.thenCombine(content2, (cont1, cont2) -> {
            String text = cont1 + cont2;
            try {
                Files.writeString(getFullPath(dest), text, StandardOpenOption.CREATE);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return "Ok!";
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
    }
    // END

    public static void main(String[] args) {
        String source1 = "src/main/resources/file1.txt" ;
        String source2 = "src/main/resources/file2.txt" ;
        String dest = "src/main/resources/result.txt ";

        App.unionFiles(source1, source2, dest);
    }
}

