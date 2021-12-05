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
import org.springframework.transaction.annotation.Transactional;
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

    /**
     * 列表查询
     */
    public List<CategoryVO> all() {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);
        List<CategoryVO> categoryVOList = CopyUtil.copyList(categoryList, CategoryVO.class);
        return categoryVOList;
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

    @Transactional
    public void delete(String id) {
        deleteChildren(id);
        categoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 删除子分类
     * @param id
     */
    private void deleteChildren(String id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if ("00000000".equals(category.getParent())) {  // 如果当前是一级分类，则需要删除二级分类
            CategoryExample example = new CategoryExample();
            example.createCriteria().andParentEqualTo(category.getId());
            categoryMapper.deleteByExample(example);
        }
    }
}
