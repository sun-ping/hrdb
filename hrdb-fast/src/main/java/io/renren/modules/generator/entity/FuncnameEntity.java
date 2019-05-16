package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * InnoDB free: 9216 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:30
 */
@Data
@TableName("funcname")
public class FuncnameEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer funcId;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private String funcName;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private String column2;
	/**
	 * 
	 */
	private String column3;

}
