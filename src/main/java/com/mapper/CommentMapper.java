package com.mapper;

import com.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/9 9:30
 */
public interface CommentMapper {

   List<Comment> getCommentByPage(@Param("page") Integer start,@Param("size") Integer page,@Param("nid") Integer nid,@Param("commetType") String commetType);


   Integer getCommentCountByIdAndType(@Param("nid") Integer nid,@Param("commetType") String commetType);

   Integer addComment(Comment cmt);

   Integer addNewsComment(@Param("nid") Integer nid,@Param("cid")Integer cid,@Param("type")String type);

    List<Comment> getNewsCommentById();

    //删除评论公共表中的内容
    Integer deleteCommentByIds(@Param("ids") String[] ids);
}
