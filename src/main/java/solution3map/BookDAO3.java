package solution3map;

import solution1map.Book;
import solution2list.Book2;
import sun.dc.pr.PRError;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class BookDAO3 {
    private Map<Book3, Integer> map = new TreeMap<>();
    private static final String PATH = "src\\main\\resources\\biblioteka.txt";

    private void initializeMap() {
        List<String> list = initializeStringList();
        for (String s : list) {
            if (!map.containsKey(parseBooks(s))) {
                map.put(parseBooks(s), 1);
            } else {
                Integer count = map.get(parseBooks(s));
                map.put(parseBooks(s), count + 1);
            }
        }
    }

    public List<String> initializeStringList() {
        List<String> stringList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader(PATH));
            while (scanner.hasNext()) {
                stringList.add(scanner.nextLine());
            }
            return stringList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Book3 parseBooks(String string) {
        Book3 book = new Book3();
        book.setAuthor(string.trim().replaceAll("[;].*", "").trim());
        book.setTitle(string.trim().replaceAll(".*[;]", "").trim());
        return book;
    }

    public void printBooks() {
        initializeMap();
        map.forEach((a, b) -> System.out.println(a.toString() + ", count: " + b));
    }
}
