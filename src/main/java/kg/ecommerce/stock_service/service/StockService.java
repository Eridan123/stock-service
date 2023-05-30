package kg.ecommerce.stock_service.service;

import kg.ecommerce.stock_service.models.dto.StockDto;
import kg.ecommerce.stock_service.models.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StockService {
  void saveStocks(StockDto stockDtos);

    List<StockDto> getStocks();
    StockDto getStock(Long id);

    boolean delete(Long id);
}
