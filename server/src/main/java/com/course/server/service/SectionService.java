package com.course.server.service;

import com.course.server.dto.Section;
import com.course.server.dto.SectionExample;
import com.course.server.mapper.SectionMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.course.server.vo.SectionVO;
import com.course.server.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
        import java.util.Date;

@Service
public class SectionService {

    @Resource
    private SectionMapper sectionMapper;

    public void list(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getSize());
        SectionExample sectionExample = new SectionExample();
                sectionExample.setOrderByClause("sort asc");
        List<Section> sectionDTOList = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionDTOList);
        pageVO.setTotal(pageInfo.getTotal());
        List<SectionVO> sectionVOList = CopyUtil.copyList(sectionDTOList, SectionVO.class);
        pageVO.setList(sectionVOList);
    }

    public void save(SectionVO sectionVO) {
        Section section = CopyUtil.copy(sectionVO, Section.class);
        if (StringUtils.isEmpty(section.getId())) {
            this.insert(section);
        } else {
            this.update(section);
        }
    }

    private void insert(Section section) {
        Date now = new Date();
        section.setCreatedAt(now);
        section.setUpdatedAt(now);
        section.setId(UuidUtil.getShortUuid());
        sectionMapper.insert(section);
    }

    private void update(Section section) {
        section.setUpdatedAt(new Date());
        sectionMapper.updateByPrimaryKey(section);
    }

    public void delete(String id) {
        sectionMapper.deleteByPrimaryKey(id);
    }
}
