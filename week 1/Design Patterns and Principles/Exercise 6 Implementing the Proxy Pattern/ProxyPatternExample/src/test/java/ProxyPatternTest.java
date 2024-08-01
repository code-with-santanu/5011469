import org.example.Image;
import org.example.ProxyImage;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image will be loaded from disk and displayed
        image1.display();

        // Image will not be loaded again, it will use the cached image
        image1.display();

        // Image will be loaded from disk and displayed
        image2.display();

        // Image will not be loaded again, it will use the cached image
        image2.display();
    }
}

