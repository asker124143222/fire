package com.fire.company.controller;

import com.fire.common.controller.BaseController;
import com.fire.common.model.Result;
import com.fire.common.model.StatusCode;
import com.fire.company.service.CoCompanyService;
import com.fire.entity.company.CoCompany;
import com.fire.entity.company.CoDepartment;
import com.fire.company.service.CoDepartmentService;
import com.fire.entity.company.vo.DeptVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CoDepartment)表控制层
 *
 * @author xu.dm
 * @since 2020-04-18 16:22:09
 */
@RestController
@RequestMapping("/company/dept")
@CrossOrigin
public class CoDepartmentController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private CoDepartmentService coDepartmentService;
    @Resource
    private CoCompanyService coCompanyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CoDepartment selectOne(@PathVariable Long id) {
        return this.coDepartmentService.queryById(id);
    }

    @GetMapping
    public DeptVO selectAll(){
        CoDepartment coDepartment = new CoDepartment();
        coDepartment.setCompanyId(super.companyId);
        List<CoDepartment> lists = coDepartmentService.queryAll(coDepartment);
        CoCompany coCompany = coCompanyService.queryById(super.companyId);
        DeptVO depts = new DeptVO(coCompany,lists);
        return depts;
    }

    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<CoDepartment> queryByPage(@PathVariable int pageNum, @PathVariable int pageSize){
        CoDepartment coDepartment = new CoDepartment();
        coDepartment.setCompanyId(super.companyId);
        return coDepartmentService.queryByPage(coDepartment,pageNum,pageSize);
    }

    @PostMapping
    public Result<CoDepartment> insert(@RequestBody CoDepartment coDepartment) {
        coDepartment = coDepartmentService.insert(coDepartment);
        return new Result<>(true, StatusCode.OK,"添加成功",coDepartment);
    }

    @PutMapping
    public Result<CoCompany> update(@RequestBody CoDepartment coDepartment) {
        coDepartment = coDepartmentService.update(coDepartment);
        return new Result<>(true, StatusCode.OK,"修改成功",coDepartment);
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Long id){
        if(coDepartmentService.deleteById(id)){
            return new Result(true, StatusCode.OK,"删除成功");
        }else {
            return new Result(false, StatusCode.OK,"删除失败");
        }
    }
}