package com.projecttest.crud.web.mappers;

import com.projecttest.crud.entities.UserEntity;
import com.projecttest.crud.web.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper  extends IMapper<UserDTO, UserEntity>{
}
