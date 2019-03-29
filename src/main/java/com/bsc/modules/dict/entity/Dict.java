package com.bsc.modules.dict.entity;
import com.bsc.common.persistence.BaseEntity;
public class Dict extends BaseEntity{
    private String value;          //键值
    private String label;          //标签
    private String type;           //类型
    private String description;   //描述
    private Integer sort;          //排序
    private String pid;            //pid

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }


}
