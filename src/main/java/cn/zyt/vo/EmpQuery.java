package cn.zyt.vo;

import cn.zyt.common.vo.Page;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//查询条件集成的类
@Data
public class EmpQuery extends Page
{
    private String name;
    //这是为了和json中日期 字段格式匹配
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
}
