package cn.zyt.controller;

import cn.zyt.common.vo.Result;
import cn.zyt.entity.Dept;
import cn.zyt.entity.Emp;
import cn.zyt.service.EmpService;
import cn.zyt.vo.EmpQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController
{
    @Autowired
    private EmpService empService;

    //跳转到员工列表页面
    @GetMapping("")
    public String toEmpListUI()
    {
        return "emp/empList";
    }


    //员工查询
    @ResponseBody
    @GetMapping("/list")
    public Result<Object> getEmpList(EmpQuery param)
    {
        List<Emp> list = empService.getEmpList(param);
        Long count = empService.countEmpList(param);
        return Result.success(list,count);
    }


    //新增员工
    @ResponseBody
    @PostMapping()
    public Result<Object> addEmp(Emp emp)
    {
        empService.addEmp(emp);
        return Result.success("新增员工成功！");
    }

    //实现到添加页面的跳转
    @GetMapping("/add/ui")
    public String empAdd(Model model)
    {
        /*同时将部门数据传送过去*/
        List<Dept> deptList = empService.getAllDept();
        model.addAttribute("deptList",deptList);
        return "emp/empAdd";
    }

    //删除员工
    @DeleteMapping("/{ids}")
    @ResponseBody
    public Result<Object> deleteEmpByIds(@PathVariable("ids") String ids)
    {
        empService.deleteEmpByIds(ids);
        return Result.success("删除员工成功!");
    }

    //获取员工信息
    @GetMapping("/{id}")
    public String getEmpById(@PathVariable("id") Integer id,Model model)
    {
        Emp emp = empService.getEmpById(id);
        model.addAttribute("emp",emp);
        model.addAttribute("deptList",empService.getAllDept());
        return "emp/empEdit";
    }

    @PutMapping("")
    @ResponseBody
    public Result<Object> updateEmp(Emp emp)
    {
        empService.updateEmp(emp);
        return Result.success("修改员工信息成功!");
    }
}
