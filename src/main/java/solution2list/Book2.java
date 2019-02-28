package solution2list;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@Getter
@ToString
public class Book2 implements Comparable<Book2> {

    String title;
    String author;
    Integer count;

    public Book2(){

    }

    public Book2(String author, String title) {
        this.author = author;
        this.title = title;
        this.count = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book2)) return false;
        Book2 book = (Book2) o;
        return Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTitle(), getAuthor());
    }

    @Override
    public int compareTo(Book2 o) {
        int result;
        result = this.title.compareTo(o.title);
        if (result == 0) {
            result = this.author.compareTo(o.author);
        }
        return result;
    }
}
