package ma.emsi.zougagh.mappers;


import ma.emsi.zougagh.dtos.UserDto;
import ma.emsi.zougagh.entites.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDto userDto);
    UserDto toDto(UserEntity userEntity);
}
