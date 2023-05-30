package kg.ecommerce.stock_service.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "stocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "sku", nullable = false)
  private String sku;

  @Column(name = "region", nullable = false)
  private String region;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @CreationTimestamp
  @Column(name = "created_date", updatable = false, nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime createdDate;

  @UpdateTimestamp
  @Column(name = "last_modified_date", nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime lastModifiedDate;
}
