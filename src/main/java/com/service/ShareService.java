package com.service;

import com.bean.Share;
import com.bean.CommonDetail;
import com.mapper.CommonDetailMapper;
import com.mapper.ShareMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/10 10:23
 */
@Service
@Transactional
public class ShareService {

    @Autowired
    ShareMapper shareMapper;

    @Autowired
    CommonDetailMapper commonDetailMapper;



  public  List<Share> getSharePagesByType(Integer page,Integer size,String type){
        Integer start=(page-1)*size;
        return shareMapper.getSharePagesByType(start, size, type);
    }


  public  List<CommonDetail> getSharSurlBySid(Integer sid){
         //统计次数
         shareMapper.addCount(sid);
        return commonDetailMapper.getSharSurlBySid(sid);
    }

    //获取总条目
    public  Integer getShareCount(String type){
        return shareMapper.getShareCount(type);
    }


    //删除详情图片的id
    public Integer deleteDetailsById(Integer id){
        return commonDetailMapper.deleteDetailsById(id);
    }

    public Integer addShareSubImageToDetail(CommonDetail cd,Integer sid){
        commonDetailMapper.addCommonDetail(cd); //添加依赖关系
        return  commonDetailMapper.addShareDetail(sid,cd.getId());//添加详情表
    }


    public Integer addShare(Share share){
          share.setEnabled(true);
        return shareMapper.addShare(share);
    }

    public Integer deleteShareByIds(String ids){
        String[] split = ids.split(",");
        return shareMapper.deleteShareByIds(split);
    }

    public Integer updateShare(Share share){
        return shareMapper.updateShare(share);
    }
}
