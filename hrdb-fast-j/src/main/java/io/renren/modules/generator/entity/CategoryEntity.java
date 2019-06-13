package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * InnoDB free: 9216 kB; (`cat_parent_id`) REFER `hrdb/category`(`cat_id`) ON UPDAT
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:25
 */
@Data
@TableName("category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 类别ID
	 */
	@TableId
	private Long catId;
	/**
	 * 父类别ID
	 */
	private Long catParentId;
	/**
	 * 职位名称
	 */
	private String catName;
	/**
	 * 备注1
	 */
	private String catBz1;
	/**
	 * 备注2
	 */
	private Long catBz2;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public Long getCatParentId() {
		return catParentId;
	}

	public void setCatParentId(Long catParentId) {
		this.catParentId = catParentId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatBz1() {
		return catBz1;
	}

	public void setCatBz1(String catBz1) {
		this.catBz1 = catBz1;
	}

	public Long getCatBz2() {
		return catBz2;
	}

	public void setCatBz2(Long catBz2) {
		this.catBz2 = catBz2;
	}

	public List<CategoryEntity> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryEntity> children) {
		this.children = children;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@TableField(exist = false)
	private List<CategoryEntity> children;

	@TableField(exist = false)
	private String parentName;

}
