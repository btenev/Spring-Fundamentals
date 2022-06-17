package soft.uni.mobilelele.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import soft.uni.mobilelele.models.dto.UserRegisterDTO;
import soft.uni.mobilelele.models.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO userRegisterDTO);
}
