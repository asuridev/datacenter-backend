package co.com.freesoft.datacenter.user.services.dtos;

import co.com.freesoft.datacenter.role.services.dtos.UpdateRoleDto;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserDto {

  private String username;

  private String password;

  private Boolean locked;

  private Boolean disabled;

  private String name;

  private String lastName;

  private List<UpdateRoleDto> roles;

}

  