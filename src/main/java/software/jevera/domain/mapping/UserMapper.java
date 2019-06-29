package software.jevera.domain.mapping;

import org.mapstruct.Mapper;
import software.jevera.domain.User;
import software.jevera.domain.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto userDto);
}
