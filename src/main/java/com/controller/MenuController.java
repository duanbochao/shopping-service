package com.controller;

import com.bean.Menu;
import com.bean.RespBean;
import com.bean.Role;
import com.bean.User;
import com.service.MenuService;
import com.service.RoleService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/15 17:42
 */
@RestController
    @RequestMapping("/config")
public class MenuController {


    @Autowired
    MenuService menuService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/getMenusById")
    public List<Menu> getMenuById(){
        return menuService.getMenusById();
    }




    /**
     * 上传图片
     *
     * @return 返回值为图片的地址
     */

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
    public RespBean uploadImg(HttpServletRequest req, MultipartFile file) {
        StringBuffer url = new StringBuffer();
        String filePath = "D:\\nginx-1.14.2\\resources\\" + sdf.format(new Date());
        File imgFolder = new File(filePath);
        if (!imgFolder.exists()) {
            imgFolder.mkdirs();
        }
        url.append(req.getScheme())
                .append("://")
                .append(req.getServerName())
                .append(":")
                .append("80")
                .append("/"+sdf.format(new Date()));
        String imgName = UUID.randomUUID() + "_" + file.getOriginalFilename().replaceAll(" ", "");
        try {
            IOUtils.write(file.getBytes(), new FileOutputStream(new File(imgFolder, imgName)));
            url.append("/").append(imgName);

                return  RespBean.success(url.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  RespBean.error("上传失败!");
    }




    @RequestMapping("/getMenuTree/{rid}")
    public HashMap<String, Object> getMenuTree(@PathVariable Integer rid){
        List<Menu> menuTree = menuService.getMenuTree();
        List<Integer> mids = menuService.getMenuByRid(rid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("menuTree",menuTree);
        map.put("mids", mids);
        return map;
    }

    @RequestMapping("/updateMenuRoles")
    public RespBean updateMenuRoles(String mids,Integer rid){
        Integer i = roleService.updateMenuRoles(mids, rid);
        if (i>0){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping("/addRole")
    public Integer addRole(Role role){
        return roleService.addRole(role);
    }




}
