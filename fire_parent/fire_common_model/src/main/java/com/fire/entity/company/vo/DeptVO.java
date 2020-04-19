package com.fire.entity.company.vo;

import com.fire.entity.company.CoCompany;
import com.fire.entity.company.CoDepartment;
import lombok.Data;

import java.util.List;

/**
 * @Author: xu.dm
 * @Date: 2020/4/18 19:46
 * @Description:
 */
@Data
public class DeptVO {
    private Long companyId;
    private String companyName;
    private String companyManage;//公司联系人
    private List<CoDepartment> depts;

    public DeptVO(CoCompany company, List<CoDepartment> depts) {
        this.companyId = company.getId();
        this.companyName = company.getName();
        this.companyManage = company.getLegalRepresentative();//公司联系人
        this.depts = depts;
    }
}
