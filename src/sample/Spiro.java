package sample;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public class Spiro
{
    private int getX(double a, double b, double t)
    {
        return 70 * (int)((a - b) * Math.cos(t) + b * Math.cos(t * (a / b - 1)));
    }
    private int getY(double a, double b, double t)
    {
        return 70 * (int)((a - b) * Math.sin(t) - b * Math.sin(t * (a / b - 1)));
    }

    public void drawSpiro(GraphicsContext gc, Canvas canvas, Label label, TextArea enterPoints)
    {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(0.25);

        Point2D cur;
        Point2D next;

        double a = 5;
        double b = 2.51;
        double t = 0;
        int points = Integer.parseInt(enterPoints.getText());
        double step = 2;
        int refreshCounter = 0;
        int refreshValue = 100;
        int pointsCounter = 1;
        int shiftX = (int)(canvas.getWidth() / 2);
        int shiftY = (int)(canvas.getHeight() / 2);

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

            pointsCounter++;
            label.setText(String.valueOf(pointsCounter));

        }
    }
}
