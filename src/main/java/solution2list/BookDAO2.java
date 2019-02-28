package solution2list;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDAO2 {
    List<Book2> books = new ArrayList<>();
    private static final String LOCATION = "src\\main\\resources\\biblioteka.txt";

    private void initializeBooks() {
        List<String> stringList = initializeListOfStrings();
        for(String strings : stringList){
            Book2 book = parse(strings);
            if(checkIfExist(book)){
                Book2 book1 = books.stream().filter(a->a.equals(book)).findFirst().get();
                book1.setCount(book1.getCount() + 1);
            } else {
                books.add(book);
            }
        }
    }


    private List<String> initializeListOfStrings() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(LOCATION));
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Book2 parse(String string) {
        String arr[] = string.split(";");
        Book2 book = new Book2(arr[0].trim(), arr[1].trim());
        return book;
    }

    private boolean checkIfExist(Book2 book) {
        return books.stream().filter(a -> a.equals(book)).anyMatch(a -> a.equals(book));
    }

    private void sortBooks() {
        books.sort(Book2::compareTo);
    }

    public void print() {
        initializeBooks();
        sortBooks();
        books.forEach(a -> System.out.println(a.toString()));
    }
}
