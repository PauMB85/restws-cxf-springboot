package es.hedasoft.cxfspringboot.restws.services;

import es.hedasoft.cxfspringboot.restws.model.Book;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;

@Service
public class BookServiceImpl implements IBookService {

    Map<Integer,Book> books = new HashMap<>();
    Integer currentId = 0;

    @Override
    public List<Book> getAllBooks() {

        Collection<Book> result = books.values();
        ArrayList<Book> response = new ArrayList<>(result);
        return response;
    }

    @Override
    public Book getBook(Integer id) {
        return books.get(id);
    }

    @Override
    public Response createPBook(Book book) {
        book.setId(++currentId);
        books.put(currentId,book);
        return Response.ok(book).build();
    }

    @Override
    public Response updateBook(Book book) {

        Book currentBook = books.get(book.getId());
        Response response = Response.notModified().build();
        if(currentBook != null) {
            books.put(book.getId(), book);
            response = Response.ok().build();
        }

        return response;
    }

    @Override
    public Response deleteBook(Integer id) {

        Book book = books.get(id);
        Response response = Response.notModified().build();
        if(book != null) {
            books.remove(id);
            response = Response.ok().build();
        }
        return response;
    }
}
