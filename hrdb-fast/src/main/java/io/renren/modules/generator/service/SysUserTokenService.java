package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.SysUserTokenEntity;

import java.util.Map;

/**
 * 系统用户Token; InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:52:58
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

