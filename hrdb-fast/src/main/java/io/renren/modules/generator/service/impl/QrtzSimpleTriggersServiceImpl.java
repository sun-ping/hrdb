package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.QrtzSimpleTriggersDao;
import io.renren.modules.generator.entity.QrtzSimpleTriggersEntity;
import io.renren.modules.generator.service.QrtzSimpleTriggersService;


@Service("qrtzSimpleTriggersService")
public class QrtzSimpleTriggersServiceImpl extends ServiceImpl<QrtzSimpleTriggersDao, QrtzSimpleTriggersEntity> implements QrtzSimpleTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzSimpleTriggersEntity> page = this.page(
                new Query<QrtzSimpleTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzSimpleTriggersEntity>()
        );

        return new PageUtils(page);
    }

}