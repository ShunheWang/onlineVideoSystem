package com.course.server.service;

import com.course.server.dto.Category;
import com.course.server.dto.CategoryExample;
import com.course.server.mapper.CategoryMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.course.server.vo.CategoryVO;
import com.course.server.vo.PageVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    public void list(PageVO pageVO) {
        PageHelper.startPage(pageVO.getPage(), pageVO.getSize());
        CategoryExample categoryExample = new CategoryExample();
                categoryExample.setOrderByClause("sort asc");
        List<Category> categoryDTOList = categoryMapper.selectByExample(categoryExample);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryDTOList);
        pageVO.setTotal(pageInfo.getTotal());
        List<CategoryVO> categoryVOList = CopyUtil.copyList(categoryDTOList, CategoryVO.class);
        pageVO.setList(categoryVOList);
    }

    public void save(CategoryVO categoryVO) {
        Category category = CopyUtil.copy(categoryVO, Category.class);
        if (StringUtils.isEmpty(category.getId())) {
            this.insert(category);
        } else {
            this.update(category);
        }
    }

    private void insert(Category category) {
        category.setId(UuidUtil.getShortUuid());
        categoryMapper.insert(category);
    }

    private void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }

    public void delete(String id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}
