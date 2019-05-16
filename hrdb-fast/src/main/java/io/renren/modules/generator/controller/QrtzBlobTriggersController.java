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

import io.renren.modules.generator.entity.QrtzBlobTriggersEntity;
import io.renren.modules.generator.service.QrtzBlobTriggersService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB; (`SCHED_NAME` `TRIGGER_NAME` `TRIGGER_GROUP`) REFER `hrdb/
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:49
 */
@RestController
@RequestMapping("generator/qrtzblobtriggers")
public class QrtzBlobTriggersController {
    @Autowired
    private QrtzBlobTriggersService qrtzBlobTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzblobtriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzBlobTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzblobtriggers:info")
    public R info(@PathVariable("schedName") String schedName){
		QrtzBlobTriggersEntity qrtzBlobTriggers = qrtzBlobTriggersService.getById(schedName);

        return R.ok().put("qrtzBlobTriggers", qrtzBlobTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzblobtriggers:save")
    public R save(@RequestBody QrtzBlobTriggersEntity qrtzBlobTriggers){
		qrtzBlobTriggersService.save(qrtzBlobTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzblobtriggers:update")
    public R update(@RequestBody QrtzBlobTriggersEntity qrtzBlobTriggers){
		qrtzBlobTriggersService.updateById(qrtzBlobTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzblobtriggers:delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzBlobTriggersService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
