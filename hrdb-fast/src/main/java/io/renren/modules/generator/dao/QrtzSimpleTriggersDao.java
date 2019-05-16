package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.QrtzSimpleTriggersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 9216 kB; (`SCHED_NAME` `TRIGGER_NAME` `TRIGGER_GROUP`) REFER `hrdb/
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:40
 */
@Mapper
public interface QrtzSimpleTriggersDao extends BaseMapper<QrtzSimpleTriggersEntity> {
	
}
