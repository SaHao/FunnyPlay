package com.iejnnnmokkk.common.http.bean;

import java.io.Serializable;

/**
 * @author Sun
 * @Demo class BaseBean
 * @Description TODO
 * @date 2024/12/5 11:29
 */
public class BaseBean implements Serializable {

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
