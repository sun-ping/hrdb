package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.SysCaptchaEntity;

import java.util.Map;

/**
 * 系统验证码; InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:30
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

