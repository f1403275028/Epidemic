package com.example.dao;

import com.example.pojo.Epidemic_Number;
import com.example.pojo.NewAdd;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Epidemic_NumberMapper {

    /**查询所有地区人数*/
    List<Epidemic_Number> queryNumList();

    /**根据省份查人数*/
    Epidemic_Number queryNumListByArea(String area);

    /**根据省份修改人数*/
    int updateNum(Epidemic_Number epidemic_number);

    /**增加省份*/
    int addNum(Epidemic_Number epidemic_number);

    /**根据省份删除*/
    int deleteNumByArea(String area);


    /**删除今日没有新增的省份*/
    int deletenewByArea(String area);

    /**添加今日有新增的省份*/
    int addNew(NewAdd newAdd);

    /**查看今日有新增的省份*/
    List<NewAdd> queryNewList();

}
