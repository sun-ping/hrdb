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

import io.renren.modules.generator.entity.QrtzJobDetailsEntity;
import io.renren.modules.generator.service.QrtzJobDetailsService;
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
@RequestMapping("generator/qrtzjobdetails")
public class QrtzJobDetailsController {
    @Autowired
    private QrtzJobDetailsService qrtzJobDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzjobdetails:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzJobDetailsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzjobdetails:info")
    public R info(@PathVariable("schedName") String schedName){
		QrtzJobDetailsEntity qrtzJobDetails = qrtzJobDetailsService.getById(schedName);

        return R.ok().put("qrtzJobDetails", qrtzJobDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzjobdetails:save")
    public R save(@RequestBody QrtzJobDetailsEntity qrtzJobDetails){
		qrtzJobDetailsService.save(qrtzJobDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzjobdetails:update")
    public R update(@RequestBody QrtzJobDetailsEntity qrtzJobDetails){
		qrtzJobDetailsService.updateById(qrtzJobDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzjobdetails:delete")
    public R delete(@RequestBody String[] schedNames){
		qrtzJobDetailsService.removeByIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
