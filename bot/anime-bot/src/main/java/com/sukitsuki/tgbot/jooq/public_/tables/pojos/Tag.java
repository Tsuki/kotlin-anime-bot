/*
 * This file is generated by jOOQ.
*/
package com.sukitsuki.tgbot.jooq.public_.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tag implements Serializable {

    private static final long serialVersionUID = 1890688377;

    private Integer id;
    private Integer rid;
    private String  zhtw;
    private String  zhcn;
    private String  en;
    private String  jp;

    public Tag() {}

    public Tag(Tag value) {
        this.id = value.id;
        this.rid = value.rid;
        this.zhtw = value.zhtw;
        this.zhcn = value.zhcn;
        this.en = value.en;
        this.jp = value.jp;
    }

    public Tag(
        Integer id,
        Integer rid,
        String  zhtw,
        String  zhcn,
        String  en,
        String  jp
    ) {
        this.id = id;
        this.rid = rid;
        this.zhtw = zhtw;
        this.zhcn = zhcn;
        this.en = en;
        this.jp = jp;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return this.rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getZhtw() {
        return this.zhtw;
    }

    public void setZhtw(String zhtw) {
        this.zhtw = zhtw;
    }

    public String getZhcn() {
        return this.zhcn;
    }

    public void setZhcn(String zhcn) {
        this.zhcn = zhcn;
    }

    public String getEn() {
        return this.en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getJp() {
        return this.jp;
    }

    public void setJp(String jp) {
        this.jp = jp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tag (");

        sb.append(id);
        sb.append(", ").append(rid);
        sb.append(", ").append(zhtw);
        sb.append(", ").append(zhcn);
        sb.append(", ").append(en);
        sb.append(", ").append(jp);

        sb.append(")");
        return sb.toString();
    }
}
