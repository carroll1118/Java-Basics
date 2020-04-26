package reflection;

import domain.Person;

/**
 * @Auther Carroll
 * @Date 2020/4/3
 * @e-mail ggq_carroll@163.com
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        //1.Class.forName("类名")
        Class cls1 = Class.forName("domain.Person");
        System.out.println(cls1);
        //2.类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3.对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        //== 比较三个对象
        System.out.println(cls1 == cls2);//true
        System.out.println(cls1 == cls3);//true
    }
}
