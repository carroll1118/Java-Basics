package reflection;

import domain.Person;
import java.lang.reflect.Field;
/**
 * @Auther Carroll
 * @Date 2020/4/3
 * @e-mail ggq_carroll@163.com
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        //获取Person的Class对象
        Class personClass = Person.class;
        //Class personClass = Class.forName("domain.Person");
        /*Person p = new Person();
        Class personClass = p.getClass();*/

        //Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
        System.out.println("----------------1");
        //Field getField(String name)   获取指定名称的 public修饰的成员变量
        Field a = personClass.getField("a");
        //获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,"Carroll");
        System.out.println(p);
        System.out.println("----------------2");
        //Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("----------------3");
        //Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);
        System.out.println("----------------4");
    }
}
