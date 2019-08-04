package Lesson_8;

public class Camera {
    private ICameraRoll cameraRoll;

    /*public Camera(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }*/

    public ICameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(ICameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void doPhotograph() {
        System.out.println("Click!");
        cameraRoll.processing();
    }
}
