package com.course.server.service;

import com.course.server.dto.CourseCategory;
import com.course.server.dto.CourseCategoryExample;
import com.course.server.mapper.CourseCategoryMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.course.server.vo.CategoryVO;
import com.course.server.vo.CourseCategoryVO;
import com.course.server.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseCategoryService {

    @Resource
    private CourseCategoryMapper courseCategoryMapper;

    public void list(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getSize());
        CourseCategoryExample courseCategoryExample = new CourseCategoryExample();
        List<CourseCategory> courseCategoryDTOList = courseCategoryMapper.selectByExample(courseCategoryExample);
        PageInfo<CourseCategory> pageInfo = new PageInfo<>(courseCategoryDTOList);
        pageVO.setTotal(pageInfo.getTotal());
        List<CourseCategoryVO> courseCategoryVOList = CopyUtil.copyList(courseCategoryDTOList, CourseCategoryVO.class);
        pageVO.setList(courseCategoryVOList);
    }

    public void save(CourseCategoryVO courseCategoryVO) {
        CourseCategory courseCategory = CopyUtil.copy(courseCategoryVO, CourseCategory.class);
        if (StringUtils.isEmpty(courseCategory.getId())) {
            this.insert(courseCategory);
        } else {
            this.update(courseCategory);
        }
    }

    private void insert(CourseCategory courseCategory) {
        courseCategory.setId(UuidUtil.getShortUuid());
        courseCategoryMapper.insert(courseCategory);
    }

    private void update(CourseCategory courseCategory) {
        courseCategoryMapper.updateByPrimaryKey(courseCategory);
    }

    public void delete(String id) {
        courseCategoryMapper.deleteByPrimaryKey(id);
    }

    public void saveBatch(String courseId, List<CategoryVO> dtoList) {
        CourseCategoryExample example = new CourseCategoryExample();
        example.createCriteria().andCourseIdEqualTo(courseId);
        courseCategoryMapper.deleteByExample(example);

        for (int i = 0, l = dtoList.size(); i < l; i++) {
            CategoryVO categoryVO = dtoList.get(i);
            CourseCategory courseCategory = new CourseCategory();
            courseCategory.setId(UuidUtil.getShortUuid());
            courseCategory.setCourseId(courseId);
            courseCategory.setCategoryId(categoryVO.getId());
            insert(courseCategory);
        }
    }
}
