package com.gupaoedu.vip.design.principle.dependencyinversion;

/**
 * Created by Tom
 */
public class Tom {

    private ICourse course;

//    public Tom(ICourse course){
//        this.course = course;
//    }

    public void setCourse(ICourse course) {
        this.course = course;
    }

    public void study(){
        course.study();
    }


    public void studyJavaCourse(){
        System.out.println("Tom在学习Java的课程");
    }

    public void studyPythonCourse(){
        System.out.println("Tom在学习Python的课程");
    }


    public void study(ICourse course){
        course.study();
    }

}
