package com.entity.view;

import com.entity.AnliCollectionEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 案例收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("anli_collection")
public class AnliCollectionView extends AnliCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 anli
			/**
			* 制作人
			*/
			private Integer yonghuId;
			/**
			* 案例名称
			*/
			private String anliName;
			/**
			* 制作主题
			*/
			private Integer anliZhutiTypes;
				/**
				* 制作主题的值
				*/
				private String anliZhutiValue;
			/**
			* 制作方法
			*/
			private Integer anliTypes;
				/**
				* 制作方法的值
				*/
				private String anliValue;
			/**
			* 案例形式
			*/
			private String anliXingshi;
			/**
			* 案例缩略图
			*/
			private String anliPhoto;
			/**
			* 案例文件
			*/
			private String anliFile;
			/**
			* 案例介绍
			*/
			private String anliContent;

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

	public AnliCollectionView() {

	}

	public AnliCollectionView(AnliCollectionEntity anliCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, anliCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set anli
					/**
					* 获取： 制作人
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 制作人
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 案例名称
					*/
					public String getAnliName() {
						return anliName;
					}
					/**
					* 设置： 案例名称
					*/
					public void setAnliName(String anliName) {
						this.anliName = anliName;
					}
					/**
					* 获取： 制作主题
					*/
					public Integer getAnliZhutiTypes() {
						return anliZhutiTypes;
					}
					/**
					* 设置： 制作主题
					*/
					public void setAnliZhutiTypes(Integer anliZhutiTypes) {
						this.anliZhutiTypes = anliZhutiTypes;
					}


						/**
						* 获取： 制作主题的值
						*/
						public String getAnliZhutiValue() {
							return anliZhutiValue;
						}
						/**
						* 设置： 制作主题的值
						*/
						public void setAnliZhutiValue(String anliZhutiValue) {
							this.anliZhutiValue = anliZhutiValue;
						}
					/**
					* 获取： 制作方法
					*/
					public Integer getAnliTypes() {
						return anliTypes;
					}
					/**
					* 设置： 制作方法
					*/
					public void setAnliTypes(Integer anliTypes) {
						this.anliTypes = anliTypes;
					}


						/**
						* 获取： 制作方法的值
						*/
						public String getAnliValue() {
							return anliValue;
						}
						/**
						* 设置： 制作方法的值
						*/
						public void setAnliValue(String anliValue) {
							this.anliValue = anliValue;
						}
					/**
					* 获取： 案例形式
					*/
					public String getAnliXingshi() {
						return anliXingshi;
					}
					/**
					* 设置： 案例形式
					*/
					public void setAnliXingshi(String anliXingshi) {
						this.anliXingshi = anliXingshi;
					}
					/**
					* 获取： 案例缩略图
					*/
					public String getAnliPhoto() {
						return anliPhoto;
					}
					/**
					* 设置： 案例缩略图
					*/
					public void setAnliPhoto(String anliPhoto) {
						this.anliPhoto = anliPhoto;
					}
					/**
					* 获取： 案例文件
					*/
					public String getAnliFile() {
						return anliFile;
					}
					/**
					* 设置： 案例文件
					*/
					public void setAnliFile(String anliFile) {
						this.anliFile = anliFile;
					}
					/**
					* 获取： 案例介绍
					*/
					public String getAnliContent() {
						return anliContent;
					}
					/**
					* 设置： 案例介绍
					*/
					public void setAnliContent(String anliContent) {
						this.anliContent = anliContent;
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
