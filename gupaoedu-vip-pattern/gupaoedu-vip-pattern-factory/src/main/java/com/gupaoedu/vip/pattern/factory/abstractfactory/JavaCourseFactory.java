package com.gupaoedu.vip.pattern.factory.abstractfactory;

/**
 * Created by Tom.
 */
public class JavaCourseFactory implements CourseFactory {

    public INote createNote() {
        return new JavaNote();
    }

    public IVideo createVideo() {
        return new JavaVideo();
    }
}
