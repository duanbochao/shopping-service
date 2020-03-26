package com.mapper;

import com.bean.Share;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/10 10:16
 */
public interface ShareMapper {

    List<Share> getSharePagesByType(@Param("start") Integer start,@Param("size") Integer size,@Param("type") String type);

    void addCount(@Param("id") Integer id);

    //统计总数目
    Integer getShareCount(@Param("type") String type);

    Integer addShare(Share share);

    Integer deleteShareByIds(@Param("ids") String[] ids);

    Integer updateShare(Share share);
}
