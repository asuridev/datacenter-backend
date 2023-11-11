package co.com.freesoft.datacenter.user.persistence;

import co.com.freesoft.datacenter.user.persistence.entities.UserEntity;
import co.com.freesoft.datacenter.user.persistence.mappers.UserMapper;
import co.com.freesoft.datacenter.user.persistence.repositories.UserCrudRepository;
import co.com.freesoft.datacenter.user.persistence.repositories.UserPaginationRepository;
import co.com.freesoft.datacenter.user.services.UserServiceRepository;
import co.com.freesoft.datacenter.user.services.dtos.CreateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.UpdateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserServiceRepository {

    private final UserCrudRepository userCrudRepository;
    private final UserPaginationRepository userPaginationRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        UserEntity newUser = this.userMapper.toUserEntity(createUserDto);
        UserEntity responseQuery = this.userCrudRepository.save(newUser);
        return userMapper.toUserDto(responseQuery);
    }

    @Override
    public Page<UserDto> findAllUsers(int page, int limit, String sortBy) {
        Pageable pageRequest = PageRequest.of(page, limit, Sort.by(sortBy));
        return this.userPaginationRepository.findAll(pageRequest).map(this.userMapper::toUserDto);
    }

    @Override
    public Optional<UserDto> findOneUser(Long id) {
        return this.userCrudRepository.findById(id).map(this.userMapper::toUserDto);
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return  this.userCrudRepository.findFirstByUsername(username).map(this.userMapper::toUserDto);
    }

    @Override
    public Optional<UserDto> updateUser(UpdateUserDto updateUserDto, Long id) {
        UserEntity userEntityById = this.userCrudRepository.findById(id).orElse(null);
        if(userEntityById == null) return Optional.empty();;
        UserEntity userEntityUpdate = this.userMapper.merge(updateUserDto, userEntityById);
        UserEntity responseQuery = this.userCrudRepository.save(userEntityUpdate);
        return Optional.of(userMapper.toUserDto(responseQuery));
    }

    @Override
    public void removeUser(Long id) {
        this.userCrudRepository.deleteById(id);
    }
}

  