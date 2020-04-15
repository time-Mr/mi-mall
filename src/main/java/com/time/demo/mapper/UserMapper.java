package com.time.demo.mapper;

import com.time.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户底层接口
 *
 * @author time
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名删除
     *
     * @param userName 用户名
     * @return 是否成功
     */
    int deleteByUserName(String userName);

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return 是否成功
     */
    int insertSelective(User user);

    /**
     * 查找用户
     *
     * @param user 用户对象
     * @return 结果集
     */
    User selectUser(User user);

    /**
     * 根据主键查找
     *
     * @param userId 主键
     * @return 结果集
     */
    User selectByPrimaryKey(Integer userId);

    /**
     * 带条件查找并分页，模糊查询
     *
     * @param map 条件键值对
     * @return 结果集
     */
    List<User> selectAllUser(Map<String, Object> map);

    /**
     * 查找全部用户
     *
     * @return 结果集
     */
    List<User> selectAllUser();

    /**
     * 修改用户
     *
     * @param user 用户对象
     * @return 是否成功
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 查找用户总数
     *
     * @return 总数
     */
    int selectTotalCount();

}