package co.com.freesoft.datacenter.user.services;

import co.com.freesoft.datacenter.common.exceptions.NotFoundException;
import co.com.freesoft.datacenter.user.services.dtos.*;
import co.com.freesoft.datacenter.common.exceptions.BadRequestException;
import co.com.freesoft.datacenter.common.exceptions.NotFoundException;
import co.com.freesoft.datacenter.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserServiceRepository userServiceRepository;
    private final ConverterUserDto converterUserDto;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public ResponseLoginDto login(String header){
        if(header == null || !header.startsWith("Basic")) throw new BadRequestException();
        String credentialBase64 = header.split(" ")[1];
        String stringCredential = new String(Base64.getDecoder().decode(credentialBase64));
        String[] credentials = stringCredential.split(":");
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(credentials[0],credentials[1]);
        Authentication authentication = this.authenticationManager.authenticate(login);
        UserDto user = userServiceRepository.findByUsername(credentials[0])
                .orElseThrow(NotFoundException::new);
        ResponseLoginDto userLogin = converterUserDto.toResponseLoginDto(user);
        userLogin.setToken(jwtUtil.create(credentials[0]));
        return userLogin;
    }

    public ResponseUserDto create(CreateUserDto createUserDto){
        createUserDto.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        UserDto user = userServiceRepository.createUser(createUserDto);
        return this.converterUserDto.toResponseUserDto(user);
    }

    public Page<ResponseUserDto> findAll(int page, int limit, String sortBy){
        Page<UserDto> users = userServiceRepository.findAllUsers(page, limit ,sortBy);
        return  users.map(converterUserDto::toResponseUserDto);
    }

    public ResponseUserDto findOne(Long id){
        UserDto user = userServiceRepository.findOneUser(id).orElseThrow(NotFoundException::new);
        return this.converterUserDto.toResponseUserDto(user);
    }

    public ResponseUserDto update(UpdateUserDto updateUserDto, Long id){
        UserDto user = userServiceRepository.updateUser(updateUserDto, id).orElseThrow(NotFoundException::new);
        return this.converterUserDto.toResponseUserDto(user);
    }

    public void remove(Long id){
        this.findOne(id);
        userServiceRepository.removeUser(id);
    }
}

  