public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Rotated Chessboard");
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setMinimumSize(new java.awt.Dimension(750, 775));
            frame.setSize(1000, 800);
            frame.add(new RotatedChessBoard());
            frame.setVisible(true);
        });
    }
}
