package web;

import java.util.Objects;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import web.dto.CustomerDto;
import web.dto.ProductDto;
import web.dto.ShoppingCartDto;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {

  @Autowired
  private RestOperations restTemplate;

  public static void main(String[] args) {
    SpringApplication.run(RestClientApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    String productServerUrl = "http://localhost:8080/product/";
    String customerServerUrl = "http://localhost:8080/customer/";
    String cartServerUrl = "http://localhost:8080/cart/";

    //Add new product
    int num = new Random().nextInt(90);
    ProductDto newProduct = ProductDto.createNewProduct(num + "Blue Diamond Almond",
        num + "Honey Roasted Almond", 13.4, 100, "California", "12-0933", "Invisible");
    ResponseEntity<ProductDto> productDtoResponseEntity = restTemplate.postForEntity(
        productServerUrl + "add-product", newProduct, ProductDto.class);
    System.out.println("=====add-product");
    System.out.println(productDtoResponseEntity.getStatusCode());
    System.out.println(productDtoResponseEntity.getBody());

    //get product
    productDtoResponseEntity = restTemplate.getForEntity(productServerUrl + "{id}",
        ProductDto.class, productDtoResponseEntity.getBody().getProdNum());
    ProductDto productDto = productDtoResponseEntity.getBody();
    System.out.println("====get-product=====");
    System.out.println(productDtoResponseEntity.getStatusCode());
    System.out.println(productDto);

    //create customer
    ResponseEntity<?> customerResponse = restTemplate.getForEntity(
        customerServerUrl + "{id}", CustomerDto.class, 1);
    CustomerDto customerDto;
    if (Objects.isNull(customerResponse.getBody())) {
      CustomerDto customer = CustomerDto.builder().customerName("Samnang").build();
      ResponseEntity<?> customerDtoResponseEntity = restTemplate.postForEntity(
          customerServerUrl + "create-new", customer, CustomerDto.class);
      System.out.println("=====create-customer");
      System.out.println(customerDtoResponseEntity.getStatusCode());
      System.out.println(customerDtoResponseEntity.getBody());
      customerDto = (CustomerDto) customerDtoResponseEntity.getBody();
    } else {
      customerDto = (CustomerDto) customerResponse.getBody();
    }

    //add product to cart
    ResponseEntity<?> cartResponse = restTemplate.postForEntity(
        cartServerUrl + "add/{cusId}/{productId}/{amount}", "", String.class,
        customerDto.getId(), productDto.getProdNum(), 3);
    System.out.println("=====add-to-cart");
    System.out.println(cartResponse.getStatusCode());
    System.out.println(cartResponse.getBody());

    //get Shopping Cart
    ResponseEntity<?> cartDtoResponseEntity = restTemplate.getForEntity(
        cartServerUrl + "{cusId}", ShoppingCartDto.class, customerDto.getId());
    System.out.println("=====get Shopping Cart of a customer");
    System.out.println(cartDtoResponseEntity.getStatusCode());
    System.out.println(cartDtoResponseEntity.getBody());

  }


  @Bean
  RestOperations restTemplate() {
    return new RestTemplate();
  }
}
