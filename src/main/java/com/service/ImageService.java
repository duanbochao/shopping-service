package com.service;

import com.bean.Rotation;
import com.mapper.RotationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/8 11:11
 */
@Service
@Transactional
public class ImageService {

    @Autowired
    RotationMapper rotationMapper;

    public List<Rotation> getAllRotation(){
        return rotationMapper.getAllRotation();
    }
}
