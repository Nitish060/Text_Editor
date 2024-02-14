import java.awt.Color;

public class Colour {
    UIF uif;

    public Colour(UIF uif)
    {
        this.uif = uif;
    }

    public void changeColour(String col)
    {
        switch (col) {
            case "White"  :   uif.window.getContentPane().setBackground(Color.white);
                              uif.textArea.setBackground(Color.white);
                              uif.textArea.setForeground(Color.black);
                              break;
            case "Black"  :   uif.window.getContentPane().setBackground(Color.black);
                              uif.textArea.setBackground(Color.black);
                              uif.textArea.setForeground(Color.white);
                              break;
            case "Blue"   :   uif.window.getContentPane().setBackground(Color.blue);
                              uif.textArea.setBackground(Color.blue);
                              uif.textArea.setForeground(Color.white);
                              break;
            case "Yellow" :   uif.window.getContentPane().setBackground(Color.yellow);
                              uif.textArea.setBackground(Color.yellow);
                              uif.textArea.setForeground(Color.black);
                              break;
            case "Orange" :   uif.window.getContentPane().setBackground(Color.orange);
                              uif.textArea.setBackground(Color.orange);
                              uif.textArea.setForeground(Color.white);
                              break;
            case "Pink"   :   uif.window.getContentPane().setBackground(Color.pink);
                              uif.textArea.setBackground(Color.pink);
                              uif.textArea.setForeground(Color.black);
                              break;
        }
    }
}
