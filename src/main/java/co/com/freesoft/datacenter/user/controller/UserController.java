package co.com.freesoft.datacenter.user.controller;

import co.com.freesoft.datacenter.user.services.UserService;
import co.com.freesoft.datacenter.user.services.dtos.CreateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.ResponseLoginDto;
import co.com.freesoft.datacenter.user.services.dtos.UpdateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.ResponseUserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/login")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseLoginDto login(@RequestHeader(HttpHeaders.AUTHORIZATION) String header){
        return this.userService.login(header);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUserDto create(@Valid @RequestBody CreateUserDto createUserDto){
       return  this.userService.create(createUserDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<ResponseUserDto> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "100") int limit,
            @RequestParam(required = false,defaultValue = "id") String sortBy
    ){
        return this.userService.findAll(page, limit, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseUserDto findOne(@PathVariable("id") Long id){
        return this.userService.findOne(id);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseUserDto update(@Valid @RequestBody UpdateUserDto updateUserDto, @PathVariable("id") Long id){
        return this.userService.update(updateUserDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id){
        this.userService.remove(id);
    }

}

  