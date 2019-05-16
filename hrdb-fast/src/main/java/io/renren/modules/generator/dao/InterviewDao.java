package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.InterviewEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 9216 kB; (`intw_resume_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:30
 */
@Mapper
public interface InterviewDao extends BaseMapper<InterviewEntity> {
	
}
