package web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {

  private int amount;
  private String warehouse;
  private String locationCode;

  public static StockDto createNewStock(int amount, String warehouse,String locationCode) {
    return StockDto.builder()
        .amount(amount)
        .warehouse(warehouse)
        .locationCode(locationCode)
        .build();
  }

}
