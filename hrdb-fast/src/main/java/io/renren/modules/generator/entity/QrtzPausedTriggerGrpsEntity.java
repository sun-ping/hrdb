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
 * @date 2019-05-16 09:58:40
 */
@Data
@TableName("qrtz_paused_trigger_grps")
public class QrtzPausedTriggerGrpsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String schedName;
	/**
	 * 
	 */
	private String triggerGroup;

}
