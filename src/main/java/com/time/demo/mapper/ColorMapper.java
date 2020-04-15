package com.time.demo.mapper;

import com.time.demo.entity.Color;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 颜色底层接口
 *
 * @author time
 */
@Mapper
public interface ColorMapper {

    /**
     * 批量添加
     *
     * @param colorList 颜色集合
     * @return 是否成功
     */
    int insertColorList(List<Color> colorList);

    /**
     * 批量修改
     *
     * @param confList 颜色集合
     * @return 是否成功
     */
    int updateColorList(List<Color> confList);

    /**
     * 批量删除
     *
     * @param productId 主键
     * @return 是否成功
     */
    int deleteColorList(Integer productId);
}