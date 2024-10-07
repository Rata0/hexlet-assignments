package exercise.mapper;

import org.mapstruct.*;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.dto.ProductDTO;

import exercise.model.Product;

// BEGIN
@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ProductMapper {
    @Mapping(target = "name", source = "title")
    @Mapping(target = "barcode", source = "vendorCode")
    @Mapping(target = "cost", source = "price")
    public abstract Product map(ProductCreateDTO dto);

    @Mapping(target = "title", source = "name")
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "vendorCode", source = "barcode")
    public abstract ProductDTO map(Product product);

    @Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO postData, @MappingTarget Product product);
}
// END
