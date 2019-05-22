package innerClass;

import java.util.ArrayList;

/**
 * Created by huangweinan on 2019/5/14.
 */
public class OuterClass3 {
    OuterClass.InstanceInnerClass instanceInnerClass = null;


    OuterClass3(){
    }

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                System.out.println("Anomous class");
            }
        }.start();

        ArrayList array = new ArrayList();
    }
}
