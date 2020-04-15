package com.time.demo.service;

import com.time.demo.entity.Like;

import java.util.List;

/**
 * 用户喜欢的商品逻辑实现
 *
 * @author time
 */
public interface LikeService {

    /**
     * 根据主键删除
     *
     * @param likeId 主键
     * @return 是否成功
     */
    int deleteByPrimaryKey(Integer likeId);


    /**
     * 添加喜欢的商品
     *
     * @param like 商品对象
     * @return 是否成功
     */
    int insertSelective(Like like);

    /**
     * 根据主键删除
     *
     * @param likeId 主键
     * @return 是否成功
     */
    Like selectByPrimaryKey(Integer likeId);

    /**
     * 修改喜欢的商品
     *
     * @param like 商品对象
     * @return 是否成功
     */
    int updateByPrimaryKeySelective(Like like);

    /**
     * 查找该用户下所有喜欢的商品
     *
     * @param userName 用户名
     * @return 结果集
     */
    List<Like> selectByUserName(String userName);
}
