package com.journey.trip.mapper;

import com.journey.trip.entity.Banner;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BannerMapper {
    @Select("select id,url from banner")
    List<Banner> selectAll();

    @Select("select url from banner where id=#{id}")
    String findUrlById(int id);

    @Delete("delete from banner where id=#{id}")
    void deleteById(int id);

    @Insert("insert into banner values(null,#{url})")
    void insert(Banner banner);
}
