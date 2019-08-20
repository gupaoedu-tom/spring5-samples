package com.gupaoedu.vip.design.principle.dependencyinversion;

/**
 * Created by Tom
 */
public class DependencyInversionTest {

    //v1
//    public static void main(String[] args) {
//        Tom tom = new Tom();
//        tom.studyJavaCourse();
//        tom.studyPythonCourse();
//    }

    //v2
//    public static void main(String[] args) {
//        Tom tom = new Tom();
//        tom.study(new JavaCourse());
//        tom.study(new PythonCourse());
//        tom.study(new PythonCourse());
//    }

    //v3
//    public static void main(String[] args) {
//        Tom tom = new Tom(new JavaCourse());
//        tom.study();
//    }

    //v4
    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.setCourse(new JavaCourse());
        tom.study();

        tom.setCourse(new PythonCourse());
        tom.study();
    }


}
