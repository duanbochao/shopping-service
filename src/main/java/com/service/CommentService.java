package com.service;

import com.bean.Comment;
import com.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/9 9:39
 */
@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public List<Comment> getCommentByPage(Integer page,Integer size,Integer nid,String commetType){
        Integer start=(page-1)*size;
        return commentMapper.getCommentByPage(start, size,nid,commetType);
    }


    public  Integer addComment(Comment cmt,Integer nid,String commetType){

        cmt.setCommetType(commetType);
        //1、先添加评论
        Integer a = commentMapper.addComment(cmt);
        //2、添加评论和信息的对应关系
        Integer b = commentMapper.addNewsComment(nid, cmt.getId(),commetType);
        if (a+b==2) return 1;
        return 0;
    }
}
