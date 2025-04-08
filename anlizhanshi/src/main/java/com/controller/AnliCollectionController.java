package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.AnliCollectionEntity;

import com.service.AnliCollectionService;
import com.entity.view.AnliCollectionView;
import com.service.AnliService;
import com.entity.AnliEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 案例收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/anliCollection")
public class AnliCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(AnliCollectionController.class);

    @Autowired
    private AnliCollectionService anliCollectionService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private AnliService anliService;
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = anliCollectionService.queryPage(params);

        //字典表数据转换
        List<AnliCollectionView> list =(List<AnliCollectionView>)page.getList();
        for(AnliCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnliCollectionEntity anliCollection = anliCollectionService.selectById(id);
        if(anliCollection !=null){
            //entity转view
            AnliCollectionView view = new AnliCollectionView();
            BeanUtils.copyProperties( anliCollection , view );//把实体数据重构到view中

            //级联表
            AnliEntity anli = anliService.selectById(anliCollection.getAnliId());
            if(anli != null){
                BeanUtils.copyProperties( anli , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setAnliId(anli.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(anliCollection.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody AnliCollectionEntity anliCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,anliCollection:{}",this.getClass().getName(),anliCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            anliCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<AnliCollectionEntity> queryWrapper = new EntityWrapper<AnliCollectionEntity>()
            .eq("anli_id", anliCollection.getAnliId())
            .eq("yonghu_id", anliCollection.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnliCollectionEntity anliCollectionEntity = anliCollectionService.selectOne(queryWrapper);
        if(anliCollectionEntity==null){
            anliCollection.setInsertTime(new Date());
            anliCollection.setCreateTime(new Date());
            anliCollectionService.insert(anliCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody AnliCollectionEntity anliCollection, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,anliCollection:{}",this.getClass().getName(),anliCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            anliCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<AnliCollectionEntity> queryWrapper = new EntityWrapper<AnliCollectionEntity>()
            .notIn("id",anliCollection.getId())
            .andNew()
            .eq("anli_id", anliCollection.getAnliId())
            .eq("yonghu_id", anliCollection.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnliCollectionEntity anliCollectionEntity = anliCollectionService.selectOne(queryWrapper);
        if(anliCollectionEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      anliCollection.set
            //  }
            anliCollectionService.updateById(anliCollection);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        anliCollectionService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = anliCollectionService.queryPage(params);

        //字典表数据转换
        List<AnliCollectionView> list =(List<AnliCollectionView>)page.getList();
        for(AnliCollectionView c:list)
            dictionaryService.dictionaryConvert(c); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        AnliCollectionEntity anliCollection = anliCollectionService.selectById(id);
            if(anliCollection !=null){
                //entity转view
                AnliCollectionView view = new AnliCollectionView();
                BeanUtils.copyProperties( anliCollection , view );//把实体数据重构到view中

                //级联表
                    AnliEntity anli = anliService.selectById(anliCollection.getAnliId());
                if(anli != null){
                    BeanUtils.copyProperties( anli , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAnliId(anli.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(anliCollection.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody AnliCollectionEntity anliCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,anliCollection:{}",this.getClass().getName(),anliCollection.toString());
        Wrapper<AnliCollectionEntity> queryWrapper = new EntityWrapper<AnliCollectionEntity>()
            .eq("anli_id", anliCollection.getAnliId())
            .eq("yonghu_id", anliCollection.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        AnliCollectionEntity anliCollectionEntity = anliCollectionService.selectOne(queryWrapper);
        if(anliCollectionEntity==null){
            anliCollection.setInsertTime(new Date());
            anliCollection.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      anliCollection.set
        //  }
        anliCollectionService.insert(anliCollection);
            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }





}

