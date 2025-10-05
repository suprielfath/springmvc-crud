package supri.com.test.mylibrary.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import supri.com.test.mylibrary.model.Book;
import supri.com.test.mylibrary.service.BookService;
import supri.com.test.mylibrary.util.TypeOfBooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@ModelAttribute("typeBookList")
    public List<TypeOfBooks> populateTypeOfBooks() {
        return Arrays.asList(TypeOfBooks.values());
    }

	@RequestMapping(value = { "/", "/listBooks" })
	public String listBooks(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("bookList", bookService.listBooks());
		return "/book/listBooks";
	}

	@RequestMapping("/get/{bookId}")
	public String getBook(@PathVariable Long bookId, Model model) {
		Book book = bookService.getBook(bookId);
		model.addAttribute("book", book);
		return "/book/bookForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// If there are validation errors, return to the form view
			return "/book/bookForm";
		}

		bookService.saveBook(book);
		return "redirect:/book/listBooks";
	}

	@RequestMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Long id) {
		bookService.deleteBook(id);
		return "redirect:/book/listBooks";
	}
}