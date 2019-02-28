import org.junit.jupiter.api.Test;
import solution1map.BookDAO;
import solution2list.BookDAO2;
import solution3map.BookDAO3;

import java.sql.SQLOutput;

public class BookTest {
    @Test
    public void solution1test(){
        BookDAO bookDAO = new BookDAO();
        System.out.println("test 1");
        bookDAO.print();
    }
    @Test
    public void solution2test(){
        BookDAO bookDAO = new BookDAO();
        System.out.println("test 2");
        bookDAO.print();
    }
    @Test
    public void solution3test (){
        BookDAO3 bookDAO3 = new BookDAO3();
        System.out.println("test 3");
        bookDAO3.printBooks();
    }
    @Test
    public void test(){
        BookDAO3 bookDAO3 = new BookDAO3();
        bookDAO3.initializeStringList().iterator().forEachRemaining(a-> System.out.println(a));
    }
}
