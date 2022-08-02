package com.journey.trip.controller;

import com.journey.trip.entity.Category;
import com.journey.trip.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired(required = false)
    CategoryMapper categoryMapper;

    @RequestMapping("selectCategory")
    public List<Category> selectcategory(){
        return categoryMapper.selectAll();
    }
}
