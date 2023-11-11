package co.com.freesoft.datacenter.operator.persistence.entities;


import co.com.freesoft.datacenter.recharge.persistence.entities.RechargeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="operators")
@Entity
public class OperatorEntity  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

}

  