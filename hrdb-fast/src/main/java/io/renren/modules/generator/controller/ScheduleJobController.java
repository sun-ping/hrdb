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

import io.renren.modules.generator.entity.ScheduleJobEntity;
import io.renren.modules.generator.service.ScheduleJobService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 定时任务; InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:30
 */
@RestController
@RequestMapping("generator/schedulejob")
public class ScheduleJobController {
    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:schedulejob:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = scheduleJobService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{jobId}")
    @RequiresPermissions("generator:schedulejob:info")
    public R info(@PathVariable("jobId") Long jobId){
		ScheduleJobEntity scheduleJob = scheduleJobService.getById(jobId);

        return R.ok().put("scheduleJob", scheduleJob);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:schedulejob:save")
    public R save(@RequestBody ScheduleJobEntity scheduleJob){
		scheduleJobService.save(scheduleJob);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:schedulejob:update")
    public R update(@RequestBody ScheduleJobEntity scheduleJob){
		scheduleJobService.updateById(scheduleJob);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:schedulejob:delete")
    public R delete(@RequestBody Long[] jobIds){
		scheduleJobService.removeByIds(Arrays.asList(jobIds));

        return R.ok();
    }

}
