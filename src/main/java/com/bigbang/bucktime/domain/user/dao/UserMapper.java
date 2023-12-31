package com.bigbang.bucktime.domain.user.dao;

import com.bigbang.bucktime.domain.user.dto.entity.UserEntity;
import com.bigbang.bucktime.domain.user.dto.request.ModifyUserRequest;
import com.bigbang.bucktime.domain.user.dto.request.SignupRequest;
import com.bigbang.bucktime.domain.user.dto.response.ShowUserResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    void insertUser(SignupRequest signupRequest);

    UserEntity findByUserMail(String userMail);

    void deleteByUserMail(String userMail);

    void modifyUser(ModifyUserRequest modifyUserRequest);

    ShowUserResponse showUser(String userMail);

    Integer countUserByPhoneNumber(String phoneNumber);

    Integer countUserByUserMail(String userMail);
}
