package edu.miu.springdata1Assignment.seciruty;


import edu.miu.springdata1Assignment.entity.User;
import edu.miu.springdata1Assignment.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userDetailsService")
@Transactional
@RequiredArgsConstructor
public class SystemUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        var userDetails = new SystemUserDetails(user);
        return userDetails;
    }
}
