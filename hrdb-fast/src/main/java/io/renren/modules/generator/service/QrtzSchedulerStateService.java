package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.QrtzSchedulerStateEntity;

import java.util.Map;

/**
 * InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:40
 */
public interface QrtzSchedulerStateService extends IService<QrtzSchedulerStateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

