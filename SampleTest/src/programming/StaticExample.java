package programming;

public class StaticExample{
	
    static {
        System.out.println("This is first static block");
    }

    public StaticExample(){
        System.out.println("This is constructor");
    }

    public static String staticString = "Static Variable";

    static {
        System.out.println("This is second static block and "
		                                        + staticString);
    }

    public static void main(String[] args){
    	StaticExample.staticMethod2();
        StaticExample.staticMethod2();
    }

    static {
        staticMethod1();
        System.out.println("This is third static block");
    }

    public static void staticMethod1() {
        System.out.println("This is static method");
    }

    public static void staticMethod2() {
        System.out.println("This is static method2");
    }
}

