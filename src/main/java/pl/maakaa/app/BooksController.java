package pl.maakaa.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Books controller
 */
@RestController
@Api(value="/books", produces ="application/json")
@RequestMapping("/books")
public class BooksController {

    @ApiOperation(value="get books",response= Book.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Book details retrieved",response= Book.class),
            @ApiResponse(code=500,message="Internal server error"),
            @ApiResponse(code=404,message="Book not found")
    })
    @RequestMapping(value="/get", method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<Book> getBooks(){
        Book book = new Book();
        book.setId(1234);
        book.setTitle("L'automne à Pékin");
        book.setAuthor("Boris Vian");
        book.setPublisher("Czarne");
        book.setYear("1946");
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
