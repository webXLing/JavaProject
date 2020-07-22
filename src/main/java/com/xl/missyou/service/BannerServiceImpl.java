package com.xl.missyou.service;

import com.xl.missyou.model.Banner;
import com.xl.missyou.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepository;
    public Banner getByName(String name) {
        return bannerRepository.findOneByName(name);
    }
}
