package com.course.business.controller.admin;

import com.course.server.service.CourseService;
import com.course.server.util.ValidatorUtil;
import com.course.server.vo.CourseVO;
import com.course.server.vo.PageVO;
import com.course.server.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @RestController 返回json数据时用
 * @Controller 返回页面时用
 */
@RestController
@RequestMapping("/admin/course")
public class CourseController {

    public static final String BUSINESS_NAME = "课程";

    @Resource
    private CourseService courseService;

    /**
     * 参数加上@RequestBody 按照接受流的方式接受前端过来的数据
     * @param pageVO
     * @return
     */
    @PostMapping("/list")
    public ResponseVO list(@RequestBody PageVO pageVO) {
        courseService.list(pageVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(pageVO);
        return responseVO;
    }

    @PostMapping("/save")
    public ResponseVO save(@RequestBody CourseVO courseVO) {

        // 保存校验
                ValidatorUtil.require(courseVO.getName(), "名称");
                ValidatorUtil.length(courseVO.getName(), "名称", 1, 50);
                ValidatorUtil.length(courseVO.getSummary(), "概述", 1, 2000);
                ValidatorUtil.length(courseVO.getImage(), "封面", 1, 100);

        courseService.save(courseVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(courseVO);
        return responseVO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable String id) {
        courseService.delete(id);
        ResponseVO responseVO = new ResponseVO();
        return responseVO;
    }
}
