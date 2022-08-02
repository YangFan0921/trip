package com.journey.trip.mapper;

import com.journey.trip.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select id,name from category")
    List<Category> selectAll();
}
