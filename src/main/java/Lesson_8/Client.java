package Lesson_8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        /*Assistant assistant = new Assistant();
        Camera camera = assistant.getCamera();
        camera.doPhotograph();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("resources/config.xml");
        Camera camera = context.getBean("camera", Camera.class);
        camera.doPhotograph();
    }
}
