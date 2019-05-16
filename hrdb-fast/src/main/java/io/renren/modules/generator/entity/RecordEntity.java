package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * InnoDB free: 9216 kB; (`rec_r_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE NO AC
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-16 09:58:30
 */
@Data
@TableName("record")
public class RecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 面试记录ID
	 */
	@TableId
	private Long recId;
	/**
	 * 简历ID
	 */
	private Long recRId;
	/**
	 * HR_ID
	 */
	private Long recHrId;
	/**
	 * 沟通能力
	 */
	private Long recCommunicate;
	/**
	 * 技能水平
	 */
	private Long recSkill;
	/**
	 * 学习能力
	 */
	private String recStudy;
	/**
	 * 情商
	 */
	private String recEq;
	/**
	 * 面试印象
	 */
	private String recImpression;
	/**
	 * 操作时间
	 */
	private Date recTime;
	/**
	 * 备注1
	 */
	private String recBz1;
	/**
	 * 备注2
	 */
	private Long recBz2;

}
