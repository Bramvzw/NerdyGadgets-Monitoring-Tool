import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Open_modal extends JDialog implements ActionListener {


    public Open_modal(JFrame frame) {
        super(frame, true);
        setSize(400, 200);
        setLocation(900, 420);
        setLayout(new BorderLayout());


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
