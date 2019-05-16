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

import io.renren.modules.generator.entity.QrtzSimpropTriggersEntity;
import io.renren.modules.generator.service.QrtzSimpropTriggersService;
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
@RequestMapping("generator/qrtzsimproptriggers")
public class QrtzSimpropTriggersController {
    @Autowired
    private QrtzSimpropTriggersService qrtzSimpropTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzsimproptriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzSimpropTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzsimproptriggers:info")
    public R info(@PathVariable("schedName") String schedName){
		QrtzSimpropTriggersEntity qrtzSimpropTriggers = qrtzSimpropTriggersService.getById(schedName);

        return R.ok().put("qrtzSimpropTriggers", qrtzSimpropTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzsimproptriggers:save")
    public R save(@RequestBody QrtzSimpropTriggersEntity qrtzSimpropTriggers){
		qrtzSimpropTriggersService.save(qrtzSimpropTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzsimproptriggers:update")
    public R update(@RequestBody QrtzSimpropTriggersEntity qrtzSimpropTriggers){
		qrtzSimpropTriggersService.updateById(qrtzSimpropTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzsimproptriggers:delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzSimpropTriggersService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
