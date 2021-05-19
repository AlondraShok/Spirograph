package sample;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spiro
{
    ArrayList<Formula> formulas = new ArrayList<Formula>();
    int currentFormula = 0;

    private int getX(double t)
    {
        return formulas.get(currentFormula).getX(t);
    }
    private int getY(double t)
    {
        return formulas.get(currentFormula).getY(t);
    }

    private void fillFormulas(double a, double b, int koef)
    {
        if (currentFormula == 0)
        {
            formulas.add(new FormulaV1(a, b, koef));
        }
        if (currentFormula == 1)
        {
            formulas.add(new FormulaV2(a, b, koef));
        }
        formulas.get(currentFormula).setA(a);
        formulas.get(currentFormula).setB(b);
        formulas.get(currentFormula).setKoef(koef);
    }

    public void drawSpiro(GraphicsContext gc, Canvas canvas, Label label, TextArea enterPoints, ChoiceBox choiceStep, ChoiceBox choiceParams, ChoiceBox choiceFormulas)
    {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(0.25);

        Point2D cur;
        Point2D next;

        int koef = 25;

        String params = choiceParams.getValue().toString();
        switch (params)
        {
            case "a: 10, b: 2":
                koef = 30;
                break;
            case "a: 23, b: 2":
                koef = 13;
                break;
            case "a: 5, b: 30":
                koef = 5;
                break;
            case "a: 5, b: 2.51":
                koef = 70;
                break;
            default:
                break;
        }

        String formulas = choiceFormulas.getValue().toString();
        switch (formulas)
        {
            case "Formula 1":
                currentFormula = 0;
                break;
            case "Formula 2":
                currentFormula = 1;
                break;
            default:
                break;
        }

        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("\\d+").matcher(params);
        while (m.find())
        {
            allMatches.add(m.group());
        }

        double a = Double.parseDouble(allMatches.get(0));
        double b = Double.parseDouble(allMatches.get(1));

        fillFormulas(a, b, koef);

        double t = 0;
        int points = Integer.parseInt(enterPoints.getText());
        double step = Double.parseDouble(choiceStep.getValue().toString());
        int pointsCounter = 1;
        int shiftX = (int)(canvas.getWidth() / 2);
        int shiftY = (int)(canvas.getHeight() / 2);

        cur = new Point2D(getX(t) + shiftX, getY(t) + shiftY);

        for (t = step; t <= (points - 1) * step; t = t + step)
        {
            next = new Point2D(getX(t) + shiftX, getY(t) + shiftY);

            gc.strokeLine(cur.getX(), cur.getY(), next.getX(), next.getY());

            if (t % 2 == 0)
            {
                gc.setStroke(Color.RED);
                gc.strokeLine(cur.getX(), cur.getY(), next.getX(), next.getY());
            }
            else
            {
                gc.setStroke(Color.BLUE);
                gc.strokeLine(cur.getX(), cur.getY(), next.getX(), next.getY());
            }
            cur = next;

            pointsCounter++;
            label.setText(String.valueOf(pointsCounter));
        }
    }
}
