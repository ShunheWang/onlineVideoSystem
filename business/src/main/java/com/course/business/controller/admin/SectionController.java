package com.course.business.controller.admin;

import com.course.server.service.SectionService;
import com.course.server.util.ValidatorUtil;
import com.course.server.vo.SectionPageVO;
import com.course.server.vo.SectionVO;
import com.course.server.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @RestController 返回json数据时用
 * @Controller 返回页面时用
 */
@RestController
@RequestMapping("/admin/section")
public class SectionController {

    public static final String BUSINESS_NAME = "小节";

    @Resource
    private SectionService sectionService;

    /**
     * 参数加上@RequestBody 按照接受流的方式接受前端过来的数据
     * @param sectionPageVO
     * @return
     */
    @PostMapping("/list")
    public ResponseVO list(@RequestBody SectionPageVO sectionPageVO) {
        ValidatorUtil.require(sectionPageVO.getCourseId(), "课程ID");
        ValidatorUtil.require(sectionPageVO.getChapterId(), "大章ID");
        sectionService.list(sectionPageVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(sectionPageVO);
        return responseVO;
    }

    @PostMapping("/save")
    public ResponseVO save(@RequestBody SectionVO sectionVO) {

        // 保存校验
                ValidatorUtil.require(sectionVO.getTitle(), "标题");
                ValidatorUtil.length(sectionVO.getTitle(), "标题", 1, 50);
                ValidatorUtil.length(sectionVO.getVideo(), "视频", 1, 200);

        sectionService.save(sectionVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(sectionVO);
        return responseVO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable String id) {
        sectionService.delete(id);
        ResponseVO responseVO = new ResponseVO();
        return responseVO;
    }
}
