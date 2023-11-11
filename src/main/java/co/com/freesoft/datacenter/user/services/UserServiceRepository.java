package co.com.freesoft.datacenter.user.services;

import co.com.freesoft.datacenter.user.services.dtos.CreateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.UpdateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.UserDto;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface UserServiceRepository {

    public UserDto createUser(CreateUserDto createUserDto);

    public Page<UserDto> findAllUsers(int page, int limit, String sortBy);

    public Optional<UserDto> findOneUser(Long id);

    public Optional<UserDto> findByUsername(String email);

    public Optional<UserDto> updateUser(UpdateUserDto updateUserDto, Long id);

    public void removeUser(Long id);
}

  