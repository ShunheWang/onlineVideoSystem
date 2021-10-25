package com.course.server.service;

import com.course.server.dto.Chapter;
import com.course.server.dto.ChapterExample;
import com.course.server.mapper.ChapterMapper;
import com.course.server.vo.ChapterVO;
import com.course.server.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public void list(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getSize());
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapterDTOList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterDTOList);
        pageVO.setTotal(pageInfo.getTotal());
        List<ChapterVO> chapterVOList = new ArrayList<>();
        for (int i = 0, l = chapterDTOList.size(); i < l; i++) {
            Chapter chapter = chapterDTOList.get(i);
            ChapterVO chapterVO = new ChapterVO();
            BeanUtils.copyProperties(chapter, chapterVO);
            chapterVOList.add(chapterVO);
        }
        pageVO.setList(chapterDTOList);
    }

}
