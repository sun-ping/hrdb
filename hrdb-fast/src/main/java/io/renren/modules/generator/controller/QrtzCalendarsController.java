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

import io.renren.modules.generator.entity.QrtzCalendarsEntity;
import io.renren.modules.generator.service.QrtzCalendarsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:49
 */
@RestController
@RequestMapping("generator/qrtzcalendars")
public class QrtzCalendarsController {
    @Autowired
    private QrtzCalendarsService qrtzCalendarsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzcalendars:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzCalendarsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzcalendars:info")
    public R info(@PathVariable("schedName") String schedName){
		QrtzCalendarsEntity qrtzCalendars = qrtzCalendarsService.getById(schedName);

        return R.ok().put("qrtzCalendars", qrtzCalendars);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzcalendars:save")
    public R save(@RequestBody QrtzCalendarsEntity qrtzCalendars){
		qrtzCalendarsService.save(qrtzCalendars);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzcalendars:update")
    public R update(@RequestBody QrtzCalendarsEntity qrtzCalendars){
		qrtzCalendarsService.updateById(qrtzCalendars);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzcalendars:delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzCalendarsService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
