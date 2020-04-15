package com.time.demo.mapper;

import com.time.demo.entity.Like;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 喜欢的商品底层接口
 *
 * @author time
 */
@Mapper
public interface LikeMapper {

    /**
     * 删除喜欢的商品
     *
     * @param likeId 主键
     * @return 是否成功
     */
    int deleteByPrimaryKey(Integer likeId);

    /**
     * 添加喜欢的商品
     *
     * @param like 商品对象
     * @return 结果集
     */
    int insertSelective(Like like);

    /**
     * 根据主键查找
     *
     * @param likeId 主键
     * @return 结果集
     */
    Like selectByPrimaryKey(Integer likeId);

    /**
     * 修改喜欢信息
     *
     * @param like 对象
     * @return 是否成功
     */
    int updateByPrimaryKeySelective(Like like);

    /**
     * 查找该用户下所有喜欢的商品
     *
     * @param username 用户名
     * @return 结果集
     */
    List<Like> selectByUserName(String username);
}