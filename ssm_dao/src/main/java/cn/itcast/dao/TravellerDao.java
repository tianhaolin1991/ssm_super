package cn.itcast.dao;

import cn.itcast.domain.Traveller;

import java.util.List;

public interface TravellerDao {

    Traveller findById(String id);

    List<Traveller> findByOrderId(String id);
}
