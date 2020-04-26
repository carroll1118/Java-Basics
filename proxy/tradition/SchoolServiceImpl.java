package proxy.tradition;

import proxy.tradition.SchoolService;

import java.text.SimpleDateFormat;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class SchoolServiceImpl implements SchoolService {
    @Override
    public String login(String loginName, String passWord) {

        // 方法执行的开始时间点
        long startTimer = System.currentTimeMillis();

        try {
            Thread.sleep(500);
            if("admin".equals(loginName) && "123456".equals(passWord)){
                return "success";
            }
        } catch (Exception e) {
            throw new RuntimeException("登录异常");
        }
        long endTimer = System.currentTimeMillis();
        // 在什么时刻执行完，花费了多长时间完成
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("login方法执行->"+sdf.format(endTimer)+"，耗时："+(endTimer - startTimer));

        return "登录名称或者密码不正确";
    }

    @Override
    public String getAllClazzs() {
        // 时间点
        long startTimer = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
            return "返回了所有的班级(1班，2班，3班)";
        } catch (Exception e) {
            throw new RuntimeException("查询班级异常");
        }finally{
            long endTimer = System.currentTimeMillis();
            // 在什么时刻执行完，花费了多长时间完成
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("getAllClazzs方法执行->"+sdf.format(endTimer)+"，耗时："+(endTimer - startTimer));
        }
    }
}
