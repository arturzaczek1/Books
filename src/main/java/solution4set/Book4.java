package solution4set;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Book4 {
    private String author;
    private String title;
    private Integer count;

    public Book4 (){
    }

    @Override
    public String toString() {
        return "Book4: " + title +
                ", author=" + author +
                ", quantity=" + count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book4)) return false;
        Book4 book4 = (Book4) o;
        return Objects.equals(getAuthor(), book4.getAuthor()) &&
                Objects.equals(getTitle(), book4.getTitle());
    }
//    public boolean equals (Book4 book4){
//        boolean result;
//        result = this.getTitle().equals(book4.getTitle()) && this.getAuthor().equals(book4.getAuthor());
//        return result;
//    }

    @Override
    public int hashCode() {

        return Objects.hash(getAuthor(), getTitle());
    }
}
