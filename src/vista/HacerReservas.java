package vista;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;

public class HacerReservas extends JDialog {
    public HacerReservas() {
        this(null, "", false);
    }

    public HacerReservas(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(526, 374));
        this.getContentPane().setLayout( null );
    }
}
