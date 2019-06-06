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
 * @date 2019-05-17 12:04:20
 */
@Data
@TableName("share")
public class ShareEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long shaId;
	/**
	 * 
	 */
	private Long shaSender;
	/**
	 * 
	 */
	private Long shaRecevier;
	/**
	 * 
	 */
	private Long shaReId;
	/**
	 * 
	 */
	private Date shaTime;
	/**
	 * 
	 */
	private String shaBz1;
	/**
	 * 
	 */
	private Long shaBz2;

	public Long getShaId() {
		return shaId;
	}

	public void setShaId(Long shaId) {
		this.shaId = shaId;
	}

	public Long getShaSender() {
		return shaSender;
	}

	public void setShaSender(Long shaSender) {
		this.shaSender = shaSender;
	}

	public Long getShaRecevier() {
		return shaRecevier;
	}

	public void setShaRecevier(Long shaRecevier) {
		this.shaRecevier = shaRecevier;
	}

	public Long getShaReId() {
		return shaReId;
	}

	public void setShaReId(Long shaReId) {
		this.shaReId = shaReId;
	}

	public Date getShaTime() {
		return shaTime;
	}

	public void setShaTime(Date shaTime) {
		this.shaTime = shaTime;
	}

	public String getShaBz1() {
		return shaBz1;
	}

	public void setShaBz1(String shaBz1) {
		this.shaBz1 = shaBz1;
	}

	public Long getShaBz2() {
		return shaBz2;
	}

	public void setShaBz2(Long shaBz2) {
		this.shaBz2 = shaBz2;
	}
}
