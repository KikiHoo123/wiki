package com.bsc.modules.interaction.entity;
import com.bsc.common.persistence.BaseEntity;
import com.bsc.modules.dict.entity.Dict;
import com.bsc.modules.interaction.entity.Interaction;
import com.bsc.modules.space.entity.Space;
import com.bsc.modules.user.entity.User;
import com.bsc.modules.wiki.entity.Wiki;

/**
 * @author YangRui
 */
public class Interaction extends BaseEntity{

    private Wiki wikiID;   //wiki id
    private User userID;  //用户id
    private Space spaceID;   //空间id
    private String time;		// 时间
    private String type;		 //类型
    private String content;	    // 评论内容


    public Wiki getWikiID() {
        return wikiID;
    }

    public void setWikiID(Wiki wikiID) {
        this.wikiID = wikiID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Space getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(Space spaceID) {
        this.spaceID = spaceID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
