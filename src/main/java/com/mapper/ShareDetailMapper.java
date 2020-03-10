package com.mapper;

import com.bean.ShareDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/10 14:30
 */
public interface ShareDetailMapper {

    List<ShareDetail> getSharSurlBySid(@Param("sid") Integer sid);
}
