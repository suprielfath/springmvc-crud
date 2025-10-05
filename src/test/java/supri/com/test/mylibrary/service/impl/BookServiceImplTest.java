package supri.com.test.mylibrary.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import supri.com.test.mylibrary.dao.BookDao;
import supri.com.test.mylibrary.model.Book;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookDao bookDao;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void saveBook_shouldDelegateToDao() {
        Book book = new Book();
        bookService.saveBook(book);
        verify(bookDao).saveBook(book);
    }

    @Test
    void listBooks_shouldDelegateToDao() {
        bookService.listBooks();
        verify(bookDao).listBooks();
    }

    @Test
    void getBook_shouldDelegateToDao() {
        bookService.getBook(1L);
        verify(bookDao).getBook(1L);
    }

    @Test
    void deleteBook_shouldDelegateToDao() {
        bookService.deleteBook(1L);
        verify(bookDao).deleteBook(1L);
    }
}