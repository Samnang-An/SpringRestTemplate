package webshop.database.service;

<<<<<<< Updated upstream
import webshop.controller.dto.ProductDto;
=======
import webshop.database.service.dto.ProductDto;
import webshop.database.exception.NoProductFoundException;
>>>>>>> Stashed changes

public interface ProductService {

  ProductDto addProduct(ProductDto productDto);
  ProductDto getProduct(long id);
  ProductDto getProduct(String name);

}
