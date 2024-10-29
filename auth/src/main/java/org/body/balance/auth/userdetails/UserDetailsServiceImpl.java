package org.body.balance.auth.userdetails;

import org.body.balance.auth.domain.AuthUser;
import org.body.balance.auth.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AuthUser authUser = authUserRepository.findByUsername(username);
        if (authUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsImpl(authUser);
    }
}