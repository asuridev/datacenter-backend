package co.com.freesoft.datacenter.operator.controller;

import co.com.freesoft.datacenter.operator.services.OperatorService;
import co.com.freesoft.datacenter.operator.services.dtos.CreateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.UpdateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.ResponseOperatorDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("operator")
public class OperatorController {

    private final OperatorService operatorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseOperatorDto create(@Valid @RequestBody CreateOperatorDto createOperatorDto){
       return  this.operatorService.create(createOperatorDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<ResponseOperatorDto> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "100") int limit,
            @RequestParam(required = false,defaultValue = "id") String sortBy
    ){
        return this.operatorService.findAll(page, limit, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseOperatorDto findOne(@PathVariable("id") Long id){
        return this.operatorService.findOne(id);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseOperatorDto update(@Valid @RequestBody UpdateOperatorDto updateOperatorDto, @PathVariable("id") Long id){
        return this.operatorService.update(updateOperatorDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id){
        this.operatorService.remove(id);
    }

}

  