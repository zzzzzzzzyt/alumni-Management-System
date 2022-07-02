package cn.zyt.service;

import cn.zyt.entity.Dept;
import cn.zyt.entity.Emp;
import cn.zyt.vo.EmpQuery;

import java.util.List;

public interface EmpService {
    List<Emp> getEmpList(EmpQuery param);

    Long countEmpList(EmpQuery param);

    void addEmp(Emp emp);

    List<Dept> getAllDept();

    void deleteEmpByIds(String ids);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);
}
