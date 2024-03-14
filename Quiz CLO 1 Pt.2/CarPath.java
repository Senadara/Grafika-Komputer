import java.awt.*;
import java.awt.geom.*;

public class CarPath extends Frame {
    // Constructor
    CarPath() {
        // Enables the closing of the window.
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Use antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(4.0f);
        g2d.setStroke(bs);

        // The GeneralPath to describe the car.
        GeneralPath gp = new GeneralPath();

        // Start at the lower front of the car.
        gp.moveTo(60, 120);
        // front underbody
        gp.lineTo(80, 120);
        // front wheel
        gp.quadTo(90, 140, 100, 120);
        // middle underbody
        gp.lineTo(160, 120);
        // rear wheel
        gp.quadTo(170, 140, 180, 120);
        // rear underbody rounded
        gp.quadTo(195, 120, 200, 110);
        // rear
        gp.curveTo(200, 100, 205, 80, 160, 80);
        // windscreen top rounded
        gp.quadTo(120, 80, 115, 85);
        // windscreen
        gp.lineTo(103, 98);
        // windscreen bottom rounded
        gp.quadTo(98, 100, 95, 100);
        // bonnet
        gp.lineTo(70, 100);
        // bonnet rounded
        gp.quadTo(65, 100, 60, 110);
        // front
        gp.lineTo(60, 120);

        // Draw the car with dashed lines.
        Stroke dashed = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{12.0f}, 0.0f);
        g2d.setStroke(dashed);
        g2d.draw(gp);

        // Reset stroke to default
        g2d.setStroke(new BasicStroke(1.0f));

        // Draw a coordinate system.
        drawSimpleCoordinateSystem(200, 150, g2d);
    }

    /**
     * Draws a coordinate system (according to the window coordinates).
     *
     * @param xmax x-coordinate to which the x-axis should extend.
     * @param ymax y-coordinate to which the y-axis should extend.
     * @param g2d  Graphics2D object for drawing.
     */
    public static void drawSimpleCoordinateSystem(int xmax, int ymax, Graphics2D g2d) {
        int xOffset = 30;
        int yOffset = 50;
        int step = 20;
        String s;
        // Remember the actual font.
        Font fo = g2d.getFont();
        // Use a small font.
        g2d.setFont(new Font("sansserif", Font.PLAIN, 9));
        // x-axis.
        g2d.drawLine(xOffset, yOffset, xmax, yOffset);
        // Marks and labels for the x-axis.
        for (int i = xOffset + step; i <= xmax; i = i + step) {
            g2d.drawLine(i, yOffset - 2, i, yOffset + 2);
            g2d.drawString(String.valueOf(i), i - 7, yOffset - 7);
        }

        // y-axis.
        g2d.drawLine(xOffset, yOffset, xOffset, ymax);

        // Marks and labels for the y-axis.
        s = "  "; // for indention of numbers < 100
        for (int i = yOffset + step; i <= ymax; i = i + step) {
            g2d.drawLine(xOffset - 2, i, xOffset + 2, i);
            if (i > 99) {
                s = "";
            }
            g2d.drawString(s + String.valueOf(i), xOffset - 25, i + 5);
        }

        // Reset to the original font.
        g2d.setFont(fo);
    }

    public static void main(String[] argv) {
        CarPath f = new CarPath();
        f.setTitle("GeneralPath example");
        f.setSize(250, 200);
        f.setVisible(true);
    }
}
