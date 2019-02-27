package solution1map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Builder
@Getter
@Setter
public class Book implements Comparable<Book> {
    private String author;
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getTitle(), book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTitle());
    }

    private int count;

    @Override
    public String toString() {
        return "Book: " + title +
                " author: " + author ;
    }

    @Override
    public int compareTo(Book o) {
        int result = this.author.compareTo(o.author);
        if (result == 0) {
            result = this.title.compareTo(o.title);
        }
        return result;
    }
}
