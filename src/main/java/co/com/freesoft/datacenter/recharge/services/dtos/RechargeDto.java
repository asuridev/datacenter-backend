package co.com.freesoft.datacenter.recharge.services.dtos;

import co.com.freesoft.datacenter.operator.services.dtos.OperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.ResponseOperatorDto;
import co.com.freesoft.datacenter.user.services.dtos.ResponseUserDto;
import co.com.freesoft.datacenter.user.services.dtos.UserDto;
import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RechargeDto {
    private Long id;

    private BigDecimal value;

    private Long telephone;

    private UserDto user;


    private OperatorDto operator;


}

  