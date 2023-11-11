package co.com.freesoft.datacenter.recharge.persistence.entities;

import co.com.freesoft.datacenter.common.audit.AuditableEntity;
import co.com.freesoft.datacenter.operator.persistence.entities.OperatorEntity;
import co.com.freesoft.datacenter.user.persistence.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="recharges")
@Entity
public class RechargeEntity extends AuditableEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private BigDecimal value;

    private Long telephone;

    @JoinColumn(name="user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    @JoinColumn(name="operator_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private OperatorEntity operator;
}

  