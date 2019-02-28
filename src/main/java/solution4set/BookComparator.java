package solution4set;

import java.util.Comparator;

public class BookComparator implements Comparator<Book4> {
    @Override
    public int compare(Book4 o1, Book4 o2) {
        int result;
        result = o1.getTitle().compareTo(o2.getTitle());
        if(result == 0){
            result = o1.getAuthor().compareTo(o2.getAuthor());
        }
        return result;
    }
}
