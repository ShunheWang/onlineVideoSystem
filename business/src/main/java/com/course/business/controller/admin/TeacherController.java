package com.course.business.controller.admin;

import com.course.server.service.TeacherService;
import com.course.server.util.ValidatorUtil;
import com.course.server.vo.TeacherVO;
import com.course.server.vo.PageVO;
import com.course.server.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @RestController 返回json数据时用
 * @Controller 返回页面时用
 */
@RestController
@RequestMapping("/admin/teacher")
public class TeacherController {

    public static final String BUSINESS_NAME = "讲师";

    @Resource
    private TeacherService teacherService;

    /**
     * 参数加上@RequestBody 按照接受流的方式接受前端过来的数据
     * @param pageVO
     * @return
     */
    @PostMapping("/list")
    public ResponseVO list(@RequestBody PageVO pageVO) {
        teacherService.list(pageVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(pageVO);
        return responseVO;
    }

    @PostMapping("/save")
    public ResponseVO save(@RequestBody TeacherVO teacherVO) {

        // 保存校验
                ValidatorUtil.require(teacherVO.getName(), "名称");
                ValidatorUtil.length(teacherVO.getName(), "名称", 1, 50);
                ValidatorUtil.length(teacherVO.getNickname(), "昵称", 1, 50);
                ValidatorUtil.length(teacherVO.getImage(), "头像", 1, 100);
                ValidatorUtil.length(teacherVO.getPosition(), "职位", 1, 50);
                ValidatorUtil.length(teacherVO.getMotto(), "座右铭", 1, 50);
                ValidatorUtil.length(teacherVO.getIntro(), "简介", 1, 500);

        teacherService.save(teacherVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(teacherVO);
        return responseVO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable String id) {
        teacherService.delete(id);
        ResponseVO responseVO = new ResponseVO();
        return responseVO;
    }
}
