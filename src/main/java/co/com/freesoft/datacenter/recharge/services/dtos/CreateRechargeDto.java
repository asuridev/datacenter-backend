package co.com.freesoft.datacenter.recharge.services.dtos;

import co.com.freesoft.datacenter.operator.persistence.entities.OperatorEntity;
import co.com.freesoft.datacenter.operator.services.dtos.CreateOperatorDto;
import co.com.freesoft.datacenter.user.persistence.entities.UserEntity;
import co.com.freesoft.datacenter.user.services.dtos.CreateUserDto;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRechargeDto {

    private BigDecimal value;

    private Long telephone;

    private CreateUserDto user;


    private CreateOperatorDto operator;
     
}

  