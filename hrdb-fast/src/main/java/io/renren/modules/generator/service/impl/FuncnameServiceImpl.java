package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.FuncnameDao;
import io.renren.modules.generator.entity.FuncnameEntity;
import io.renren.modules.generator.service.FuncnameService;


@Service("funcnameService")
public class FuncnameServiceImpl extends ServiceImpl<FuncnameDao, FuncnameEntity> implements FuncnameService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FuncnameEntity> page = this.page(
                new Query<FuncnameEntity>().getPage(params),
                new QueryWrapper<FuncnameEntity>()
        );

        return new PageUtils(page);
    }

}