import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class RotatedChessBoard extends JPanel {
    private static final int TILE_SIZE = 50;
    private static final int BOARD_SIZE = 8;
    private static final int BOARD_PIXEL_SIZE = TILE_SIZE * BOARD_SIZE;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        g2.translate(centerX, centerY);
        g2.rotate(Math.toRadians(45));
        g2.translate(-BOARD_PIXEL_SIZE / 2.0, -BOARD_PIXEL_SIZE / 2.0);

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                boolean isWhite = (row + col) % 2 == 0;
                g2.setColor(isWhite ? Color.WHITE : Color.BLUE);
                g2.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(4));
        g2.draw(new Rectangle2D.Double(0, 0, BOARD_PIXEL_SIZE, BOARD_PIXEL_SIZE));

        g2.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rotated Chessboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new RotatedChessBoard());
        frame.setVisible(true);
    }
}