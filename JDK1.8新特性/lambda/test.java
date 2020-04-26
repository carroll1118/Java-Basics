package lambda;

import java.util.stream.Stream;

/**
 * @Auther Carroll
 * @Date 2020/4/6
 * @e-mail ggq_carroll@163.com
 */
public class test {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张无忌", "张三丰", "周芷若");
        //stream.forEach(s->System.out.println(s));
        //stream.filter(s -> s.startsWith("周")).forEach(System.out::println);
        /*long count = stream.filter(s -> s.startsWith("张")).count();
        System.out.println(count);*/
        //stream.skip(1).forEach(System.out::println);
        stream.map(s -> s.startsWith("张")).forEach(System.out::println);

    }
}
