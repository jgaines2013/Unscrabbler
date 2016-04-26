
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScrabbleText extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;
    
    public ScrabbleText() {
        super(new GridBagLayout());
        textField = new JTextField(20);   
        textField.addActionListener(this);  //for input
 
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);        
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        
        add(textField, c);
 
        
        add(scrollPane, c);
        
    }
    private static void UnscrabblerGUI() {
        JFrame frame = new JFrame("ScrabbleText");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ScrabbleText());
        frame.pack();
        frame.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent evt) {
        textArea.setText(textField.getText());   //---------USE THIS LATER TO UPDATE
        
    }
    
    public static void main(String[] args) {
        UnscrabblerGUI();
    }
}