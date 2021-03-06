package com.controller.common;

import com.bean.Comment;
import com.bean.RespBean;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/9 9:44
 */
@RestController
@RequestMapping("/home/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * 加载评论内容
     * @param page
     * @return
     */

    @RequestMapping("/web/getCommentByPage")
    public RespBean getCommentByPage(Integer page,Integer nid,String commetType){
        List<Comment> commentList = commentService.getCommentByPage(page, 5,nid,commetType);

        if (commentList !=null  && commentList.size()>0){
            return RespBean.ok(commentList);
        }

        return RespBean.error("已经到底啦!");
    }


    /**
     * 添加评论内容
     * @param cmt
     * @return
     */

    @RequestMapping("/web/addComment")
    public RespBean addComment(Comment cmt,Integer nid,String commetType){

      if (commentService.addComment(cmt,nid,commetType)==1){
          return RespBean.ok("评论成功!");
      }
      return RespBean.error("评论失败!");
    }

}
