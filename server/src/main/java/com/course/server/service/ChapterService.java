package com.course.server.service;

import com.course.server.dto.Chapter;
import com.course.server.dto.ChapterExample;
import com.course.server.mapper.ChapterMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.course.server.vo.ChapterPageVO;
import com.course.server.vo.ChapterVO;
import com.course.server.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public void list(ChapterPageVO chapterPageVO) {
        PageHelper.startPage(chapterPageVO.getPage(), chapterPageVO.getSize());
        ChapterExample chapterExample = new ChapterExample();
        ChapterExample.Criteria criteria = chapterExample.createCriteria();
        if (!StringUtils.isEmpty(chapterPageVO.getCourseId())) {
            criteria.andCourseIdEqualTo(chapterPageVO.getCourseId());
        }
        List<Chapter> chapterDTOList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterDTOList);
        chapterPageVO.setTotal(pageInfo.getTotal());
        List<ChapterVO> chapterVOList = CopyUtil.copyList(chapterDTOList, ChapterVO.class);
        chapterPageVO.setList(chapterVOList);
    }

    public void save(ChapterVO chapterVO) {
        Chapter chapter = CopyUtil.copy(chapterVO, Chapter.class);
        if (StringUtils.isEmpty(chapter.getId())) {
            this.insert(chapter);
        } else {
            this.update(chapter);
        }
    }

    private void insert(Chapter chapter) {
        chapter.setId(UuidUtil.getShortUuid());
        chapterMapper.insert(chapter);
    }

    private void update(Chapter chapter) {
        chapterMapper.updateByPrimaryKey(chapter);
    }

    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }
}
