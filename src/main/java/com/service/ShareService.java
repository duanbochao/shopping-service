package com.service;

import com.bean.Share;
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

  public  List<Share> getSharePagesByType(Integer page,Integer size,String type){
        Integer start=(page-1)*size;
        return shareMapper.getSharePagesByType(start, size, type);
    }

}
