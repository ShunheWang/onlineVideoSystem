package com.course.server.service;

import com.course.server.dto.Course;
import com.course.server.dto.CourseContent;
import com.course.server.dto.CourseExample;
import com.course.server.dto.SortDto;
import com.course.server.mapper.CourseContentMapper;
import com.course.server.mapper.CourseMapper;
import com.course.server.mapper.my.MyCourseMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.course.server.vo.CourseContentVO;
import com.course.server.vo.CourseVO;
import com.course.server.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
        import java.util.Date;

@Service
public class CourseService {

    private static final Logger LOG =  LoggerFactory.getLogger(CourseService.class);

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private MyCourseMapper myCourseMapper;

    @Resource
    private CourseCategoryService courseCategoryService;

    @Resource
    private CourseContentMapper courseContentMapper;

    public void list(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getSize());
        CourseExample courseExample = new CourseExample();
                courseExample.setOrderByClause("sort asc");
        List<Course> courseDTOList = courseMapper.selectByExample(courseExample);
        PageInfo<Course> pageInfo = new PageInfo<>(courseDTOList);
        pageVO.setTotal(pageInfo.getTotal());
        List<CourseVO> courseVOList = CopyUtil.copyList(courseDTOList, CourseVO.class);
        pageVO.setList(courseVOList);
    }

    @Transactional
    public void save(CourseVO courseVO) {
        Course course = CopyUtil.copy(courseVO, Course.class);
        if (StringUtils.isEmpty(course.getId())) {
            this.insert(course);
        } else {
            this.update(course);
        }

        // ????????????????????????
        courseCategoryService.saveBatch(course.getId(), courseVO.getCategorys());
    }

    private void insert(Course course) {
        Date now = new Date();
        course.setCreatedAt(now);
        course.setUpdatedAt(now);
        course.setId(UuidUtil.getShortUuid());
        courseMapper.insert(course);
    }

    private void update(Course course) {
        course.setUpdatedAt(new Date());
        courseMapper.updateByPrimaryKey(course);
    }

    public void delete(String id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    /**
     * ??????????????????
     * @param courseId
     */
    public void updateTime(String courseId) {
        LOG.info("??????????????????:{}", courseId);
        myCourseMapper.updateTime(courseId);
    }

    /**
     * ????????????
     * @param id
     * @return
     */
    public CourseContentVO findContent(String id) {
        CourseContent content = courseContentMapper.selectByPrimaryKey(id);
        if (content == null) {
            return null;
        }
        return CopyUtil.copy(content, CourseContentVO.class);
    }

    /**
     * ??????????????????, ?????????????????????
     * @param courseDto
     * @return
     */
    public int saveContent(CourseContentVO courseDto) {
        CourseContent content = CopyUtil.copy(courseDto, CourseContent.class);
        int result = courseContentMapper.updateByPrimaryKeyWithBLOBs(content);
        if (result == 0) {
            result = courseContentMapper.insert(content);
        }
        return result;
    }

    /**
     * ??????
     * @param sortDto
     */
    @Transactional
    public void sort(SortDto sortDto) {
        // ??????????????????????????????
        myCourseMapper.updateSort(sortDto);

        // ?????????????????????
        if (sortDto.getNewSort() > sortDto.getOldSort()) {
            myCourseMapper.moveSortsForward(sortDto);
        }

        // ?????????????????????
        if (sortDto.getNewSort() < sortDto.getOldSort()) {
            myCourseMapper.moveSortsBackward(sortDto);
        }
    }
}
