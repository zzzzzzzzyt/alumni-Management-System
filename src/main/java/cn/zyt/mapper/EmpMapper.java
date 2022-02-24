package cn.zyt.mapper;


import cn.zyt.entity.Emp;
import cn.zyt.vo.EmpQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper
{
    List<Emp> getEmpList(EmpQuery param);
    Long countEmpList(EmpQuery param);
    void addEmp(Emp emp);
    void deleteEmpByIds(String ids);
    Emp getEmpById(Integer id);
    void updateEmp(Emp emp);
}
