package com.example.service;

import com.example.dao.Epidemic_NumberMapper;
import com.example.pojo.Epidemic_Number;
import com.example.pojo.NewAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zenglin.Fang
 * @ClassName Epidemic_NumberServiceImpl
 * @Description:
 * @Data: 2021/2/23 14:45
 **/
@Service
public class Epidemic_NumberServiceImpl implements Epidemic_NumberService{

    @Autowired
    private Epidemic_NumberMapper epidemic_numberMapper;

    @Override
    /**查询所有地区人数*/
    public List<Epidemic_Number> queryNumList(){
        return epidemic_numberMapper.queryNumList();
    }

    @Override
    /**根据省份查人数*/
    public Epidemic_Number queryNumListByArea(String area){
        return epidemic_numberMapper.queryNumListByArea(area);
    }

    @Override
    /**根据省份修改人数*/
    public int updateNum(Epidemic_Number epidemic_number){
        return  epidemic_numberMapper.updateNum(epidemic_number);
    }

    @Override
    /**增加省份*/
    public int addNum(Epidemic_Number epidemic_number){
        return epidemic_numberMapper.addNum(epidemic_number);
    }

    @Override
    /**根据省份删除*/
    public int deleteNumByArea(String area){
        return epidemic_numberMapper.deleteNumByArea(area);
    }

    @Override
    /**删除今日没有新增的省份*/
    public int deletenewByArea(String area){
        return epidemic_numberMapper.deletenewByArea(area);
    }

    @Override
    /**添加今日有新增的省份*/
    public int addNew(NewAdd newAdd){
        return epidemic_numberMapper.addNew(newAdd);
    }

    @Override
    /**查看今日有新增的省份*/
    public List<NewAdd> queryNewList(){
        return epidemic_numberMapper.queryNewList();
    }
}
