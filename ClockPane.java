//M05 Programming Assignment (3)
//Ivy Tech Community College
//SDEV 200 - Java
//Professor Bumgardner
//Nativida Muhammad
// 21 April 2024

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.Calendar;

public class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;

    public ClockPane() {
        setCurrentTime();
    }

    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    public void setCurrentTime() {
        // Obtain the current time
        Calendar calendar = Calendar.getInstance();
        // Set the current hour, minute, and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        paintClock(); // Repaint the clock
    }

    private void paintClock() {
        // Calculate the clock's radius
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        // Draw the clock face
        Canvas canvas = new Canvas(getWidth(), getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeOval(centerX - clockRadius, centerY - clockRadius, clockRadius * 2, clockRadius * 2);
        gc.setFill(Color.BLACK);

        // Draw the hour hand
        double hourLength = clockRadius * 0.5;
        double hourAngle = (360 / 12) * (hour % 12) + (30.0 / 60) * minute;
        double hourX = centerX + hourLength * Math.sin(Math.toRadians(hourAngle));
        double hourY = centerY - hourLength * Math.cos(Math.toRadians(hourAngle));
        gc.strokeLine(centerX, centerY, hourX, hourY);

        // Draw the minute hand
        double minLength = clockRadius * 0.7;
        double minAngle = (360 / 60) * minute + (6.0 / 60) * second;
        double minX = centerX + minLength * Math.sin(Math.toRadians(minAngle));
        double minY = centerY - minLength * Math.cos(Math.toRadians(minAngle));
        gc.strokeLine(centerX, centerY, minX, minY);

        // Draw the second hand
        double secLength = clockRadius * 0.8;
        double secAngle = (360 / 60) * second;
        double secX = centerX + secLength * Math.sin(Math.toRadians(secAngle));
        double secY = centerY - secLength * Math.cos(Math.toRadians(secAngle));
        gc.setStroke(Color.RED);
        gc.strokeLine(centerX, centerY, secX, secY);

        getChildren().clear();
        getChildren().add(canvas);
    }

    @Override
    protected void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }

    @Override
    protected void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }
}
