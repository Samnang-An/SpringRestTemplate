package webshop.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< Updated upstream
import webshop.database.entity.DatabaseSequence;
import webshop.controller.dto.ProductDto;
import webshop.database.entity.ProductDAO;
import webshop.database.entity.StockDAO;
import webshop.database.entity.SupplierDAO;
=======
import webshop.database.service.dto.ProductDto;
import webshop.database.exception.NoProductFoundException;
>>>>>>> Stashed changes
import webshop.database.repository.ProductRepository;
import webshop.database.service.AddNewProductService;
import webshop.database.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private AddNewProductService addNewProductService;

  @Override
  public ProductDto addProduct(ProductDto productDto) {
    return addNewProductService.proceed(productDto);
  }


  @Override
  public ProductDto getProduct(long id) {
    return ProductDto.of(productRepository.findById(id).get());
  }

  @Override
  public ProductDto getProduct(String name) {
    return ProductDto.of(productRepository.findByProdName(name));
  }
}

