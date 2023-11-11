package co.com.freesoft.datacenter.user.persistence.entities;

import co.com.freesoft.datacenter.common.audit.AuditableEntity;
import co.com.freesoft.datacenter.recharge.persistence.entities.RechargeEntity;
import co.com.freesoft.datacenter.role.persistence.entities.RoleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@EntityListeners({AuditingEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Entity
public class UserEntity extends AuditableEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private Boolean locked;

    private Boolean disabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id",nullable = false,referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id",nullable = false, referencedColumnName = "id")
    )
    private List<RoleEntity> roles;

}

  