package co.com.freesoft.datacenter.recharge.services.dtos;

import co.com.freesoft.datacenter.operator.services.dtos.CreateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.ResponseOperatorDto;
import co.com.freesoft.datacenter.user.services.dtos.CreateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.ResponseUserDto;
import co.com.freesoft.datacenter.user.services.dtos.UserDto;
import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseRechargeDto {
    private Long id;

    private BigDecimal value;

    private Long telephone;

    private ResponseUserDto user;


    private ResponseOperatorDto operator;
     
}

  