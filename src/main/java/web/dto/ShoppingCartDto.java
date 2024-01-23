package web.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {

  private long id;
  private CustomerDto customer;
  private List<ProductItemDto> productItem;

  @Override
  public String toString() {
    String str = "ShoppingCart: customer:" + customer.getCustomerName() + ";" + productItem.size()
        + " items \n";
    for (ProductItemDto item :
        productItem) {
      str = str + "{" + item.getProduct().getProdName() + " ; amount=" + item.getAmount() + "}\n";
    }
    return str;
  }

}
