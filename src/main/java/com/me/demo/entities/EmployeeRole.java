package com.me.demo.entities;

import org.springframework.security.core.GrantedAuthority;

public enum EmployeeRole implements GrantedAuthority {
    CASHIER,
    WAREHOUSE_MANAGER,
    STORE_OWNER;

    public String getAuthority() {
        return name();
    }
}
