import java.awt.Font;

public class Format {
    UIF uif;
    Font arial, comicSansMS, timesNewRoman, calibri, sans, georgia;
    String selectedFont;

    public Format(UIF uif)
    {
        this.uif = uif;
    }

    public void wordWrap()
    {
        if(!uif.wordWrapOn)
        {
            uif.wordWrapOn = true;
            uif.textArea.setLineWrap(true);
            uif.textArea.setWrapStyleWord(true);
            uif.iWrap.setText("Word Wrap : ON");
        }
        else
        {
            uif.wordWrapOn = false;
            uif.textArea.setLineWrap(false);
            uif.textArea.setWrapStyleWord(false);
            uif.iWrap.setText("Word Wrap : OFF");
        }
    }

    public void createFont(int fontSize)
    {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN,fontSize);
        calibri = new Font("Calibri", Font.PLAIN,fontSize);
        sans = new Font("Sans", Font.PLAIN,fontSize);
        georgia = new Font("Georgia", Font.PLAIN,fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font)
    {
        selectedFont = font;

        switch (selectedFont) 
        {
            case "Arial"            :     uif.textArea.setFont(arial);
                                          break;
            case "Comic Sans MS"    :     uif.textArea.setFont(comicSansMS);
                                          break;
            case "Times New Roman"  :     uif.textArea.setFont(timesNewRoman);
                                          break;          
            case "Calibri"          :     uif.textArea.setFont(calibri);
                                          break; 
            case "Sans"             :     uif.textArea.setFont(sans);
                                          break;   
            case "Georgia"          :     uif.textArea.setFont(georgia);
                                          break;                      
        }
    }
}
