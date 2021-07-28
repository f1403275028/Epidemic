package com.example.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("疫情各地区以及各地区总人数")
public class Epidemic_Number {
    @ApiModelProperty("省份")
    public  String area;
    @ApiModelProperty("新增")
    private int addnum;
    @ApiModelProperty("总人数")
    private int total;
    @ApiModelProperty("治愈")
    private int cure;
    @ApiModelProperty("死亡")
    private int dead;

}
