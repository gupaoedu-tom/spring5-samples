package com.gupaoedu.vip.design.principle.simpleresponsibility;

import com.gupaoedu.vip.design.principle.simpleresponsibility.simple.Course;
import com.gupaoedu.vip.design.principle.simpleresponsibility.simple.LiveCourse;
import com.gupaoedu.vip.design.principle.simpleresponsibility.simple.ReplayCourse;

/**
 * Created by Tom.
 */
public class SingleResponsibilityTest {
    public static void main(String[] args) {
        Course course = new Course();
        course.study("直播课");
        course.study("录播课");

        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study("直播课");

        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");


    }
}
