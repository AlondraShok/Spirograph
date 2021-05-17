package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller
{
    Spiro spiro = new Spiro();
    private GraphicsContext gc ;

    @FXML
    Canvas canvas;

    @FXML
    private Button btnDraw;

    @FXML
    private Button btnClear;

    @FXML
    private Label label;

    @FXML
    private TextArea enterPoints;

    @FXML
    private void clickDraw(ActionEvent event)
    {
        gc = canvas.getGraphicsContext2D();
        spiro.drawSpiro(gc, canvas, label, enterPoints);
    }

    @FXML
    private void clickClear(ActionEvent event)
    {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
