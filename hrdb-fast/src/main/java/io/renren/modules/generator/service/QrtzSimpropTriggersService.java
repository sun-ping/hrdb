package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.QrtzSimpropTriggersEntity;

import java.util.Map;

/**
 * InnoDB free: 9216 kB; (`SCHED_NAME` `TRIGGER_NAME` `TRIGGER_GROUP`) REFER `hrdb/
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:40
 */
public interface QrtzSimpropTriggersService extends IService<QrtzSimpropTriggersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

