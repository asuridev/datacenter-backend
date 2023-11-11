package co.com.freesoft.datacenter.user.services;

import co.com.freesoft.datacenter.user.services.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserServiceRepository userServiceRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userServiceRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Not Found"));

        String[] roles = new String [user.getRoles().size()];
        List<String> rolesAsString = user.getRoles().stream()
                .map(role-> role.getRole()).collect(Collectors.toList());
        rolesAsString.toArray(roles);

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .accountLocked(user.getLocked())
                .disabled(user.getDisabled())
                .roles(roles)
                .build();

    }
}

  