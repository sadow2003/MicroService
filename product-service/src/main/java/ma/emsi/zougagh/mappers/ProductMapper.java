package ma.emsi.zougagh.mappers;


import ma.emsi.zougagh.dtos.ProductDto;
import ma.emsi.zougagh.entites.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(ProductDto userDto);
    ProductDto toDto(ProductEntity userEntity);
}
