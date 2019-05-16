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

import io.renren.modules.generator.entity.FuncnameEntity;
import io.renren.modules.generator.service.FuncnameService;
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
@RequestMapping("generator/funcname")
public class FuncnameController {
    @Autowired
    private FuncnameService funcnameService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:funcname:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = funcnameService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{funcId}")
    @RequiresPermissions("generator:funcname:info")
    public R info(@PathVariable("funcId") Integer funcId){
		FuncnameEntity funcname = funcnameService.getById(funcId);

        return R.ok().put("funcname", funcname);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:funcname:save")
    public R save(@RequestBody FuncnameEntity funcname){
		funcnameService.save(funcname);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:funcname:update")
    public R update(@RequestBody FuncnameEntity funcname){
		funcnameService.updateById(funcname);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:funcname:delete")
    public R delete(@RequestBody Integer[] funcIds){
		funcnameService.removeByIds(Arrays.asList(funcIds));

        return R.ok();
    }

}
