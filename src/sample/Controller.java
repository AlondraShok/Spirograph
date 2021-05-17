package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Controller
{
    private int getX(double a, double b, double t)
    {
        return 70 * (int)((a - b) * Math.cos(t) + b * Math.cos(t * (a / b - 1)));
    }
    private int getY(double a, double b, double t)
    {
        return 70 * (int)((a - b) * Math.sin(t) - b * Math.sin(t * (a / b - 1)));
    }

    public void drawSpiro()
    {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(0.25);

        Point2D cur;
        Point2D next;

        double a = 5;
        double b = 2.51;
        double t = 0;
        int points = 1000;
        double step = 2;
        int refreshCounter = 0;
        int refreshValue = 100;
        int pointsCounter = 1;
        int shiftX = (int)(800 / 2);
        int shiftY = (int)(700 / 2);

        cur = new Point2D(getX(a, b, t) + shiftX, getY(a, b, t) + shiftY);

        for (t = step; t <= (points - 1) * step; t = t + step)
        {
            next = new Point2D(getX(a, b, t) + shiftX, getY(a, b, t) + shiftY);

            gc.strokeLine(cur.getX(), cur.getY(), next.getX(), next.getY());

            if (t % 2 == 0)
            {
                gc.setStroke(Color.RED);
                gc.strokeLine(cur.getX(), cur.getY(), next.getX(), next.getY());
            }
            else
            {
                gc.setStroke(Color.GREEN);
                gc.strokeLine(cur.getX(), cur.getY(), next.getX(), next.getY());
            }
            cur = next;
        }
    }

    @FXML
    Canvas canvas1;

    private GraphicsContext gc ;

    @FXML
    private Button btn;

    @FXML
    private void click(ActionEvent event)
    {
        gc = canvas1.getGraphicsContext2D();
        drawSpiro();
        btn.setText("Stop");
    }
}
