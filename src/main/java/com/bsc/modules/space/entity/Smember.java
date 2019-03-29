package com.bsc.modules.space.entity;
import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.dict.entity.Dict;
import com.bsc.modules.space.entity.Space;
import com.bsc.modules.user.entity.User;

import java.util.List;

/**
 * @author yangrui
 */

public class Smember extends BaseEntity{
   // private Space space;
    private Space spaceID;		 // 空间ID
   // private Dict dict;
    private String type;	    // 类型
 //   private User user;
    private User member;         //成员ID


    public Space getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(Space spaceID) {
        this.spaceID = spaceID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }
}
