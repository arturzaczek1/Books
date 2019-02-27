package solution2list;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@Getter
@ToString
public class Book implements Comparable<Book> {

    String title;
    String author;
    Integer count;

    public Book(){

    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
        this.count = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTitle(), getAuthor());
    }

    @Override
    public int compareTo(Book o) {
        int result;
        result = this.author.compareTo(o.author);
        if (result == 0) {
            result = this.title.compareTo(o.title);
        }
        return result;
    }
}
