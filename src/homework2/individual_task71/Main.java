package homework2.individual_task71;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        Class<? extends HelloWorld> clazz = helloWorld.getClass();

        Method getMyMethod = clazz.getMethod("printHelloWorld");
        getMyMethod.invoke(helloWorld);

    }
}
