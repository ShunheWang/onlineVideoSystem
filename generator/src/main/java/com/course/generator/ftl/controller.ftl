package com.course.${module}.controller.admin;

import com.course.server.service.${Domain}Service;
import com.course.server.util.ValidatorUtil;
import com.course.server.vo.${Domain}VO;
import com.course.server.vo.PageVO;
import com.course.server.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @RestController 返回json数据时用
 * @Controller 返回页面时用
 */
@RestController
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller {

    public static final String BUSINESS_NAME = "${tableNameCn}";

    @Resource
    private ${Domain}Service ${domain}Service;

    /**
     * 参数加上@RequestBody 按照接受流的方式接受前端过来的数据
     * @param pageVO
     * @return
     */
    @PostMapping("/list")
    public ResponseVO list(@RequestBody PageVO pageVO) {
        ${domain}Service.list(pageVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(pageVO);
        return responseVO;
    }

    @PostMapping("/save")
    public ResponseVO save(@RequestBody ${Domain}VO ${domain}VO) {

        // 保存校验
        <#list fieldList as field>
            <#if !field.nullable>
        ValidatorUtil.require(${domain}VO.get${field.nameBigHump}(), "${field.nameCn}");
            </#if>
            <#if (field.length > 0)>
        ValidatorUtil.length(${domain}VO.get${field.nameBigHump}(), "${field.nameCn}", 1, ${field.length});
            </#if>
        </#list>

        ${domain}Service.save(${domain}VO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(${domain}VO);
        return responseVO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable String id) {
        ${domain}Service.delete(id);
        ResponseVO responseVO = new ResponseVO();
        return responseVO;
    }
}
