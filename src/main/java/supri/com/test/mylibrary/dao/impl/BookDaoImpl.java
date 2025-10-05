package supri.com.test.mylibrary.dao.impl;

import java.util.List;

import supri.com.test.mylibrary.dao.BookDao;
import supri.com.test.mylibrary.model.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveBook(Book book) {
		// Use merge, consistent with the original implementation, to handle detached entities
		sessionFactory.getCurrentSession().merge(book);
	}

	@Override
	public List<Book> listBooks() {
		// Use a type-safe HQL query, which is the recommended approach over the deprecated Criteria API
		return sessionFactory.getCurrentSession().createQuery("from Book", Book.class).getResultList();
	}

	@Override
	public Book getBook(Long id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public void deleteBook(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.get(Book.class, id);
		if (book != null) {
			session.delete(book);
		}
	}
}