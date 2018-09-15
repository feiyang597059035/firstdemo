package com.cn.firstdemo.model;

import java.io.Serializable;

public class BU  implements Serializable{
    /**
    *
    */
    private static final long serialVersionUID = 1L;
    private String ss;
    private String bb;
    private String yy;

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

}
