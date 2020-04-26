package lambda;

import domain.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther Carroll
 * @Date 2020/4/6
 * @e-mail ggq_carroll@163.com
 */
public class lambdaComparatorDemo {
    public static void main(String[] args) {
        List<Student> lists = new ArrayList<>();
        Student s1 = new Student("李明",18,"男");
        Student s2 = new Student("小明",23,"男");
        Student s3 = new Student("李华",21,"男");
        Collections.addAll(lists,s1,s2,s3);
        System.out.println(lists);

        //按照年龄进行升序排序
        Collections.sort(lists, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(lists);

        //lambda表达式写法
        Collections.sort(lists,(Student o1, Student o2) -> {
            return o1.getAge() - o2.getAge();
        });
        System.out.println(lists);

        //lambda表达式写法
        Collections.sort(lists,(Student o1, Student o2) -> {
            return o1.getAge() - o2.getAge();
        });
        System.out.println(lists);

        //lambda表达式写法
        Collections.sort(lists,(Student o1, Student o2) -> o1.getAge() - o2.getAge());
        System.out.println(lists);

        //lambda表达式简化写法
        Collections.sort(lists,(o1,o2) -> o1.getAge() - o2.getAge());

        System.out.println(lists);
    }
}
