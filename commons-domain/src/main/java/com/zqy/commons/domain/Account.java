package com.zqy.commons.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zqy.commons.dto.AbstractBaseDomain;
import com.zqy.commons.utils.RegexpUtils;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Table(name = "account")
public class Account extends AbstractBaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer balance;

    @Column(name = "user_name")
    @NotNull(message = "用户名不可为空")
    @Length(min = 5, max = 20, message = "用户名长度必须介于 5 和 20 之间")
    private String userName;

    /**
     * 密码，加密存储
     */
    @JsonIgnore
    private String password;

    /**
     * 注册邮箱
     */
    @NotNull(message = "邮箱不可为空")
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;

    private String phone;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return balance
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * @param balance
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}