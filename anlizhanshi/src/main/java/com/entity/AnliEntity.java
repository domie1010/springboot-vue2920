package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 案例
 *
 * @author 
 * @email
 */
@TableName("anli")
public class AnliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public AnliEntity() {

	}

	public AnliEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 制作人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 案例名称
     */
    @TableField(value = "anli_name")

    private String anliName;


    /**
     * 制作主题
     */
    @TableField(value = "anli_zhuti_types")

    private Integer anliZhutiTypes;


    /**
     * 制作方法
     */
    @TableField(value = "anli_types")

    private Integer anliTypes;


    /**
     * 案例形式
     */
    @TableField(value = "anli_xingshi")

    private String anliXingshi;


    /**
     * 案例缩略图
     */
    @TableField(value = "anli_photo")

    private String anliPhoto;


    /**
     * 案例文件
     */
    @TableField(value = "anli_file")

    private String anliFile;


    /**
     * 案例介绍
     */
    @TableField(value = "anli_content")

    private String anliContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：制作人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：制作人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：案例名称
	 */
    public String getAnliName() {
        return anliName;
    }


    /**
	 * 获取：案例名称
	 */

    public void setAnliName(String anliName) {
        this.anliName = anliName;
    }
    /**
	 * 设置：制作主题
	 */
    public Integer getAnliZhutiTypes() {
        return anliZhutiTypes;
    }


    /**
	 * 获取：制作主题
	 */

    public void setAnliZhutiTypes(Integer anliZhutiTypes) {
        this.anliZhutiTypes = anliZhutiTypes;
    }
    /**
	 * 设置：制作方法
	 */
    public Integer getAnliTypes() {
        return anliTypes;
    }


    /**
	 * 获取：制作方法
	 */

    public void setAnliTypes(Integer anliTypes) {
        this.anliTypes = anliTypes;
    }
    /**
	 * 设置：案例形式
	 */
    public String getAnliXingshi() {
        return anliXingshi;
    }


    /**
	 * 获取：案例形式
	 */

    public void setAnliXingshi(String anliXingshi) {
        this.anliXingshi = anliXingshi;
    }
    /**
	 * 设置：案例缩略图
	 */
    public String getAnliPhoto() {
        return anliPhoto;
    }


    /**
	 * 获取：案例缩略图
	 */

    public void setAnliPhoto(String anliPhoto) {
        this.anliPhoto = anliPhoto;
    }
    /**
	 * 设置：案例文件
	 */
    public String getAnliFile() {
        return anliFile;
    }


    /**
	 * 获取：案例文件
	 */

    public void setAnliFile(String anliFile) {
        this.anliFile = anliFile;
    }
    /**
	 * 设置：案例介绍
	 */
    public String getAnliContent() {
        return anliContent;
    }


    /**
	 * 获取：案例介绍
	 */

    public void setAnliContent(String anliContent) {
        this.anliContent = anliContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Anli{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", anliName=" + anliName +
            ", anliZhutiTypes=" + anliZhutiTypes +
            ", anliTypes=" + anliTypes +
            ", anliXingshi=" + anliXingshi +
            ", anliPhoto=" + anliPhoto +
            ", anliFile=" + anliFile +
            ", anliContent=" + anliContent +
            ", createTime=" + createTime +
        "}";
    }
}
