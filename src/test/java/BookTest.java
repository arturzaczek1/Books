import org.junit.jupiter.api.Test;
import solution1map.BookDAO;
import solution2list.BookDAO2;
import solution3map.BookDAO3;
import solution4set.BookDAO4;


public class BookTest {
    @Test
    public void solution1test() {
        BookDAO bookDAO = new BookDAO();
        System.out.println("test solution 1:");
        bookDAO.print();
    }

    @Test
    public void solution2test() {
        BookDAO2 bookDAO = new BookDAO2();
        System.out.println("test solution 2:");
        bookDAO.print();
    }

    @Test
    public void solution3test() {
        BookDAO3 bookDAO3 = new BookDAO3();
        System.out.println("test solution 3:");
        bookDAO3.printBooks();
    }

    @Test
    public void solution4test() {
        BookDAO4 bookDAO4 = new BookDAO4();
        System.out.println("test solution 4:");
        bookDAO4.print();
    }
}
