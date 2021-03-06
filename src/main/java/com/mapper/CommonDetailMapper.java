package com.mapper;

import com.bean.CommonDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/10 14:30
 */
public interface CommonDetailMapper {

    List<CommonDetail> getSharSurlBySid(@Param("sid") Integer sid);
    List<CommonDetail> getGoodsListByGid(@Param("gid") Integer gid);
    Integer deleteDetailsById(@Param("id") Integer id);
    Integer addCommonDetail(CommonDetail cd); //添加后主键回填
    Integer addShareDetail(@Param("sid")Integer sid,@Param("did")Integer did);
}
