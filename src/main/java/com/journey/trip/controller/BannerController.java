package com.journey.trip.controller;

import com.journey.trip.entity.Banner;
import com.journey.trip.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class BannerController {

    @Autowired(required = false)
    BannerMapper bannerMapper;
    @Value("${imageDirPath}")
    private String imageDirPath;

    @RequestMapping("/selectBanner")
    public List<Banner> selectbanner(){
        return bannerMapper.selectAll();
    }


    @RequestMapping("/deletebanner")
    public void deleteById(int id){
        String url = bannerMapper.findUrlById(id);
        String path = imageDirPath+url;
        System.out.println("path="+path);
        new File(path).delete();
        bannerMapper.deleteById(id);
    }

    @RequestMapping("/uploadbanner")
    public void upload(MultipartFile file){
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffix;
        System.out.println(fileName);
        String path = imageDirPath+"/"+fileName;

        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Banner banner = new Banner();
        banner.setUrl("/"+fileName);

        bannerMapper.insert(banner);
    }

}
