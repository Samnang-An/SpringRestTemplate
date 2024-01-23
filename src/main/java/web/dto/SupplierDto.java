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
public class SupplierDto {

  private int supplierNum;
  private String supplierName;

  public static SupplierDto createNewSupplier(String supplierName) {
    return SupplierDto.builder()
        .supplierName(supplierName)
        .build();
  }
}
