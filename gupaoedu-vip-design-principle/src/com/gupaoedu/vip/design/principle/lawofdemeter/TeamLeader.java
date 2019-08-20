package com.gupaoedu.vip.design.principle.lawofdemeter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom
 */
public class TeamLeader {

//    public void checkNumberOfCourses(List<Course> courseList){
//        System.out.println("目前已发布的课程数量是："+courseList.size());
//    }

    public void checkNumberOfCourses(){
        List<Course> courseList = new ArrayList<Course>();
        for(int i = 0 ;i < 20;i++){
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程数量是："+courseList.size());
    }

}
