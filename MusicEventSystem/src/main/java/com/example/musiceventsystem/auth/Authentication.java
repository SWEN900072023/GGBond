package com.example.musiceventsystem.auth;

import com.example.musiceventsystem.datasource.AdminMapper;
import com.example.musiceventsystem.datasource.CustomerMapper;
import com.example.musiceventsystem.datasource.PlannerMapper;

public class Authentication {
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_PLANNER = "planner";
    public static final String ROLE_CUSTOMER = "customer";
    public static final String ROLE_ERROR = "error";
    public static final String ROLE_UNKNOWN = "unknown";

    private int roleId = -1;
    private final AdminMapper adminMapper;
    private final CustomerMapper customerMapper;
    private final PlannerMapper plannerMapper;

    public Authentication() {
        this.adminMapper = new AdminMapper();
        this.customerMapper = new CustomerMapper();
        this.plannerMapper = new PlannerMapper();
    }

    public int setRoleType(String userType, String Username, String Password) {
        int result = -1; // default setting -1（unknown）

        if (userType.equals(ROLE_ADMIN)) {
            result = adminMapper.isLoginValid(Username, Password);
        } else if (userType.equals(ROLE_PLANNER)) {
            result = plannerMapper.isLoginValid(Username, Password);
        } else if (userType.equals(ROLE_CUSTOMER)) {
            result = customerMapper.isLoginValid(Username, Password);
        }

        if (result > 0) {
            roleId = getUserRoleId(userType); // get user type
            return result;
        } else if (result == 0) {
            roleId = -2; // wrong password
            return 0;
        } else {
            roleId = -1; // unknown user
            return 0;
        }
    }

    private int getUserRoleId(String userType) {
        switch (userType) {
            case ROLE_ADMIN:
                return 1;
            case ROLE_PLANNER:
                return 2;
            case ROLE_CUSTOMER:
                return 3;
            default:
                return -1;
        }
    }

    public String getRoleName(int roleId) {
        switch (roleId) {
            case 1:
                return ROLE_ADMIN;
            case 2:
                return ROLE_PLANNER;
            case 3:
                return ROLE_CUSTOMER;
            case -1:
            case -2:
                return ROLE_ERROR;
            default:
                return ROLE_UNKNOWN;
        }
    }

    public int getRoleType() {
        return roleId;
    }
}
