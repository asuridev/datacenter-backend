package co.com.freesoft.datacenter.user.services.dtos;

import co.com.freesoft.datacenter.role.services.dtos.CreateRoleDto;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {
  private Long id;

  private String username;

  private String password;

  @Builder.Default
  private Boolean locked = false;

  @Builder.Default
  private Boolean disabled = false;

  private String name;

  private String lastName;

  private List<CreateRoleDto> roles;
     
}

  