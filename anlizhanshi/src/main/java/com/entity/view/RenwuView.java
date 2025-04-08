package com.entity.view;

import com.entity.RenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("renwu")
public class RenwuView extends RenwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 任务类型的值
		*/
		private String renwuValue;



		//级联表 yonghu
			/**
			* 编号
			*/
			private String yonghuNumber;
			/**
			* 姓名
			*/
			private String yonghuName;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 照片
			*/
			private String yuangongPhoto;
			/**
			* 学院
			*/
			private Integer xueyuanTypes;
				/**
				* 学院的值
				*/
				private String xueyuanValue;
			/**
			* 年级
			*/
			private Integer nianjiTypes;
				/**
				* 年级的值
				*/
				private String nianjiValue;
			/**
			* 权限
			*/
			private Integer roleTypes;
				/**
				* 权限的值
				*/
				private String roleValue;

	public RenwuView() {

	}

	public RenwuView(RenwuEntity renwuEntity) {
		try {
			BeanUtils.copyProperties(this, renwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 任务类型的值
			*/
			public String getRenwuValue() {
				return renwuValue;
			}
			/**
			* 设置： 任务类型的值
			*/
			public void setRenwuValue(String renwuValue) {
				this.renwuValue = renwuValue;
			}
















				//级联表的get和set yonghu
					/**
					* 获取： 编号
					*/
					public String getYonghuNumber() {
						return yonghuNumber;
					}
					/**
					* 设置： 编号
					*/
					public void setYonghuNumber(String yonghuNumber) {
						this.yonghuNumber = yonghuNumber;
					}
					/**
					* 获取： 姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 照片
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}
					/**
					* 获取： 学院
					*/
					public Integer getXueyuanTypes() {
						return xueyuanTypes;
					}
					/**
					* 设置： 学院
					*/
					public void setXueyuanTypes(Integer xueyuanTypes) {
						this.xueyuanTypes = xueyuanTypes;
					}


						/**
						* 获取： 学院的值
						*/
						public String getXueyuanValue() {
							return xueyuanValue;
						}
						/**
						* 设置： 学院的值
						*/
						public void setXueyuanValue(String xueyuanValue) {
							this.xueyuanValue = xueyuanValue;
						}
					/**
					* 获取： 年级
					*/
					public Integer getNianjiTypes() {
						return nianjiTypes;
					}
					/**
					* 设置： 年级
					*/
					public void setNianjiTypes(Integer nianjiTypes) {
						this.nianjiTypes = nianjiTypes;
					}


						/**
						* 获取： 年级的值
						*/
						public String getNianjiValue() {
							return nianjiValue;
						}
						/**
						* 设置： 年级的值
						*/
						public void setNianjiValue(String nianjiValue) {
							this.nianjiValue = nianjiValue;
						}
					/**
					* 获取： 权限
					*/
					public Integer getRoleTypes() {
						return roleTypes;
					}
					/**
					* 设置： 权限
					*/
					public void setRoleTypes(Integer roleTypes) {
						this.roleTypes = roleTypes;
					}


						/**
						* 获取： 权限的值
						*/
						public String getRoleValue() {
							return roleValue;
						}
						/**
						* 设置： 权限的值
						*/
						public void setRoleValue(String roleValue) {
							this.roleValue = roleValue;
						}


}
