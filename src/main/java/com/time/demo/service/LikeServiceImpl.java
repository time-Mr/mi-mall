package com.time.demo.service;

import com.time.demo.entity.Like;
import com.time.demo.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 喜欢的商品逻辑实现
 *
 * @author time
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public int deleteByPrimaryKey(Integer likeId) {
        return likeMapper.deleteByPrimaryKey(likeId);
    }

    @Override
    public int insertSelective(Like like) {
        return likeMapper.insertSelective(like);
    }

    @Override
    public Like selectByPrimaryKey(Integer likeId) {
        return likeMapper.selectByPrimaryKey(likeId);
    }

    @Override
    public int updateByPrimaryKeySelective(Like like) {
        return likeMapper.updateByPrimaryKeySelective(like);
    }

    @Override
    public List<Like> selectByUserName(String userName) {
        return likeMapper.selectByUserName(userName);
    }

}