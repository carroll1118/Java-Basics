package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Auther Carroll
 * @Date 2020/4/6
 * @e-mail ggq_carroll@163.com
 */
public class testLambda {
    public static void main(String[] args) {
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );
    }
}

class Car {
    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }
}
