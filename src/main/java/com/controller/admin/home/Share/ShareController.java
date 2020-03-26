package com.controller.admin.home.Share;

import com.bean.RespBean;
import com.bean.Share;
import com.bean.CommonDetail;
import com.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/10 10:25
 */
@RestController
@RequestMapping("/home/share")
public class ShareController {

    @Autowired
    ShareService shareService;



    /**
     * 获取图片信息
     * @param page
     * @param size
     * @param type
     * @return
     */
    @RequestMapping("/web/getSharePagesByType")

   public  HashMap<String, Object> getSharePagesByType(Integer page, String type, @RequestParam(defaultValue = "5",value = "size", required = false)Integer size){
        List<Share> shareList = shareService.getSharePagesByType(page, size, type);
        Integer total = shareService.getShareCount(type);
        HashMap<String, Object> map = new HashMap<>();
        map.put("shareList",shareList );
        map.put("total", total);
        return map;
    }


    /**
     * 获取缩略图
     * @param sid
     * @return
     */
    @RequestMapping("/web/getImage")
    List<CommonDetail> getSharSurlBySid(Integer sid){
        return shareService.getSharSurlBySid(sid);
    }


    //删除详情图片
    @RequestMapping("/deleteDetailsById")
    public Integer deleteDetailsById(Integer sid){
        return shareService.deleteDetailsById(sid);
    }

    @RequestMapping("/addShareSubImageToDetail")
    public RespBean addShareSubImageToDetail(CommonDetail cd,Integer sid){
        cd.setEnabled(true);
        Integer integer = shareService.addShareSubImageToDetail(cd, sid);
        if (integer>0){
            return RespBean.ok(cd);
        }
        return  RespBean.error(cd);
    }

    @RequestMapping("/deleteShareByIds")
    public Integer deleteShareByIds(String ids){
        return shareService.deleteShareByIds(ids);
    }

    @RequestMapping("/addShare")
    public RespBean addShare(Share share ){
        Integer i = shareService.addShare(share);
        if (i>0){
            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败!");
    }


    @RequestMapping("/updateShare")
    public RespBean updateShare(Share share){
        Integer integer = shareService.updateShare(share);
        if (integer>0){
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");

    }
}



