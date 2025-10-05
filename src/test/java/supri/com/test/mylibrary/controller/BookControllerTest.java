package supri.com.test.mylibrary.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import supri.com.test.mylibrary.model.Book;
import supri.com.test.mylibrary.service.BookService;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.afterPropertiesSet();

        // Set up a view resolver to prevent the circular path error in standalone tests
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .setValidator(validator)
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    void listBooks_shouldReturnListView() throws Exception {
        when(bookService.listBooks()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/book/listBooks"))
                .andExpect(status().isOk())
                .andExpect(view().name("/book/listBooks"))
                .andExpect(model().attributeExists("book", "bookList", "typeBookList"));
    }

    @Test
    void getBook_shouldReturnBookForm() throws Exception {
        Book book = new Book();
        book.setId(1L);
        when(bookService.getBook(1L)).thenReturn(book);

        mockMvc.perform(get("/book/get/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("/book/bookForm"))
                .andExpect(model().attribute("book", book));
    }

    @Test
    void saveBook_whenValid_shouldRedirect() throws Exception {
        mockMvc.perform(post("/book/save")
                        .param("title", "Valid Title")
                        .param("authors", "Valid Authors"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("/book/listBooks*"));
    }

    @Test
    void saveBook_whenInvalid_shouldReturnForm() throws Exception {
        mockMvc.perform(post("/book/save")
                        .param("title", "") // Invalid
                        .param("authors", "")) // Invalid
                .andExpect(status().isOk())
                .andExpect(view().name("/book/bookForm"))
                .andExpect(model().attributeHasFieldErrors("book", "title", "authors"));
    }

    @Test
    void deleteBook_shouldRedirect() throws Exception {
        mockMvc.perform(get("/book/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("/book/listBooks*"));
    }
}