import java.awt.*;

public class TextName extends Frame {

    // Constructor
    public TextName() {
        // Enable the closing of the window.
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        // Use antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        // Definition and drawing of the curves that define the letters.

        // Letter S
        // Letter S reversed
        int xs1 = 150, ys1 = 100;
        int xs2 = 50, ys2 = 100;
        int xs3 = 50, ys3 = 150;
        int xs4 = 150, ys4 = 150;
        int xs5 = 150, ys5 = 200;
        int xs6 = 50, ys6 = 200;

        g2d.drawLine(xs1, ys1, xs2, ys2);
        g2d.drawLine(xs2, ys2, xs3, ys3);
        g2d.drawLine(xs3, ys3, xs4, ys4);
        g2d.drawLine(xs4, ys4, xs5, ys5);
        g2d.drawLine(xs5, ys5, xs6, ys6);

        // Letter N
        int xn1 = 250, yn1 = 200;
        int xn2 = 250, yn2 = 100;
        int xn3 = 300, yn3 = 200;
        int xn4 = 300, yn4 = 100;

        g2d.drawLine(xn1, yn1, xn2, yn2);
        g2d.drawLine(xn2, yn2, xn3, yn3);
        g2d.drawLine(xn3, yn3, xn4, yn4);

        // Letter S
        int xs7 = 450, ys7 = 100;
        int xs8 = 350, ys8 = 100;
        int xs9 = 350, ys9 = 150;
        int xs10 = 450, ys10 = 150;
        int xs11 = 450, ys11 = 200;
        int xs12 = 350, ys12 = 200;

        g2d.drawLine(xs7, ys7, xs8, ys8);
        g2d.drawLine(xs8, ys8, xs9, ys9);
        g2d.drawLine(xs9, ys9, xs10, ys10);
        g2d.drawLine(xs10, ys10, xs11, ys11);
        g2d.drawLine(xs11, ys11, xs12, ys12);
    }

    public static void main(String[] argv) {
        TextName f = new TextName();
        f.setTitle("Letters: S, N, S");

        f.setSize(500, 300);
        f.setVisible(true);
    }
}
