package es.hedasoft.cxfspringboot.restws.services;

import es.hedasoft.cxfspringboot.restws.model.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/book")
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
public interface IBookService {

    @Path("/")
    @GET
    public List<Book> getAllBooks();

    @Path("/{id}")
    @GET
    Book getBook(@PathParam(value = "id") Integer id);

    @Path("/")
    @POST
    Response createPBook(Book book);

    @Path("/")
    @PUT
    Response updateBook(Book book);

    @Path("/{id}")
    @DELETE
    Response deleteBook(@PathParam(value = "id") Integer id);
}
