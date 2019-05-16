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

import io.renren.modules.generator.entity.QrtzSimpleTriggersEntity;
import io.renren.modules.generator.service.QrtzSimpleTriggersService;
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
@RequestMapping("generator/qrtzsimpletriggers")
public class QrtzSimpleTriggersController {
    @Autowired
    private QrtzSimpleTriggersService qrtzSimpleTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzsimpletriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzSimpleTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzsimpletriggers:info")
    public R info(@PathVariable("schedName") String schedName){
		QrtzSimpleTriggersEntity qrtzSimpleTriggers = qrtzSimpleTriggersService.getById(schedName);

        return R.ok().put("qrtzSimpleTriggers", qrtzSimpleTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzsimpletriggers:save")
    public R save(@RequestBody QrtzSimpleTriggersEntity qrtzSimpleTriggers){
		qrtzSimpleTriggersService.save(qrtzSimpleTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzsimpletriggers:update")
    public R update(@RequestBody QrtzSimpleTriggersEntity qrtzSimpleTriggers){
		qrtzSimpleTriggersService.updateById(qrtzSimpleTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzsimpletriggers:delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzSimpleTriggersService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
