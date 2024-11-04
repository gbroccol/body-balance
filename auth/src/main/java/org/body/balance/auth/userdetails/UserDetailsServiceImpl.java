package org.body.balance.auth.userdetails;

import lombok.AllArgsConstructor;
import org.body.balance.auth.domain.AuthUser;
import org.body.balance.auth.repository.AuthUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AuthUser authUser = authUserRepository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException(username));
        return new UserDetailsImpl(authUser);
    }
}