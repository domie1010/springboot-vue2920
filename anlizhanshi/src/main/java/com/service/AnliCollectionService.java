package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.AnliCollectionEntity;
import java.util.Map;

/**
 * 案例收藏 服务类
 */
public interface AnliCollectionService extends IService<AnliCollectionEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}