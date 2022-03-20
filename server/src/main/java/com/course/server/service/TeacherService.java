package com.course.server.service;

import com.course.server.dto.Teacher;
import com.course.server.dto.TeacherExample;
import com.course.server.mapper.TeacherMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.course.server.vo.TeacherVO;
import com.course.server.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    public void list(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getSize());
        TeacherExample teacherExample = new TeacherExample();
        List<Teacher> teacherDTOList = teacherMapper.selectByExample(teacherExample);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teacherDTOList);
        pageVO.setTotal(pageInfo.getTotal());
        List<TeacherVO> teacherVOList = CopyUtil.copyList(teacherDTOList, TeacherVO.class);
        pageVO.setList(teacherVOList);
    }

    public void save(TeacherVO teacherVO) {
        Teacher teacher = CopyUtil.copy(teacherVO, Teacher.class);
        if (StringUtils.isEmpty(teacher.getId())) {
            this.insert(teacher);
        } else {
            this.update(teacher);
        }
    }

    private void insert(Teacher teacher) {
        teacher.setId(UuidUtil.getShortUuid());
        teacherMapper.insert(teacher);
    }

    private void update(Teacher teacher) {
        teacherMapper.updateByPrimaryKey(teacher);
    }

    public void delete(String id) {
        teacherMapper.deleteByPrimaryKey(id);
    }
}
