package cn.zyt.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Page implements Serializable {
    private Integer page;
    private Integer limit;

    //找到目前的起始页
    public Long getStart() {
        return (page - 1L) * limit;
    }
}
