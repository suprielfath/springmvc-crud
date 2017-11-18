package supri.com.test.mylibrary.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import supri.com.test.mylibrary.model.Book;
import supri.com.test.mylibrary.service.BookService;
import supri.com.test.mylibrary.util.TypeOfBooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = { "/", "/listBooks" })
	public String listBooks(Map<String, Object> map) {
		
		List<TypeOfBooks> typeBookList = new ArrayList<TypeOfBooks>( Arrays.asList(TypeOfBooks.values() ));

		map.put("typeBookList", typeBookList);
		map.put("book", new Book());
		map.put("bookList", bookService.listBooks());

		return "/book/listBooks";
	}

	@RequestMapping("/get/{bookId}")
	public String getBook(@PathVariable Long bookId, Map<String, Object> map) {

		Book book = bookService.getBook(bookId);
		List<TypeOfBooks> typeBookList = new ArrayList<TypeOfBooks>( Arrays.asList(TypeOfBooks.values() ));

//		model.addAttribute("stateList", stateList);
		map.put("typeBookList", typeBookList);
		map.put("book", book);

		return "/book/bookForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book,
			BindingResult result) {

		bookService.saveBook(book);

		return "redirect:listBooks";
	}

	@RequestMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Long id) {

		bookService.deleteBook(id);

		return "redirect:/book/listBooks";
	}
}
