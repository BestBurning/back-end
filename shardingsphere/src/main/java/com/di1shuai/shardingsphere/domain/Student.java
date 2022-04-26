package com.di1shuai.shardingsphere.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;


/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@ToString
public class Student  {

	@TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	private String name;
	@TableField("is_admin")
	private boolean isAdmin;
	private Integer version;

}
