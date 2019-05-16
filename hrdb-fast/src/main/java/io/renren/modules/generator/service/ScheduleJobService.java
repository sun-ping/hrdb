package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ScheduleJobEntity;

import java.util.Map;

/**
 * 定时任务; InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:30
 */
public interface ScheduleJobService extends IService<ScheduleJobEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

