package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ProductEntity;
import io.renren.modules.generator.service.ProductService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:30
 */
@RestController
@RequestMapping("generator/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:product:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{pid}")
    @RequiresPermissions("generator:product:info")
    public R info(@PathVariable("pid") String pid){
		ProductEntity product = productService.getById(pid);

        return R.ok().put("product", product);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:product:save")
    public R save(@RequestBody ProductEntity product){
		productService.save(product);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:product:update")
    public R update(@RequestBody ProductEntity product){
		productService.updateById(product);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:product:delete")
    public R delete(@RequestBody String[] pids){
		productService.removeByIds(Arrays.asList(pids));

        return R.ok();
    }

}
