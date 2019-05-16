package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.QrtzTriggersEntity;

import java.util.Map;

/**
 * InnoDB free: 9216 kB; (`SCHED_NAME` `JOB_NAME` `JOB_GROUP`) REFER `hrdb/qrtz_job
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:40
 */
public interface QrtzTriggersService extends IService<QrtzTriggersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

