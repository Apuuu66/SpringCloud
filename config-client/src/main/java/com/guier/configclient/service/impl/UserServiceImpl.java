package com.guier.configclient.service.impl;

import com.guier.configclient.dao.UserRepository;
import com.guier.configclient.pojo.User;
import com.guier.configclient.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * @param page 当前页
     * @param size 页大小
     * @param user 查询参数
     * @return
     */
    @Override
    public List<User> page(Integer page, Integer size, User user) {
        List<Sort.Order> orderList = new ArrayList<>();
        orderList.add(new Sort.Order(Sort.Direction.DESC, "age"));
        orderList.add(new Sort.Order(Sort.Direction.ASC, "id"));

        Page<User> users = userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(user.getName())) {
                    Predicate name = criteriaBuilder.like(root.get("name").as(String.class), "%" + user.getName() + "%");
                    predicates.add(name);
                }
                // between and  <=  >=
                Predicate age = criteriaBuilder.between(root.get("age").as(Integer.class), 10, 15);
                predicates.add(age);
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        }, PageRequest.of(page - 1, size, Sort.by(orderList)));
        return users.getContent();
    }

    @Override
    @Transactional
    public void save() {
        User user = new User().setName("www").setAge(18);
        userRepository.save(user);
        System.out.println(1 / 0); //此处抛出异常，事务回滚，因此save不会生效
    }
}
