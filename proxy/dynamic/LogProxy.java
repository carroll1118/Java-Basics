package proxy.dynamic;

import domain.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class LogProxy {
    public static Object getProxy(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 方法执行的开始时间点
                long startTimer = System.currentTimeMillis();
                try {
                    // 真正去触发被代理对象中该方法的执行
                    return method.invoke(obj,args);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }finally {
                    long endTimer = System.currentTimeMillis();
                    // 在什么时刻执行完，花费了多长时间完成
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println(method.getName()+"方法执行->"+sdf.format(endTimer)+"，耗时："+(endTimer - startTimer));

                }
            }
        });
    }
}
