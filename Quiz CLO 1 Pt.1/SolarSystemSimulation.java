import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class SolarSystemSimulation extends JPanel {
    private double earthAngle = 0; // Sudut rotasi Bumi

    // Array untuk menyimpan posisi Bumi pada 10 titik orbit
    private double[][] earthPositions = new double[10][2];
    private int currentPoint = 0; // Indeks titik orbit saat ini

    public void initializeEarthPositions() {
        // Mengisi array dengan posisi Bumi pada 10 titik orbit
        for (int i = 0; i < 10; i++) {
            double angle = Math.toRadians(36 * i); // Sudut antara setiap titik adalah 36 derajat
            earthPositions[i][0] = 300 + 200 * Math.cos(angle); // Menambahkan jarak antara Matahari dan Bumi
            earthPositions[i][1] = 300 + 200 * Math.sin(angle); // Menambahkan jarak antara Matahari dan Bumi
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Mengatur latar belakang menjadi hitam
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Menggambar Matahari
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(250, 250, 100, 100); // Posisi dan ukuran Matahari yang diperbarui

        // Menghitung posisi Bumi berdasarkan titik orbit saat ini
        double earthX = earthPositions[currentPoint][0];
        double earthY = earthPositions[currentPoint][1];

        // Membuat transformasi untuk rotasi Bumi
        AffineTransform oldTransform = g2d.getTransform();
        g2d.rotate(earthAngle, earthX, earthY);

        // Menambahkan efek gradasi pada Bumi untuk menunjukkan rotasi
        GradientPaint gradient = new GradientPaint((float) (earthX - 20), (float) (earthY - 20), new Color(0, 0, 255, 200), (float) (earthX + 20), (float) (earthY + 20), new Color(0, 0, 0, 0));
        g2d.setPaint(gradient);

        // Menggambar Bumi
        g2d.fillOval((int) (earthX - 20), (int) (earthY - 20), 40, 40);

        // Mengembalikan transformasi sebelumnya
        g2d.setTransform(oldTransform);

        // Mengatur waktu delay untuk rotasi Bumi
        try {
            Thread.sleep(500); // Mengatur delay menjadi lebih cepat agar rotasi terlihat lebih halus
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Memperbarui sudut rotasi Bumi
        earthAngle += Math.toRadians(36); // Menambahkan sudut rotasi sebesar 1 derajat

        // Mengupdate titik orbit saat ini
        currentPoint = (currentPoint + 1) % 10;

        // Menggambar ulang panel
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Simulation");
        SolarSystemSimulation panel = new SolarSystemSimulation();
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.initializeEarthPositions(); // Inisialisasi posisi Bumi pada 10 titik orbit
    }
}
