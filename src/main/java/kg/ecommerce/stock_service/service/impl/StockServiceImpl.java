package kg.ecommerce.stock_service.service.impl;

import kg.ecommerce.stock_service.mapper.StockMapper;
import kg.ecommerce.stock_service.models.dto.StockDto;
import kg.ecommerce.stock_service.models.entity.Stock;
import kg.ecommerce.stock_service.repository.ElasticSearchQuery;
import kg.ecommerce.stock_service.repository.StockRepository;
import kg.ecommerce.stock_service.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockServiceImpl implements StockService {

  private final StockRepository stockRepository;

  private final StockMapper stockMapper;

  private final ElasticSearchQuery elasticSearchQuery;

  @Override
  public void saveStocks(StockDto stockDtos) {
    Stock a = stockMapper.mapStockDtoToModel(stockDtos);
      stockRepository.saveAndFlush(a);
      try {
          elasticSearchQuery.createOrUpdateDocument(stockMapper.mapStockToElasticStock(a));
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
  }

    @Override
    public List<StockDto> getStocks() {
        return stockMapper.mapStocksToStockDtos(stockRepository.findAll());
    }

    @Override
    public StockDto getStock(Long id) {
        return stockMapper.mapStockToStockDto(stockRepository.findById(id).get());
    }

    @Override
    public boolean delete(Long id) {
        stockRepository.deleteById(id);
        try {
            elasticSearchQuery.deleteDocumentById(String.valueOf(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    Stock findStockBySkuAndRegion(String sku, String region){
    return stockRepository.findStockBySkuAndRegion(sku, region);
  }


}
