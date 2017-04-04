package com.lastway.order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by makson on 04.04.17.
 */

@ManagedBean
@SessionScoped
public class Order implements Serializable {
    private static final long serialVersionUID = 4053950732856666840L;

    private String name;

    private List<OrderValue> valueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<OrderValue> getValueList() {
        return valueList;
    }

    public void setValueList(List<OrderValue> valueList) {
        this.valueList = valueList;
    }
}
