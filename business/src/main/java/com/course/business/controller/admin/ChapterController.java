package com.course.business.controller.admin;

import com.course.server.service.ChapterService;
import com.course.server.vo.ChapterVO;
import com.course.server.vo.PageVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @RestController 返回json数据时用
 * @Controller 返回页面时用
 */
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    /**
     * 参数加上@RequestBody 按照接受流的方式接受前端过来的数据
     * @param pageVO
     * @return
     */
    @RequestMapping("/list")
    public PageVO list(@RequestBody PageVO pageVO) {
        chapterService.list(pageVO);
        return pageVO;
    }

    @RequestMapping("/save")
    public ChapterVO save(@RequestBody ChapterVO chapterVO) {
//        LOG.info("chapterDto: {}", chapterVO);
        chapterService.save(chapterVO);
        return chapterVO;
    }
}
