package com.course.server.service;

import com.course.server.dto.Chapter;
import com.course.server.dto.ChapterExample;
import com.course.server.mapper.ChapterMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
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
//        List<ChapterVO> chapterVOList = new ArrayList<>();
//        for (int i = 0, l = chapterDTOList.size(); i < l; i++) {
//            Chapter chapter = chapterDTOList.get(i);
//            ChapterVO chapterVO = new ChapterVO();
//            BeanUtils.copyProperties(chapter, chapterVO);
//            chapterVOList.add(chapterVO);
//        }
        List<ChapterVO> chapterVOList = CopyUtil.copyList(chapterDTOList, ChapterVO.class);
        pageVO.setList(chapterVOList);
    }

    public void save(ChapterVO chapterVO) {
        chapterVO.setId(UuidUtil.getShortUuid());
//        Chapter chapter = new Chapter();
//        BeanUtils.copyProperties(chapterVO, chapter);
        Chapter chapter = CopyUtil.copy(chapterVO, Chapter.class);
        chapterMapper.insert(chapter);
    }

}
