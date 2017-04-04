package com.lastway.order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by makson on 04.04.17.
 */

@ManagedBean
@SessionScoped
public class OrderValue implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer cost;
    private String value;
    private String amount;

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
