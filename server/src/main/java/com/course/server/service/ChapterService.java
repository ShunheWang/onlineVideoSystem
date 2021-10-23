package com.course.server.service;

import com.course.server.dto.Chapter;
import com.course.server.dto.ChapterExample;
import com.course.server.mapper.ChapterMapper;
import com.course.server.vo.ChapterVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public List<ChapterVO> list() {
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapterDTOList = chapterMapper.selectByExample(chapterExample);
        List<ChapterVO> chapterVOList = new ArrayList<>();
        for (int i = 0, l = chapterDTOList.size(); i < l; i++) {
            Chapter chapter = chapterDTOList.get(i);
            ChapterVO chapterVO = new ChapterVO();
            BeanUtils.copyProperties(chapter, chapterVO);
            chapterVOList.add(chapterVO);
        }
        return chapterVOList;
    }

}
