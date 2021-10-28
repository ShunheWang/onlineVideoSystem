package com.course.business.controller.admin;

import com.course.server.service.ChapterService;
import com.course.server.vo.ChapterVO;
import com.course.server.vo.PageVO;
import com.course.server.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/list")
    public ResponseVO list(@RequestBody PageVO pageVO) {
        chapterService.list(pageVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(pageVO);
        return responseVO;
    }

    @PostMapping("/save")
    public ResponseVO save(@RequestBody ChapterVO chapterVO) {
//        LOG.info("chapterDto: {}", chapterVO);
        chapterService.save(chapterVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(chapterVO);
        return responseVO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable String id) {
//        LOG.info("chapterDto: {}", chapterVO);
        chapterService.delete(id);
        ResponseVO responseVO = new ResponseVO();
        return responseVO;
    }
}
