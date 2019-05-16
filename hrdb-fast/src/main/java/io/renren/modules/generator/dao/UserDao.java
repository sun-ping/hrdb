package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户; InnoDB free: 9216 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:52:58
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
