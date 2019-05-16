package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.QrtzSimpropTriggersDao;
import io.renren.modules.generator.entity.QrtzSimpropTriggersEntity;
import io.renren.modules.generator.service.QrtzSimpropTriggersService;


@Service("qrtzSimpropTriggersService")
public class QrtzSimpropTriggersServiceImpl extends ServiceImpl<QrtzSimpropTriggersDao, QrtzSimpropTriggersEntity> implements QrtzSimpropTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzSimpropTriggersEntity> page = this.page(
                new Query<QrtzSimpropTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzSimpropTriggersEntity>()
        );

        return new PageUtils(page);
    }

}