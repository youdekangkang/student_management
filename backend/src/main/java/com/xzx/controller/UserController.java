package com.xzx.controller;

import com.xzx.pojo.User;
import com.xzx.service.UserServiceImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    UserServiceImpl userService;

    @GetMapping
    public String toLoginJSP(){
//        System.out.println("ready to login.jsp");
        return "logIn";
    }

    @GetMapping("/login")
    public String login(User user, HttpSession session){
        User user1 = userService.findByName(user.getUsername());
        System.out.println("根据用户名找到用户"+user1);


        if(user1 != null && user1.getPassword().equals(user.getPassword())){

                System.out.println("登陆成功");
            session.setAttribute("username",user.getUsername());
            return "redirect:/user/space";
        }

        return "logIn";
    }

    @GetMapping("/space")
    public String toSpace(){
        return "userSpace";
    }
    @DeleteMapping
    public String logout(HttpSession session){
//        session.invalidate();
        session.removeAttribute("username");
        return "logIn";
    }


    //        ServletPath:/user/upload
//        String path=request.getServletPath();

    //        返回协议名称
//        Schema: http
//        System.out.println(request.getScheme());

//    private static final String PICTURE_BED="D:/xzx_workSpace/picture_Bed/userPic";

    @PostMapping("/space")
    public String uploadPic(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("接受上传图片");

        String name=file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(name);

        name=(String) request.getSession().getAttribute("username")+"."+extension;


        String realPath = request.getServletContext().getRealPath("/images");

        File destFileDir=new File(realPath);
        if(!destFileDir.exists())destFileDir.mkdir();

        File destFile=new File(destFileDir+"/"+name);
        file.transferTo(destFile);

        return "redirect:/user/space";
//        model.addAttribute("picPath",destFile.toString());
    }





//    1. 设置 response 响应头
//2. 读取文件 – InputStream
//3. 写出文件 – OutputStream
//4. 执行操作
//5. 关闭流 （先开后关）
    @RequestMapping("/download")
    public String downloadPic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName= (String) request.getSession().getAttribute("username")+".jpg";
        String path=request.getServletContext().getRealPath("/images");

        response.reset();
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path,fileName);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return null;
    }


}
