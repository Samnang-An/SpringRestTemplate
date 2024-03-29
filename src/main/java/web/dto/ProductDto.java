package web.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

@Builder
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

  private long prodNum;
  private String prodName;
  private String description;
  private double price;

  private List<ReviewDto> reviewList = new ArrayList<>();
  private StockDto stock;
  private SupplierDto supplier;

  public static ProductDto createNewProduct(String prodName, String description, double price,
      int amount, String warehouse,
      String locationCode, String supplierName) {
    return ProductDto.builder()
        .prodName(prodName)
        .description(description)
        .price(price)
        .stock(StockDto.createNewStock(amount, warehouse, locationCode))
        .supplier(SupplierDto.createNewSupplier(supplierName))
        .build();
  }

  @Override
  @SneakyThrows
  public String toString() {
    ObjectMapper objectMapper = new ObjectMapper();
    return "Product Items: {" + objectMapper.writeValueAsString(this) + "}";
  }
}
