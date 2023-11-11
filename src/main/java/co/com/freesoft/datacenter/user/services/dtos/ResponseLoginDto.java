package co.com.freesoft.datacenter.user.services.dtos;

import co.com.freesoft.datacenter.role.services.dtos.CreateRoleDto;
import co.com.freesoft.datacenter.role.services.dtos.RoleDto;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseLoginDto {
  private Long id;

  private String username;

  private Boolean locked;

  private Boolean disabled;
  private String name;

  private String lastName;

  private List<RoleDto> roles;

  private String token;


}

  