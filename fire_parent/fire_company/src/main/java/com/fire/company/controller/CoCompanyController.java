package com.fire.company.controller;

import com.fire.common.model.Result;
import com.fire.common.model.StatusCode;
import com.fire.entity.company.CoCompany;
import com.fire.company.service.CoCompanyService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CoCompany)表控制层
 *
 * @author xu.dm
 * @since 2020-04-17 11:03:36
 */
@RestController
@RequestMapping("company")
@CrossOrigin
public class CoCompanyController {
    /**
     * 服务对象
     */
    @Resource
    private CoCompanyService coCompanyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CoCompany selectOne(@PathVariable Long id) {
        int i = 10/0;
        return this.coCompanyService.queryById(id);
    }

    @GetMapping
    public List<CoCompany> selectAll(){
        return coCompanyService.queryAll(null);
    }

    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<CoCompany> queryByPage(@PathVariable int pageNum, @PathVariable int pageSize){
        return coCompanyService.queryByPage(pageNum,pageSize);
    }

    @PostMapping
    public Result<CoCompany> insert(@RequestBody CoCompany coCompany) {
        try {
            coCompany = coCompanyService.insert(coCompany);
            return new Result<>(true, StatusCode.OK,"添加成功",coCompany);
        }catch (Exception e){
            return new Result<>(false,StatusCode.ERROR,"添加失败"+e.getMessage(),coCompany);
        }
    }

    @PutMapping
    public Result<CoCompany> update(@RequestBody CoCompany coCompany) {
        try {
            coCompany = coCompanyService.update(coCompany);
            return new Result<>(true, StatusCode.OK,"修改成功",coCompany);
        }catch (Exception e){
            return new Result<>(false,StatusCode.ERROR,"修改失败"+e.getMessage(),coCompany);
        }
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Long id){
        if(coCompanyService.deleteById(id)){
            return new Result(true, StatusCode.OK,"删除成功");
        }else {
            return new Result(false, StatusCode.OK,"删除失败");
        }
    }


}