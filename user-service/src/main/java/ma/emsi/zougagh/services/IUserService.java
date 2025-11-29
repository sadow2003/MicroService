package ma.emsi.zougagh.services;

import ma.emsi.zougagh.dtos.UserDto;
import java.util.List;
public interface IUserService {
    UserDto addUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long id);
    List<UserDto> selectUsers();
}
