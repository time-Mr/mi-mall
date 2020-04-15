package com.time.demo.mapper;

import com.time.demo.entity.Meal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 套餐底层接口
 *
 * @author time
 */
@Mapper
public interface MealMapper {

    /**
     * 批量添加
     *
     * @param mealList 套餐集合
     * @return 结果集
     */
    int insertMealList(List<Meal> mealList);

    /**
     * 批量修改
     *
     * @param confList 套餐集合
     * @return 结果集
     */
    int updateMealList(List<Meal> confList);

    /**
     * 批量删除
     *
     * @param productId 主键
     * @return 结果集
     */
    int deleteMealList(Integer productId);
}