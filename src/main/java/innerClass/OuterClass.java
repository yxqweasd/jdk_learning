package innerClass;

/**
 * Created by huangweinan on 2019/5/14.
 */
public class OuterClass {

    OuterClass.InstanceInnerClass instanceInnerClass = null;

    class InstanceInnerClass{}

    OuterClass(){
        instanceInnerClass = new OuterClass.InstanceInnerClass();
    }

    public static void main(String[] args) {

        (new Thread()).start();

        class MethodClassl {}
        class MethodClass2 {}
    }
}
