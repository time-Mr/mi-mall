package com.time.demo.mapper;

import com.time.demo.entity.Conf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 配置底层接口
 *
 * @author time
 */
@Mapper
public interface ConfMapper {

    /**
     * 批量添加
     *
     * @param confList 配置对象
     * @return 是否成功
     */
    int insertConfList(List<Conf> confList);

    /**
     * 批量修改
     *
     * @param confList 配置对象
     * @return 是否成功
     */
    int updateConfList(List<Conf> confList);

    /**
     * 批量删除
     *
     * @param productId 主键
     * @return 是否成功
     */
    int deleteConfList(Integer productId);
}