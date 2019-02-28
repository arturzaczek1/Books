package solution4set;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BookDAO4 {

    private Set<Book4> set = new TreeSet<>(new BookComparator());
    private static final String PATH = "src\\main\\resources\\biblioteka.txt";

    private List<String> initializeStringList() {
        List<String> stringList = new ArrayList<>();
        File file = new File(PATH);
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\n");
            while (scanner.hasNext()) {
                stringList.add(scanner.nextLine());
            }
            return stringList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initializeSet() {
        List<String> stringList = initializeStringList();
        for (String string : stringList) {
            Book4 book = parse(string);
            if (checkIfExist(book)) {
                Book4 book1 = set.stream().filter(a -> a.equals(book)).findFirst().get();
                Integer quantity = book1.getCount() + 1;
                book1.setCount(quantity);
            } else
                book.setCount(1);
            set.add(book);
        }
    }

    private boolean checkIfExist(Book4 book) {
        return set.stream().filter(a -> a.equals(book)).anyMatch(a -> a.equals(book));
    }

    private Book4 parse(String string) {
        Book4 book = new Book4();
        book.setTitle(string.replaceAll(".+;", "").trim());
        book.setAuthor(string.replaceAll(";.+", "").trim());
        return book;
    }

    public void print() {
        initializeSet();
        set.iterator().forEachRemaining(a -> System.out.println(a.toString()));
    }
}
