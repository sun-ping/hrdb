package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * InnoDB free: 9216 kB; (`intw_resume_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:30
 */
@Data
@TableName("interview")
public class InterviewEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 面试ID
	 */
	@TableId
	private Long intwId;
	/**
	 * 简历ID
	 */
	private Long intwResumeId;
	/**
	 * 应聘者姓名
	 */
	private String intwName;
	/**
	 * 应聘者电话
	 */
	private String intwMobile;
	/**
	 * 预约时间
	 */
	private String intwBookTime;
	/**
	 * 预约人
	 */
	private Long intwHrId;
	/**
	 * 当前状态
	 */
	private Long intwState;
	/**
	 * 操作时间
	 */
	private Date intwTime;
	/**
	 * 备注1
	 */
	private String intwBz1;
	/**
	 * 备注2
	 */
	private Long intwBz2;

}
