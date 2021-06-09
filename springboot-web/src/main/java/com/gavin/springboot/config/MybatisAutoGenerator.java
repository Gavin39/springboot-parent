package com.gavin.springboot.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Gavin
 * @date 2021/6/2 17:54
 * @since 1.2.26
 */
public class MybatisAutoGenerator {

    //表名
    static final String TABLE_NAME = "t_veh_base";
    static final String PACKAGE_NAME = "com.gavin.springboot";
    static final String MODULE_NAME = "springboot-web";

    // 数据库配置
    static final String DRIVE_NAME = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://rm-uf6075txq4odlnr00.mysql.rds.aliyuncs.com:3306/aiways_newfuel?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true";
    static final String USER_NAME = "ptjs";
    static final String PASSWORD = "wam9OjdY8Y";


    public static void main(String[] args){
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        String modulePath = projectPath + "\\" + MODULE_NAME;
        //设置全局的配置
        globalConfig
                //.setActiveRecord(true)//是否支持AR模式
                .setAuthor("Gavin")//设置作者
                .setOpen(false)
                .setOutputDir(modulePath + "/src/main/java")//设置生成路径
                .setFileOverride(true)//设置文件覆盖
                .setSwagger2(true)//开启swagger2
                .setIdType(IdType.AUTO) //设置主键生成策略
                .setServiceName("%sService")//设置生成的serivce接口的名字
                .setServiceImplName("%sServiceImpl")//设置生成的serivceImpl实现的名字
                .setEntityName("%sPO")//设置生成的serivce接口的名字
                .setMapperName("%sMapper")//设置生成的mapper接口的名字
                .setXmlName("%sMapper")//设置生成的xml的名字
                .setControllerName("%sController")//设置生成的controller的名字
                .setBaseResultMap(true) //设置基本的结果集映射
                .setBaseColumnList(true);//设置基本的列集合

        //设置数据源的配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName(DRIVE_NAME)
                .setUrl(URL)
                .setUsername(USER_NAME)
                .setPassword(PASSWORD);

        // 进行策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                //.setCapitalMode(true)//设置全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策
                .setInclude(TABLE_NAME)//生成的表
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setEntityTableFieldAnnotationEnable(true);

        // 进行包名的策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(PACKAGE_NAME)
                .setEntity("po");

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return modulePath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
        }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);

        //整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setCfg(cfg)
                .setTemplate(templateConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setPackageInfo(packageConfig);

        autoGenerator.execute();
    }

}
