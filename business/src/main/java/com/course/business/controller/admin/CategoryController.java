package com.course.business.controller.admin;

import com.course.server.service.CategoryService;
import com.course.server.util.ValidatorUtil;
import com.course.server.vo.CategoryVO;
import com.course.server.vo.PageVO;
import com.course.server.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @RestController 返回json数据时用
 * @Controller 返回页面时用
 */
@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    public static final String BUSINESS_NAME = "分类";

    @Resource
    private CategoryService categoryService;

    /**
     * @return
     */
    @PostMapping("/all")
    public ResponseVO all() {
        List<CategoryVO> categoryVOList = categoryService.all();
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(categoryVOList);
        return responseVO;
    }

    /**
     * 参数加上@RequestBody 按照接受流的方式接受前端过来的数据
     * @param pageVO
     * @return
     */
    @PostMapping("/list")
    public ResponseVO list(@RequestBody PageVO pageVO) {
        categoryService.list(pageVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(pageVO);
        return responseVO;
    }

    @PostMapping("/save")
    public ResponseVO save(@RequestBody CategoryVO categoryVO) {

        // 保存校验
                ValidatorUtil.require(categoryVO.getParent(), "parent-id");
                ValidatorUtil.require(categoryVO.getName(), "name");
                ValidatorUtil.length(categoryVO.getName(), "name", 1, 50);

        categoryService.save(categoryVO);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setContent(categoryVO);
        return responseVO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable String id) {
        categoryService.delete(id);
        ResponseVO responseVO = new ResponseVO();
        return responseVO;
    }
}
