package com.dao;

import com.entity.AnliCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.AnliCollectionView;

/**
 * 案例收藏 Dao 接口
 *
 * @author 
 */
public interface AnliCollectionDao extends BaseMapper<AnliCollectionEntity> {

   List<AnliCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
