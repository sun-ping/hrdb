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

import io.renren.modules.generator.entity.QrtzCronTriggersEntity;
import io.renren.modules.generator.service.QrtzCronTriggersService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB; (`SCHED_NAME` `TRIGGER_NAME` `TRIGGER_GROUP`) REFER `hrdb/
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:40
 */
@RestController
@RequestMapping("generator/qrtzcrontriggers")
public class QrtzCronTriggersController {
    @Autowired
    private QrtzCronTriggersService qrtzCronTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzcrontriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzCronTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzcrontriggers:info")
    public R info(@PathVariable("schedName") String schedName){
		QrtzCronTriggersEntity qrtzCronTriggers = qrtzCronTriggersService.getById(schedName);

        return R.ok().put("qrtzCronTriggers", qrtzCronTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzcrontriggers:save")
    public R save(@RequestBody QrtzCronTriggersEntity qrtzCronTriggers){
		qrtzCronTriggersService.save(qrtzCronTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzcrontriggers:update")
    public R update(@RequestBody QrtzCronTriggersEntity qrtzCronTriggers){
		qrtzCronTriggersService.updateById(qrtzCronTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzcrontriggers:delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzCronTriggersService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
