package com.example.spingboot.service.impl;

import com.example.spingboot.common.enums.ResultStatusEnum;
import com.example.spingboot.dao.MasterMapper;
import com.example.spingboot.domain.dto.MasterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/5/13 20:25
 */
@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {

        @Autowired
        MasterMapper masterMapper;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                MasterDto masterDto = null;

                try {
                        masterDto = masterMapper.selectByPrimaryKey(username);
                } catch (Exception e) {
                        throw new UsernameNotFoundException(ResultStatusEnum.ERROR.getDescription());
                }

                if (masterDto == null){
                        throw new UsernameNotFoundException(ResultStatusEnum.USER_NOT_EXIST.getDescription());
                }

                return masterDto;
        }
}
