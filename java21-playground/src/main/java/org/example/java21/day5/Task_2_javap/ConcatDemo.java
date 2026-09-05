package org.example.java21.day5.Task_2_javap;

public class ConcatDemo {

    public static String create(String a, String b) {
        return a + b;
    }

}

/*
javap -c .\target\classes\org\example\java21\day5\Task_2_javap\ConcatDemo.class
Compiled from "ConcatDemo.java"
public class org.example.java21.day5.Task_2_javap.ConcatDemo {
  public org.example.java21.day5.Task_2_javap.ConcatDemo();
    Code:
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return

  public static java.lang.String create(java.lang.String, java.lang.String);
    Code:
         0: aload_0
         1: aload_1
         2: invokedynamic #7,  0              // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
         7: areturn
}

 */


//BEFORE JAVA 9
/*
public static java.lang.String create(java.lang.String, java.lang.String);
  Code:
     0: new           #2                  // class java/lang/StringBuilder
     3: dup
     4: invokespecial #3                  // Method java/lang/StringBuilder."<init>":()V
     7: aload_0
     8: invokevirtual #4                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    11: aload_1
    12: invokevirtual #4                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
    15: invokevirtual #5                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
    18: areturn
 */