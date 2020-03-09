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

    public List<Comment> getCommentByPage(Integer page,Integer size){
        Integer start=(page-1)*size;
        return commentMapper.getCommentByPage(start, size);
    }

    public  Integer addComment(Comment cmt){
        return commentMapper.addComment(cmt);
    }
}
