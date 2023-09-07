package com.bigbang.bucktime.domain.user.dao;

import com.bigbang.bucktime.domain.user.dto.SignupRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    void signup(SignupRequest signupRequest);
}
