package com.example.news.controller.admin;

import com.example.news.utils.MyBlogUtils;
import com.example.news.utils.NewsConstants;
import com.example.news.utils.Result;
import com.example.news.utils.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/admin")
public class UploadController {
    /**
     * MultipartFile 接收上传的文件的类
     * @param httpServletRequest
     * @param file
     * @return
     * @throws URISyntaxException
     */
    @PostMapping({"/upload/file"})
    @ResponseBody
    public Result upload(HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws URISyntaxException {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //te.st.jpg
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
        String newFileName = tempName.toString();
        File fileDirectory = new File(NewsConstants.UPLOAD_PATH);
        //创建文件
        File destFile = new File(NewsConstants.UPLOAD_PATH + newFileName);
        try {
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
                }
            }
            //把上传的文件保存到指定目录
            file.transferTo(destFile);
            Result resultSuccess = ResultGenerator.genSuccessResult();
            // 上传图片成功后，返回访问这个图片的url地址，前端收到后，继续进行 文章的新增 http://localhost:18083
            resultSuccess.setData(MyBlogUtils.getHost(new URI(httpServletRequest.getRequestURL() + "")) + "/upload/" + newFileName);
            return resultSuccess;
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("文件上传失败");
        }
    }

}