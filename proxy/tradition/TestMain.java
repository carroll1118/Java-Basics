package proxy.tradition;

import proxy.tradition.SchoolService;
import proxy.tradition.SchoolServiceImpl;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class TestMain {
    public static void main(String[] args) {
        SchoolService schoolService = new SchoolServiceImpl();

        System.out.println(schoolService.login("admin", "123456"));

        System.out.println(schoolService.getAllClazzs());
    }
}
