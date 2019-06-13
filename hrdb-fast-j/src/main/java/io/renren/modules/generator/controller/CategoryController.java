package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.modules.generator.entity.OccupationEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.CategoryEntity;
import io.renren.modules.generator.service.CategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB; (`cat_parent_id`) REFER `hrdb/category`(`cat_id`) ON UPDAT
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:25
 */
@RestController
@RequestMapping("generator/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    @RequiresPermissions("generator:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:category:delete")
    public R delete(@RequestBody Long[] catIds){
		categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

//    @RequestMapping("/getTree")
//
//    public R getTree(){
//        List<CategoryEntity> root = categoryService.list(new QueryWrapper<CategoryEntity>().eq("cat_parent_id",0));
//
//        return R.ok().put("list",root);
//    }

//    public List<CategoryEntity> buildTree(List<CategoryEntity> root) {
//        for (CategoryEntity categoryEntity : root){
//            List<CategoryEntity> sons = categoryService.list(new QueryWrapper<CategoryEntity>().eq("cat_parent_id",categoryEntity.getCatId()));
//            buildTree(sons);
//            categoryEntity.setChildren(sons);
//
//        }
//        return root;
//
//    }


    @RequestMapping("/getTree")
    public R getTree(@RequestParam Map<String, Object> params){
        //PageUtils page = occupationService.queryPage(params);
        List<CategoryEntity> list = categoryService.list();

        return R.ok().put("list", list);
    }


}
