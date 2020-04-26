package proxy.dynamic;

/**
 * @Auther Carroll
 * @Date 2020/4/7
 * @e-mail ggq_carroll@163.com
 */
public class TestMain {
    public static void main(String[] args) {
        SchoolService schoolService = (SchoolService) LogProxy.getProxy(new SchoolServiceImpl());

        System.out.println(schoolService.login("admin", "123456"));

        System.out.println(schoolService.getAllClazzs());
    }
}
