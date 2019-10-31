package com.example.demo.service;

import com.example.demo.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface AyUserService {
    AyUser findById(Long id);
    List<AyUser> findAll();
    AyUser save(AyUser ayUser);
    void delete(Long id);

//    分页
    Page<AyUser> findAll(Pageable pageable);

    List<AyUser> findByName(String name);
    List<AyUser> findByNameLike(String name);
    List<AyUser> findByIdIn(Collection<Long> ids);
}
