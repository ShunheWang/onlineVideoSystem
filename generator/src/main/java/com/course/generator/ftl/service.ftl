package com.course.server.service;

import com.course.server.dto.${Domain};
import com.course.server.dto.${Domain}Example;
import com.course.server.mapper.${Domain}Mapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.course.server.vo.${Domain}VO;
import com.course.server.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
<#list typeSet as type>
    <#if type=='Date'>
        import java.util.Date;
    </#if>
</#list>

@Service
public class ${Domain}Service {

    @Resource
    private ${Domain}Mapper ${domain}Mapper;

    public void list(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getSize());
        ${Domain}Example ${domain}Example = new ${Domain}Example();
        <#list fieldList as field>
             <#if field.nameHump=='sort'>
                ${domain}Example.setOrderByClause("sort asc");
             </#if>
        </#list>
        List<${Domain}> ${domain}DTOList = ${domain}Mapper.selectByExample(${domain}Example);
        PageInfo<${Domain}> pageInfo = new PageInfo<>(${domain}DTOList);
        pageVO.setTotal(pageInfo.getTotal());
        List<${Domain}VO> ${domain}VOList = CopyUtil.copyList(${domain}DTOList, ${Domain}VO.class);
        pageVO.setList(${domain}VOList);
    }

    public void save(${Domain}VO ${domain}VO) {
        ${Domain} ${domain} = CopyUtil.copy(${domain}VO, ${Domain}.class);
        if (StringUtils.isEmpty(${domain}.getId())) {
            this.insert(${domain});
        } else {
            this.update(${domain});
        }
    }

    private void insert(${Domain} ${domain}) {
        Date now = new Date();
        <#list fieldList as field>
            <#if field.nameHump=='createdAt'>
        ${domain}.setCreatedAt(now);
            </#if>
            <#if field.nameHump=='updatedAt'>
        ${domain}.setUpdatedAt(now);
            </#if>
        </#list>
        ${domain}.setId(UuidUtil.getShortUuid());
        ${domain}Mapper.insert(${domain});
    }

    private void update(${Domain} ${domain}) {
        <#list fieldList as field>
            <#if field.nameHump=='updatedAt'>
        ${domain}.setUpdatedAt(new Date());
            </#if>
        </#list>
        ${domain}Mapper.updateByPrimaryKey(${domain});
    }

    public void delete(String id) {
        ${domain}Mapper.deleteByPrimaryKey(id);
    }
}
