package com.bsc.modules.user.entity;
import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.dict.entity.Dict;

public class User extends BaseEntity {
    private String num;
    private String type;
    private String password;
    private String name;
    private String sex;
    private String photo;
    private String academy;
    private String signature;
    private String tel;
    private String mailbox;

    public String getNum() { return num; }
    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }

    public String getMailbox() {
        return mailbox;
    }
    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() { return type; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public String getAcademy() {
        return academy;
    }
    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

}
