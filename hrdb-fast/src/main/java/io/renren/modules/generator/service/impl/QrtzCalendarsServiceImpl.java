package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.QrtzCalendarsDao;
import io.renren.modules.generator.entity.QrtzCalendarsEntity;
import io.renren.modules.generator.service.QrtzCalendarsService;


@Service("qrtzCalendarsService")
public class QrtzCalendarsServiceImpl extends ServiceImpl<QrtzCalendarsDao, QrtzCalendarsEntity> implements QrtzCalendarsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzCalendarsEntity> page = this.page(
                new Query<QrtzCalendarsEntity>().getPage(params),
                new QueryWrapper<QrtzCalendarsEntity>()
        );

        return new PageUtils(page);
    }

}