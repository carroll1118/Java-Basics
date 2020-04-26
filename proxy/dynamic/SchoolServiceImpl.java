package proxy.dynamic;

import java.text.SimpleDateFormat;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class SchoolServiceImpl implements SchoolService {
    @Override
    public String login(String loginName, String passWord) {
        try {
            Thread.sleep(500);
            if("admin".equals(loginName) && "123456".equals(passWord)){
                return "success";
            }
        } catch (Exception e) {
            throw new RuntimeException("登录异常");
        }

        return "登录名称或者密码不正确";
    }

    @Override
    public String getAllClazzs() {
        try {
            Thread.sleep(1000);
            return "返回了所有的班级(1班，2班，3班)";
        } catch (Exception e) {
            throw new RuntimeException("查询班级异常");
        }
    }
}
