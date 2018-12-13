import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;


public class BookTest {
    @Test
    public List<Book> initializelist() {
        try {
            List<String> listBeforeParsing = Resources.readLines(Resources.getResource("biblioteka.txt"), Charset.forName("ISO-8859-1"));
            List<Book> books = new ArrayList<>();
            for (String line : listBeforeParsing) {
                books.add(Book.builder().title(line.trim().replaceAll(".+;", "").trim()).author(line.trim().replaceAll(";.+", "").trim()).build());
            }
            return books;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void print() {
        List<Book> books = initializelist();
        books.sort(Book::compareTo);
        Map<Book, Integer> counts = new LinkedHashMap<>();

        for (Book str : books) {
            if (counts.containsKey(str)) {
                counts.put(str, counts.get(str) + 1);
            } else {
                counts.put(str, 1);
            }
        }

        for (Map.Entry<Book, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " ilość = " + entry.getValue());
        }
    }
}
