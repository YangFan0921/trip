package com.journey.trip.controller;

import com.journey.trip.entity.Product;
import com.journey.trip.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Value("${imageDirPath}")
    private String imageDirPath;

    @Autowired(required = false)
    ProductMapper productMapper;

    @RequestMapping("/send")
    public void insert(Product product, MultipartFile file){
        System.out.println("product = " + product + ", file = " + file);
        // 得到文件的原始名
        String fileName = file.getOriginalFilename();
        System.out.println("文件原始名："+fileName);
        // 得到文件的后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("后缀名："+suffix);
        // 得到唯一名
        fileName = UUID.randomUUID()+suffix;
        System.out.println("唯一名："+fileName);
        // D:/upload/2022/7/30/xxx.jpg
        // 得到日期相关的路径  /2022/7/30
        SimpleDateFormat f = new SimpleDateFormat("/yyyy/MM/dd/");
        // 创建表示当前时间的日期对象
        Date date = new Date();
        // 得到日期路径
        String datePath = f.format(date);
        System.out.println(datePath);
        String path = imageDirPath+datePath;
        System.out.println(path);
        File dirFile = new File(path);
        if ( !dirFile.exists() ){
            dirFile.mkdirs();
        }
        // 把文件保存到上面文件夹中
        try {
            file.transferTo(new File(path+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 把图片的路径添加到product对象中
        product.setUrl(datePath+fileName);
        // 设置时间为当前系统时间 date是上面创建的表示当前时间的对象
        product.setCreated(date);

        productMapper.insert(product);
    }

    @RequestMapping("/selectProduct")
    public List<Product> selectAll(){
        return productMapper.selectAll();
    }

    @RequestMapping("/viewlist")
    public List<Product> viewList(){
//        System.out.println("view: "+productMapper.viewList());
        return productMapper.viewList();
    }

    @RequestMapping("/likelist")
    public List<Product> likeList(){
        return productMapper.likeList();
    }

    @RequestMapping("/findbycid")
    public List<Product> findByCId(int id){
        return productMapper.findByCId(id);
    }

    @RequestMapping("/findbywd")
    public List<Product> findByWd(String wd){
        System.out.println(productMapper.findByWd(wd));
        return productMapper.findByWd(wd);
    }

    @RequestMapping("/selectbyid")
    public Product findById(int id){
        // 浏览量+1
        productMapper.viewById(id);
        return productMapper.findById(id);
    }

    @RequestMapping("/likebyid")
    public int likeById(int id, HttpSession session){
        // session保存时间改为24小时
        session.setMaxInactiveInterval(60*60*24);
        // 从session中取出曾经保存过的id
        String likeId = (String) session.getAttribute("like"+id);
        if (likeId == null){
            productMapper.likeById(id);
            session.setAttribute("like"+id,"like"+id);
            return 1; // 点赞了
        }
        return 2; // 之前点过了 不能再点了
    }

    @RequestMapping("/delete")
    public void delete(int id){
        Product product = productMapper.findById(id);
        String fileName = product.getUrl();
        System.out.println(fileName); // /2022/07/31/eae1984c-41bd-4a7b-a015-b350f4889211.jpg
        String filePath = imageDirPath+fileName;
        File file = new File(filePath);
        file.delete();
        productMapper.deleteById(id);
    }
}
