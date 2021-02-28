package com.payment.model;

import com.payment.model.enums.ActivityStatus;
import com.payment.model.enums.Role;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long roleId;
    private Long activityStatusId;
//    private LocalDateTime createTime;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = (long) Role.valueOf("CLIENT").ordinal();
        this.activityStatusId = (long) ActivityStatus.valueOf("ACTIVE").ordinal();
        //this.createTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

//    public LocalDateTime getCreateTime() {
//        return createTime;
//    }

//    public void setCreateTime(LocalDateTime createTime) {
//        this.createTime = createTime;
//    }


    public Long getActivityStatusId() {
        return activityStatusId;
    }

    public void setActivityStatusId(Long activityStatusId) {
        this.activityStatusId = activityStatusId;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", email='" + email + '\''
                + ", password='" + password + '\''
                + ", role=" + roleId
                + ", activityStatusId=" + activityStatusId
//                + ", createTime=" + createTime
                + '}';
    }
}
