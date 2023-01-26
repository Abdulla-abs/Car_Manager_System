package com.example.spingboot.utils;

import com.example.spingboot.domain.dto.MasterDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/4/5 8:50
 */
public class UserUtil {

        public static MasterDto getUser(){
                MasterDto masterDto = new MasterDto();

                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                if (authentication != null && authentication.getPrincipal() instanceof MasterDto){
                        masterDto = (MasterDto) authentication.getPrincipal();
                }else {
                        masterDto.setAccountId("000000");
                }
                return masterDto;
        }
}
