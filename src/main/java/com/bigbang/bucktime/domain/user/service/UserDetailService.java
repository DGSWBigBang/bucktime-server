package com.bigbang.bucktime.domain.user.service;

import com.bigbang.bucktime.domain.user.dao.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userMail) throws UsernameNotFoundException {
        return userMapper.findByUserMail(userMail);
    }
}
