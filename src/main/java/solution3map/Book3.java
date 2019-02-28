package solution3map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@Getter
@ToString
public class Book3 implements Comparable<Book3> {
    private String author;
    private String title;

    public Book3() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book3)) return false;
        Book3 book3 = (Book3) o;
        return Objects.equals(getAuthor(), book3.getAuthor()) &&
                Objects.equals(getTitle(), book3.getTitle());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getAuthor(), getTitle());
    }

    @Override
    public int compareTo(Book3 o) {
        int result = this.getTitle().compareTo(o.getTitle());
        if (result == 0) {
            result = this.getAuthor().compareTo(o.getAuthor());
        }
        return result;
    }
}
