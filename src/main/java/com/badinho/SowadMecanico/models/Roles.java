package com.badinho.SowadMecanico.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "roles")
@Table(name = "roles")
public class Roles implements Serializable {

    private int roleID;
    private String role_name;

    @Id
    @Column(name = "roleID")
    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Column(name = "role_name")
    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
