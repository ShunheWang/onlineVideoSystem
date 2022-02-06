package com.course.business.controller.admin;

import com.course.server.service.CourseCategoryService;
import com.course.server.service.CourseService;
import com.course.server.util.ValidatorUtil;
import com.course.server.vo.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private CourseCategoryService courseCategoryService;

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

    @PostMapping("/list-category/{courseId}")
    public ResponseVO listCategory(@PathVariable(value = "courseId") String courseId) {
        ResponseVO responseVO = new ResponseVO();
        List<CourseCategoryVO> dtoList = courseCategoryService.listByCourse(courseId);
        responseVO.setContent(dtoList);
        return responseVO;
    }

    @GetMapping("/find-content/{id}")
    public ResponseVO findContent(@PathVariable String id) {
        ResponseVO responseDto = new ResponseVO();
        CourseContentVO contentDto = courseService.findContent(id);
        responseDto.setContent(contentDto);
        return responseDto;
    }

    @PostMapping("/save-content")
    public ResponseVO saveContent(@RequestBody CourseContentVO contentDto) {
        ResponseVO responseDto = new ResponseVO();
        courseService.saveContent(contentDto);
        return responseDto;
    }
}
