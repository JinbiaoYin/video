package top.yinjinbiao.video.common.interceptor;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import top.yinjinbiao.video.common.annotation.CreateBy;
import top.yinjinbiao.video.common.annotation.CreateTime;
import top.yinjinbiao.video.common.annotation.Deleted;
import top.yinjinbiao.video.common.annotation.UpdateBy;
import top.yinjinbiao.video.common.annotation.UpdateTime;

@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class,
        Object.class})})
public class BaseDomainInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        // 获取 SQL
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        // 获取参数
        Object parameter = invocation.getArgs()[1];

        // 获取成员变量
        Field[] declaredFields = parameter.getClass().getSuperclass().getDeclaredFields();

        boolean inserted = SqlCommandType.INSERT.equals(sqlCommandType);
        boolean updated= SqlCommandType.UPDATE.equals(sqlCommandType);
        for (Field field : declaredFields) {
            if (field.getAnnotation(CreateTime.class) != null) {
                if (inserted) {
                    // insert语句插入createTime
                    field.setAccessible(true);
                    // 这里设置时间，当然时间格式可以自定。比如转成String类型
                    field.set(parameter, LocalDateTime.now());
                }
            } else if (field.getAnnotation(UpdateTime.class) != null) {

                if (inserted || updated) {
                    // insert 或update语句插入updateTime
                    field.setAccessible(true);
                    field.set(parameter, LocalDateTime.now());
                }
            } else if (field.getAnnotation(CreateBy.class) != null) {
                if (inserted) {
                    // insert语句插入CreatedBy
                    field.setAccessible(true);
                    // 这里设置登陆人
                    field.set(parameter, -1L);
                }
            } else if (field.getAnnotation(UpdateBy.class) != null) {

                if (inserted || updated) {
                    // insert 或update语句插入更新人
                    field.setAccessible(true);
                    field.set(parameter, -1L);
                }
            } else if (field.getAnnotation(Deleted.class) != null) {
                if(inserted){
                    field.setAccessible(true);
                    field.set(parameter, false);
                }
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
