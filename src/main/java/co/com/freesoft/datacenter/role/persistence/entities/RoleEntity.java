package co.com.freesoft.datacenter.role.persistence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="roles")
@Entity
public class RoleEntity  {

    
    @Id
    private String id;

}

  