package com.dajiang.app.base.po.dmo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserDetailsDTO extends User {

    private BaseUserDTO baseUserDTO;

    public UserDetailsDTO(BaseUserDTO aepBaseUserDTO, Collection<? extends GrantedAuthority> authorities) {
        super(aepBaseUserDTO.getLoginDTO().getLoginName(), aepBaseUserDTO.getLoginDTO().getLoginPasswd(), authorities);
        this.baseUserDTO = aepBaseUserDTO;
    }

    public BaseUserDTO getBaseUserDTO() {
        return baseUserDTO;
    }

    public void setBaseUserDTO(BaseUserDTO baseUserDTO) {
        this.baseUserDTO = baseUserDTO;
    }
}
