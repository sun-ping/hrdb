package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.SysUserRoleEntity;

import java.util.Map;

/**
 * 用户与角色对应关系; InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:52:58
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

