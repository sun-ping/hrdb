package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.QrtzSchedulerStateDao;
import io.renren.modules.generator.entity.QrtzSchedulerStateEntity;
import io.renren.modules.generator.service.QrtzSchedulerStateService;


@Service("qrtzSchedulerStateService")
public class QrtzSchedulerStateServiceImpl extends ServiceImpl<QrtzSchedulerStateDao, QrtzSchedulerStateEntity> implements QrtzSchedulerStateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzSchedulerStateEntity> page = this.page(
                new Query<QrtzSchedulerStateEntity>().getPage(params),
                new QueryWrapper<QrtzSchedulerStateEntity>()
        );

        return new PageUtils(page);
    }

}