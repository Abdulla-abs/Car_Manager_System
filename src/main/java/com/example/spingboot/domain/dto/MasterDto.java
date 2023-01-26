package com.example.spingboot.domain.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author abbas
 * @description: TODO
 * @date 2022/3/15 8:24
 */

@Data
public class MasterDto implements Serializable, UserDetails {

        private String accountId;

        private String accountName;

        private String accountType;

        private String accountPassword;

        private String vendorId;

        private String vendorName;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
        }

        @Override
        public String getPassword() {
                return accountPassword;
        }

        @Override
        public String getUsername() {
                return accountName;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}
