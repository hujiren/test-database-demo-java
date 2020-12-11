package com.apl.ignite.demo.service;
import com.apl.ignite.demo.entity.PriceZoneNameVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author hjr start
 * @date 2020/6/16 - 10:35
 */
public interface IgniteService extends IService<PriceZoneNameVo> {

    void queryStu(Long num);

    Integer updateStu(Long num);

    Integer insertStu();

    Integer deleteStu(Integer id);

    void add(PriceZoneNameVo priceZoneNameVo);
}
