package kg.ecommerce.stock_service.repository;

import kg.ecommerce.stock_service.models.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

  @Modifying
  @Query(
          "update Stock s set s.quantity = :quantity, s.lastModifiedDate = :lastModified where s.sku = :sku " +
                  "and s.region = :region and s.lastModifiedDate < :lastModifiedDate")
  void saveUpdatedStocks(@Param("quantity") Integer quantity,
                         @Param("lastModifiedDate") LocalDateTime lastModifiedDate,
                         @Param("sku") String sku, @Param("region") String region);

  Stock findStockBySkuAndRegion(String sku, String region);
}
