package co.com.freesoft.datacenter.recharge.services.dtos;


import co.com.freesoft.datacenter.operator.services.dtos.CreateOperatorDto;
import co.com.freesoft.datacenter.operator.services.dtos.UpdateOperatorDto;
import co.com.freesoft.datacenter.user.services.dtos.CreateUserDto;
import co.com.freesoft.datacenter.user.services.dtos.UpdateUserDto;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateRechargeDto {

    private BigDecimal value;

    private Long telephone;

    private UpdateUserDto user;


    private UpdateOperatorDto operator;

}

  