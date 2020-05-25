package com.zqy.commons.domain;

import javax.persistence.*;

@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer balance;

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
}