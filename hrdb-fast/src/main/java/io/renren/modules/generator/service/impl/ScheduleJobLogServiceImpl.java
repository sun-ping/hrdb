package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ScheduleJobLogDao;
import io.renren.modules.generator.entity.ScheduleJobLogEntity;
import io.renren.modules.generator.service.ScheduleJobLogService;


@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogDao, ScheduleJobLogEntity> implements ScheduleJobLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ScheduleJobLogEntity> page = this.page(
                new Query<ScheduleJobLogEntity>().getPage(params),
                new QueryWrapper<ScheduleJobLogEntity>()
        );

        return new PageUtils(page);
    }

}