package com.entity.model;

import com.entity.AnliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 案例
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class AnliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 制作方法
     */
    private Integer anliTypes;


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


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：制作人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：制作人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：案例名称
	 */
    public String getAnliName() {
        return anliName;
    }


    /**
	 * 设置：案例名称
	 */
    public void setAnliName(String anliName) {
        this.anliName = anliName;
    }
    /**
	 * 获取：制作主题
	 */
    public Integer getAnliZhutiTypes() {
        return anliZhutiTypes;
    }


    /**
	 * 设置：制作主题
	 */
    public void setAnliZhutiTypes(Integer anliZhutiTypes) {
        this.anliZhutiTypes = anliZhutiTypes;
    }
    /**
	 * 获取：制作方法
	 */
    public Integer getAnliTypes() {
        return anliTypes;
    }


    /**
	 * 设置：制作方法
	 */
    public void setAnliTypes(Integer anliTypes) {
        this.anliTypes = anliTypes;
    }
    /**
	 * 获取：案例形式
	 */
    public String getAnliXingshi() {
        return anliXingshi;
    }


    /**
	 * 设置：案例形式
	 */
    public void setAnliXingshi(String anliXingshi) {
        this.anliXingshi = anliXingshi;
    }
    /**
	 * 获取：案例缩略图
	 */
    public String getAnliPhoto() {
        return anliPhoto;
    }


    /**
	 * 设置：案例缩略图
	 */
    public void setAnliPhoto(String anliPhoto) {
        this.anliPhoto = anliPhoto;
    }
    /**
	 * 获取：案例文件
	 */
    public String getAnliFile() {
        return anliFile;
    }


    /**
	 * 设置：案例文件
	 */
    public void setAnliFile(String anliFile) {
        this.anliFile = anliFile;
    }
    /**
	 * 获取：案例介绍
	 */
    public String getAnliContent() {
        return anliContent;
    }


    /**
	 * 设置：案例介绍
	 */
    public void setAnliContent(String anliContent) {
        this.anliContent = anliContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
