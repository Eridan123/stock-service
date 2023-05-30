package kg.ecommerce.stock_service.mapper;

import kg.ecommerce.stock_service.models.dto.StockDto;
import kg.ecommerce.stock_service.models.elastic.ElasticStock;
import kg.ecommerce.stock_service.models.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StockMapper {

  List<Stock> mapStockDtosToStocks(List<StockDto> dto);

  @Mapping(source = "sku", target = "sku")
  @Mapping(source = "region", target = "region")
  @Mapping(source = "quantity", target = "quantity")
  @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
  @Mapping(source = "createdDate", target = "createdDate")
  StockDto mapStockToStockDto(Stock stock);

  List<StockDto> mapStocksToStockDtos(List<Stock> stocks);

  @Mapping(source = "sku", target = "sku")
  @Mapping(source = "region", target = "region")
  @Mapping(source = "quantity", target = "quantity")
  @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
  @Mapping(source = "createdDate", target = "createdDate")
  Stock mapStockDtoToModel(StockDto stockDto);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "sku", target = "sku")
  @Mapping(source = "region", target = "region")
  @Mapping(source = "quantity", target = "quantity")
  @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
  @Mapping(source = "createdDate", target = "createdDate")
  ElasticStock mapStockToElasticStock(Stock stock);
}
