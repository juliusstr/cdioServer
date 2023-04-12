package imageRecognition;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Scalar;
import org.opencv.features2d.SimpleBlobDetector;
import org.opencv.features2d.SimpleBlobDetector_Params;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;

import static org.opencv.features2d.Features2d.drawKeypoints;

public class ImgRecV2 {
    public static void main(String[] args) throws InterruptedException {
        // Load the OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Create a new VideoCapture object to get frames from the webcam
        VideoCapture capture = new VideoCapture(3);

        // Check if the VideoCapture object was successfully initialized
        if (!capture.isOpened()) {
            System.err.println("Failed to open webcam!");
            System.exit(-1);
        }

        // Create a Mat object to store the current frame from the webcam
        Mat frame = new Mat();

        // Create a new window to display the webcam feed
        HighGui.namedWindow("Webcam Feed");
        //HighGui.namedWindow("Procesed Feed");

        SimpleBlobDetector_Params params = new SimpleBlobDetector_Params();
        params.set_filterByColor(false);
        params.set_minArea(650);
        params.set_maxArea(1500);
        //params.set
        SimpleBlobDetector blobDetec = SimpleBlobDetector.create(params);
        MatOfKeyPoint keypoints = new MatOfKeyPoint();

        Scalar colorRed = new Scalar( 0, 0, 255 );
        int i =0;
        // Continuously capture frames from the webcam and display them on the screen
        while (true) {
            i++;
            // Read a new frame from the webcam
            capture.read(frame);

            // Apply some image processing to the frame (optional)
            //Imgproc.resize(frame, frame, new Size(1280, 960));

            blobDetec.detect(frame, keypoints);

            if(keypoints.get(0,0) != null) {
                System.out.println(keypoints.toString() + "  " + i);
            }
            // Display the current frame on the screen
            drawKeypoints(frame, keypoints, frame, colorRed, 1);
            HighGui.imshow("Webcam Feed", frame);
            //HighGui.imshow("Procesed Feed", grayImage);
            //Thread.sleep(1000);
            // Wait for a key press to exit the program
            if (HighGui.waitKey(1) == 27) {
                break;
            }
        }

        // Release the VideoCapture object and destroy the window
        capture.release();
        HighGui.destroyAllWindows();

    }
}