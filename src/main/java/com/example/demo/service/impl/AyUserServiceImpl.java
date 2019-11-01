package com.example.demo.service.impl;

import com.example.demo.model.AyUser;
import com.example.demo.repository.AyUserRepository;
import com.example.demo.service.AyUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class AyUserServiceImpl implements AyUserService  {
    @Resource(name = "ayUserRepository")
    private AyUserRepository ayUserRepository;

    @Override
    public AyUser findById(Long id){
        return ayUserRepository.findById(id).get();
    }

    @Override
    public List<AyUser> findAll() {
        return ayUserRepository.findAll();
    }

    @Transactional
    @Override
    public AyUser save(AyUser ayUser) {
        AyUser saveUser = ayUserRepository.save(ayUser);

//        出现空指针异常
//        String error = null;
//        error.split("/");
        return saveUser;
    }

    @Override
    public void delete(Long id) { ayUserRepository.deleteById(id);
    }

    @Override
    public Page<AyUser> findAll(Pageable pageable) {
        return ayUserRepository.findAll(pageable);
    }

    @Override
    public List<AyUser> findByName(String name) {
        return ayUserRepository.findByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name) {
        return ayUserRepository.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<Long> ids) {
        return ayUserRepository.findByIdIn(ids);
    }


//    @Override
//    public List<AyUser> findByIdIn(Collection<Long> ids) {
//        return null;
//    }

}
