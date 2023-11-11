package co.com.freesoft.datacenter.recharge.controller;

import co.com.freesoft.datacenter.recharge.services.RechargeService;
import co.com.freesoft.datacenter.recharge.services.dtos.CreateRechargeDto;
import co.com.freesoft.datacenter.recharge.services.dtos.UpdateRechargeDto;
import co.com.freesoft.datacenter.recharge.services.dtos.ResponseRechargeDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("recharge")
public class RechargeController {

    private final RechargeService rechargeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseRechargeDto create(@Valid @RequestBody CreateRechargeDto createRechargeDto){
       return  this.rechargeService.create(createRechargeDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<ResponseRechargeDto> findAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false,defaultValue = "100") int limit,
            @RequestParam(required = false,defaultValue = "id") String sortBy
    ){
        return this.rechargeService.findAll(page, limit, sortBy);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseRechargeDto findOne(@PathVariable("id") Long id){
        return this.rechargeService.findOne(id);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public ResponseRechargeDto update(@Valid @RequestBody UpdateRechargeDto updateRechargeDto, @PathVariable("id") Long id){
        return this.rechargeService.update(updateRechargeDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id){
        this.rechargeService.remove(id);
    }

}

  