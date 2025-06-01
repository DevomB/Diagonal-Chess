import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RotatedChessBoard extends JPanel {
    private static final int TILE_SIZE = 50;
    private static final int BOARD_SIZE = 8;
    private static final int BOARD_PIXEL_SIZE = TILE_SIZE * BOARD_SIZE;
    private final ChessSquare[][] squares = new ChessSquare[BOARD_SIZE][BOARD_SIZE];

    public RotatedChessBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                squares[row][col] = new ChessSquare(row, col);
            }
        }
    }

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

    Font font = new Font("Arial", Font.BOLD, 12);
    g2.setFont(font);
    FontMetrics fm = g2.getFontMetrics();

    for (int row = 0; row < BOARD_SIZE; row++) {
    for (int col = 0; col < BOARD_SIZE; col++) {
        ChessSquare square = squares[row][col];
        g2.setColor(square.isWhite() ? Color.WHITE : Color.BLUE);
        g2.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        String text = square.getRow() + "," + square.getCol();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();
        int x = col * TILE_SIZE + (TILE_SIZE - textWidth) / 2;
        int y = row * TILE_SIZE + (TILE_SIZE + textHeight) / 2 - 2;

        g2.setColor(square.isWhite() ? Color.BLACK : Color.WHITE);
        g2.drawString(text, x, y);
    }
}
    g2.setColor(Color.BLACK);
    g2.setStroke(new BasicStroke(4));
    g2.draw(new Rectangle2D.Double(0, 0, BOARD_PIXEL_SIZE, BOARD_PIXEL_SIZE));

    g2.dispose();
}
}