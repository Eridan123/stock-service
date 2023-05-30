package kg.ecommerce.stock_service.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
  private Long id;
  private String sku;
  private String region;
  private Integer quantity;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
}
