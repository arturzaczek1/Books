package solution1map;

import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;

import java.util.*;

public class BookDAO {

    private List<Book> initializeList() {
        try {
            List<String> listBeforeParsing = Resources.readLines(Resources.getResource("biblioteka.txt"), Charset.forName("UTF-8"));
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

    public void print() {
        List<Book> books = initializeList();
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
            System.out.println(entry.getKey() + " amount = " + entry.getValue());
        }
    }
}
