package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.entity.RecordEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ResumeEntity;
import io.renren.modules.generator.service.ResumeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@RestController
@RequestMapping("generator/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:resume:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = resumeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{resId}")
    @RequiresPermissions("generator:resume:info")
    public R info(@PathVariable("resId") Long resId){
		ResumeEntity resume = resumeService.getById(resId);

        return R.ok().put("resume", resume);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:resume:save")
    public R save(@RequestBody ResumeEntity resume){
		resumeService.save(resume);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:resume:update")
    public R update(@RequestBody ResumeEntity resume){
		resumeService.updateById(resume);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:resume:delete")
    public R delete(@RequestBody Long[] resIds){
		resumeService.removeByIds(Arrays.asList(resIds));

        return R.ok();
    }


    @RequestMapping("/resId")
    public R resId(@RequestParam Map<String, Object> params){
        //System.out.println("liujing");
        //PageUtils page = occupationService.queryPage(params);
        List<ResumeEntity> list = resumeService.list();

        return R.ok().put("list", list);
    }



}
