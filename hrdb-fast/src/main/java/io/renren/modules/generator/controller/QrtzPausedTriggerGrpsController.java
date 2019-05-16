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

import io.renren.modules.generator.entity.QrtzPausedTriggerGrpsEntity;
import io.renren.modules.generator.service.QrtzPausedTriggerGrpsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:40
 */
@RestController
@RequestMapping("generator/qrtzpausedtriggergrps")
public class QrtzPausedTriggerGrpsController {
    @Autowired
    private QrtzPausedTriggerGrpsService qrtzPausedTriggerGrpsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzpausedtriggergrps:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzPausedTriggerGrpsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzpausedtriggergrps:info")
    public R info(@PathVariable("schedName") String schedName){
		QrtzPausedTriggerGrpsEntity qrtzPausedTriggerGrps = qrtzPausedTriggerGrpsService.getById(schedName);

        return R.ok().put("qrtzPausedTriggerGrps", qrtzPausedTriggerGrps);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzpausedtriggergrps:save")
    public R save(@RequestBody QrtzPausedTriggerGrpsEntity qrtzPausedTriggerGrps){
		qrtzPausedTriggerGrpsService.save(qrtzPausedTriggerGrps);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzpausedtriggergrps:update")
    public R update(@RequestBody QrtzPausedTriggerGrpsEntity qrtzPausedTriggerGrps){
		qrtzPausedTriggerGrpsService.updateById(qrtzPausedTriggerGrps);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzpausedtriggergrps:delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzPausedTriggerGrpsService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
