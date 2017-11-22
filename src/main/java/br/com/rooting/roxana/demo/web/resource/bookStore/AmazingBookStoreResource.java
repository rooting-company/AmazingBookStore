package br.com.rooting.roxana.demo.web.resource.bookStore;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rooting.roxana.demo.web.resource.BaseResource;
import io.swagger.annotations.Api;

@Transactional
@RestController
@RequestMapping(path = "/api/book-store")
@Api(tags = "The Amazing Book Store Resources")
public class AmazingBookStoreResource extends BaseResource {

	// in progress ...
}
