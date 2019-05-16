package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.QrtzTriggersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 9216 kB; (`SCHED_NAME` `JOB_NAME` `JOB_GROUP`) REFER `hrdb/qrtz_job
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:40
 */
@Mapper
public interface QrtzTriggersDao extends BaseMapper<QrtzTriggersEntity> {
	
}
