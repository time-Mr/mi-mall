package com.time.demo.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import com.time.demo.entity.Order;
import com.time.demo.entity.ShoppingCard;
import com.time.demo.entity.User;
import com.time.demo.mapper.UserMapper;
import com.time.demo.util.JSONHelper;
import com.time.demo.util.RedisUtil;
import com.time.demo.util.RegularExpressionUtil;
import com.time.demo.util.VerdictUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 用户逻辑实现
 *
 * @author time
 */
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private RedisUtil redis;

    @Override
    public Object selectUser(User user) {
        User result = userMapper.selectUser(user);
        if (result != null) {
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public List<User> selectAllUser(Map<String, Object> map) {
        return userMapper.selectAllUser(map);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public int selectTotalCount() {
        return userMapper.selectTotalCount();
    }

    @Override
    public int insertSelective(User user) {
        if ((RegularExpressionUtil.parse(user.getUserName(),
                "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$"))
                || (RegularExpressionUtil.parse(user.getUserName(),
                "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$"))) {
            if (VerdictUtil.isNull(userMapper.selectUser(user))) {
                return userMapper.insertSelective(user);
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByUserName(String username) {
        userMapper.deleteByUserName(username);
        HashMap<String, Object> hashMap = new HashMap<>(1);
        hashMap.put("username", username);
        List<Order> orderList = orderService.selectByUserName(hashMap);
        orderList.forEach((order) -> orderService.deleteByPrimaryKey(order.getOrderId()));
        return 1;
    }

    @Override
    public int addShoppingCart(ShoppingCard shoppingcard) throws Exception {
        boolean flag = false;
        int maxShoppingId = 0;
        List<ShoppingCard> redisShoppingCard = getShoppingCarts(shoppingcard.getName());
        if (VerdictUtil.isNotNull(redisShoppingCard)) {
            for (ShoppingCard product : redisShoppingCard) {
                if (product.getProductName().equals(shoppingcard.getProductName())
                        && product.getPicture1().equals(shoppingcard.getPicture1())
                        && product.getColor().equals(shoppingcard.getColor())
                        && product.getConf().equals(shoppingcard.getConf())
                        && product.getVersion().equals(shoppingcard.getVersion())) {
                    product.setQuantity(product.getQuantity() + 1);
                    flag = true;
                }
                if (maxShoppingId < product.getShoppingCartId()) {
                    maxShoppingId = product.getShoppingCartId();
                }
            }
            if (!flag) {
                shoppingcard.setShoppingCartId(maxShoppingId + 1);
                redisShoppingCard.add(shoppingcard);
            }
        }
        for (ShoppingCard shoppingCard : redisShoppingCard) {
            redis.hPutAll(shoppingCard.getName() + shoppingCard.getProductName() + shoppingCard.getShoppingCartId(),
                    Convert.convert(new TypeReference<Map<String, String>>() {
                    }, RegularExpressionUtil.convertBean(shoppingCard)));
        }
        return 1;
    }

    public List<ShoppingCard> getShoppingCarts(String name) {
        List<ShoppingCard> list = new ArrayList<>();
        Set<String> keys = redis.keys(name);
        for (String key : keys) {
            Map<Object, Object> hGetAll = redis.hGetAll(key);
            JSONObject jsonMap = JSONObject.fromObject(hGetAll);
            list.add((ShoppingCard) JSONHelper.json2Object(jsonMap.toString(), ShoppingCard.class));
        }
        return list;
    }

    @Override
    public List<Object> getShoppingCart(String name) {
        List<Object> list = new ArrayList<>();
        redis.keys(name).forEach((key) -> list.add(redis.hGetAll(key)));
        return list;
    }

    @Override
    public int deleteShoppingCard(String key) {
        redis.delete(key);
        return 1;
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
