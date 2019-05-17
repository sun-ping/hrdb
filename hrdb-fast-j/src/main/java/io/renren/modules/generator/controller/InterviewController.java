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

import io.renren.modules.generator.entity.InterviewEntity;
import io.renren.modules.generator.service.InterviewService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB; (`intw_resume_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@RestController
@RequestMapping("generator/interview")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:interview:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interviewService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{intwId}")
    @RequiresPermissions("generator:interview:info")
    public R info(@PathVariable("intwId") Long intwId){
		InterviewEntity interview = interviewService.getById(intwId);

        return R.ok().put("interview", interview);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:interview:save")
    public R save(@RequestBody InterviewEntity interview){
		interviewService.save(interview);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:interview:update")
    public R update(@RequestBody InterviewEntity interview){
		interviewService.updateById(interview);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:interview:delete")
    public R delete(@RequestBody Long[] intwIds){
		interviewService.removeByIds(Arrays.asList(intwIds));

        return R.ok();
    }

}
