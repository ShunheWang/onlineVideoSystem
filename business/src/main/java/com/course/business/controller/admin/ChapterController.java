package com.course.business.controller.admin;

import com.course.server.dto.Chapter;
import com.course.server.service.ChapterService;
import com.course.server.vo.ChapterVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @RestController 返回json数据时用
 * @Controller 返回页面时用
 */
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/list")
    public List<ChapterVO> list() {
        return chapterService.list();
    }
}
