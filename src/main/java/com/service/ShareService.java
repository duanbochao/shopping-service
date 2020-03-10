package com.service;

import com.bean.Share;
import com.bean.ShareDetail;
import com.mapper.ShareDetailMapper;
import com.mapper.ShareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/10 10:23
 */
@Service
public class ShareService {

    @Autowired
    ShareMapper shareMapper;

    @Autowired
    ShareDetailMapper shareDetailMapper;

  public  List<Share> getSharePagesByType(Integer page,Integer size,String type){
        Integer start=(page-1)*size;
        return shareMapper.getSharePagesByType(start, size, type);
    }


  public  List<ShareDetail> getSharSurlBySid(Integer sid){
         //统计次数
         shareMapper.addCount(sid);
        return shareDetailMapper.getSharSurlBySid(sid);
    }


}
