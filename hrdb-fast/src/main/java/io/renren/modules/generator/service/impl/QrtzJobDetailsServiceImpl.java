package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.QrtzJobDetailsDao;
import io.renren.modules.generator.entity.QrtzJobDetailsEntity;
import io.renren.modules.generator.service.QrtzJobDetailsService;


@Service("qrtzJobDetailsService")
public class QrtzJobDetailsServiceImpl extends ServiceImpl<QrtzJobDetailsDao, QrtzJobDetailsEntity> implements QrtzJobDetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzJobDetailsEntity> page = this.page(
                new Query<QrtzJobDetailsEntity>().getPage(params),
                new QueryWrapper<QrtzJobDetailsEntity>()
        );

        return new PageUtils(page);
    }

}