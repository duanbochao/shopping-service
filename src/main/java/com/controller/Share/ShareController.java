package com.controller.Share;

import com.bean.Share;
import com.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/getSharePagesByType")
    List<Share> getSharePagesByType(Integer page, String type){
        return shareService.getSharePagesByType(page, 5, type);
    }

}
