package com.course.server.service;

import com.course.server.dto.Section;
import com.course.server.dto.SectionExample;
import com.course.server.enums.SectionChargeEnum;
import com.course.server.mapper.SectionMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.course.server.vo.SectionPageVO;
import com.course.server.vo.SectionVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
        import java.util.Date;

@Service
public class SectionService {

//    private static final Logger LOG =  LoggerFactory.getLogger(CourseService.class);

    @Resource
    private SectionMapper sectionMapper;

    @Resource
    private CourseService courseService;    // 平级调用

    public void list(SectionPageVO sectionPageVO) {
        PageHelper.startPage(sectionPageVO.getPage(), sectionPageVO.getSize());
        SectionExample sectionExample = new SectionExample();
        SectionExample.Criteria criteria = sectionExample.createCriteria();
        if (!StringUtils.isEmpty(sectionPageVO.getCourseId())) {
            criteria.andCourseIdEqualTo(sectionPageVO.getCourseId());
        }
        if (!StringUtils.isEmpty(sectionPageVO.getChapterId())) {
            criteria.andChapterIdEqualTo(sectionPageVO.getChapterId());
        }
        sectionExample.setOrderByClause("sort asc");
        List<Section> sectionDTOList = sectionMapper.selectByExample(sectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(sectionDTOList);
        sectionPageVO.setTotal(pageInfo.getTotal());
        List<SectionVO> sectionVOList = CopyUtil.copyList(sectionDTOList, SectionVO.class);
        sectionPageVO.setList(sectionVOList);
    }

    /**
     * 保存，id有值时更新，无值时新增
     * @param sectionVO
     */
    /**
     * @Transactional
     * 1. 如果是Exception时, 事务不会回滚; 如果MUST要Exception也要回滚, 需要@Transactional(rollbackFor = Exception.class)
     * 2. 如果是RuntimeException时, 事务会回滚;
     * 3. try...catch...不会回滚;
     * thus, 自定义异常编写时一般继承RuntimeException
     */
    @Transactional
    public void save(SectionVO sectionVO) {
        Section section = CopyUtil.copy(sectionVO, Section.class);
        if (StringUtils.isEmpty(section.getId())) {
            this.insert(section);
        } else {
            this.update(section);
        }
        courseService.updateTime(sectionVO.getCourseId());
    }

    private void insert(Section section) {
        Date now = new Date();
        section.setCreatedAt(now);
        section.setUpdatedAt(now);
        section.setId(UuidUtil.getShortUuid());
        section.setCharge(SectionChargeEnum.CHARGE.getCode());
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
