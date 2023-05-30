package kg.ecommerce.stock_service.controller;

import kg.ecommerce.stock_service.models.dto.StockDto;
import kg.ecommerce.stock_service.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
@RequiredArgsConstructor
public class StockController {

  private final StockService stockService;

  @GetMapping()
  public List<StockDto> list(){
    return stockService.getStocks();
  }

  @GetMapping("/{id}")
  public StockDto getStock(@PathVariable Long id){
    return stockService.getStock(id);
  }

  @PutMapping
  public void saveStocks(@RequestBody StockDto stockDtos){
    stockService.saveStocks(stockDtos);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable Long id){
    stockService.delete(id);
    return ResponseEntity.ok(true);
  }
}
