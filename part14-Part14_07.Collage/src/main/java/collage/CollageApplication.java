package collage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        int yCoordinate = 0;
        while (yCoordinate < height) {
            int xCoordinate = 0;
            while (xCoordinate < width) {

                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = 1 - color.getRed();
                double green = 1 - color.getGreen();
                double blue = 1 - color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                imageWriter.setColor(xCoordinate / 2, yCoordinate / 2, newColor);

                imageWriter.setColor((width / 2) + xCoordinate / 2, yCoordinate / 2, newColor);

                imageWriter.setColor(xCoordinate / 2, (height / 2) + yCoordinate / 2, newColor);

                imageWriter.setColor((width / 2) + xCoordinate / 2, (height / 2) + yCoordinate / 2, newColor);

                xCoordinate += 2;
            }

            yCoordinate += 2;
        }

        Pane pane = new Pane();
        ImageView image = new ImageView(targetImage);

        // GridPane display = new GridPane();

        // for (int i = 0; i < 2; i++) {

        // for (int j = 0; j < 2; j++) {
        // ImageView newImage = goNegative(sourceImage, width, height);
        // newImage.setFitHeight(height / 2);
        // newImage.setFitWidth(width / 2);
        // display.add(newImage, i, j);
        // }

        // }

        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public ImageView goNegative(Image ogImage, int sourceWidth, int sourceHeight) {
        WritableImage tgImage = new WritableImage(sourceWidth, sourceHeight);

        for (int y = 0; y < sourceHeight; y++) {
            for (int x = 0; x < sourceWidth; x++) {
                Color pixelColor = ogImage.getPixelReader().getColor(x, y);
                double ngRed = 1.0 - pixelColor.getRed();
                double ngGreen = 1.0 - pixelColor.getGreen();
                double ngBlue = 1.0 - pixelColor.getBlue();
                double opacity = pixelColor.getOpacity();

                Color newColor = new Color(ngRed, ngGreen, ngBlue, opacity);
                tgImage
                        .getPixelWriter()
                        .setColor(x, y, newColor);
            }
        }
        return new ImageView(tgImage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
