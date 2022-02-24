package cn.zyt.service.impl;

import cn.zyt.entity.Dept;
import cn.zyt.entity.Emp;
import cn.zyt.mapper.DeptMapper;
import cn.zyt.mapper.EmpMapper;
import cn.zyt.service.EmpService;
import cn.zyt.vo.EmpQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService
{
    @Resource
    EmpMapper empMapper;

    @Resource
    DeptMapper deptMapper;

    @Override
    public List<Emp> getEmpList(EmpQuery param)
    {
        return empMapper.getEmpList(param);
    }

    @Override
    public Long countEmpList(EmpQuery param)
    {
        return empMapper.countEmpList(param);
    }

    @Override
    public void addEmp(Emp emp)
    {
        empMapper.addEmp(emp);
    }

    @Override
    public List<Dept> getAllDept()
    {
        return deptMapper.getAllDept();
    }

    @Override
    public void deleteEmpByIds(String ids)
    {
        empMapper.deleteEmpByIds(ids);
    }

    @Override
    public Emp getEmpById(Integer id)
    {
        return empMapper.getEmpById(id);
    }

    @Override
    public void updateEmp(Emp emp)
    {
        empMapper.updateEmp(emp);
    }
}
