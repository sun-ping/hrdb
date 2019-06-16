package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.entity.CategoryEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.RecordEntity;
import io.renren.modules.generator.service.RecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB; (`rec_r_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE NO AC
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@RestController
@RequestMapping("generator/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:record:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = recordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recId}")
    @RequiresPermissions("generator:record:info")
    public R info(@PathVariable("recId") Long recId){
		RecordEntity record = recordService.getById(recId);

        return R.ok().put("record", record);
    }

    /**
     * 面试预约信息
     */
    @RequestMapping("/listRecord/{recRId}")
    @RequiresPermissions("generator:record:listRecord")
    public R listRecord(@PathVariable("recRId") int recRId){
        System.out.println("面试预约recRId为"+recRId);
        System.out.println("recRId="+recRId);
        List<RecordEntity> page = recordService.getByrecRId(recRId);

        return R.ok().put("page", page);
    }



    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:record:save")
    public R save(@RequestBody RecordEntity record){
		recordService.save(record);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:record:update")
    public R update(@RequestBody RecordEntity record){
		recordService.updateById(record);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:record:delete")
    public R delete(@RequestBody Long[] recIds){
		recordService.removeByIds(Arrays.asList(recIds));

        return R.ok();
    }




}
