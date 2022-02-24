package cn.zyt.mapper;

import cn.zyt.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper
{
    List<Dept> getAllDept();
}
