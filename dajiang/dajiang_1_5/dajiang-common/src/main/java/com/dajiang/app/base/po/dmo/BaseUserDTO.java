package com.dajiang.app.base.po.dmo;

/**
 * Created by Joe on 2017/9/18.
 */
public class BaseUserDTO extends BaseDTO {

    private LoginDTO loginDTO;

    private RoleDTO roleDTO;

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }
}
