import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UIF implements ActionListener{
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;

    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColour;

    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontCalibri, iFontSans, iFontGeorgia, iFontSize8, 
    iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28, iFontSize32, iFontSize36;
    JMenu menuFont, menuFontSize;

    JMenuItem iCopy, iCopy1, iCut1, iCut, iPaste1, iPaste, iDelete, iTD, iAllSel;
    Stack<String> stack = new Stack<>();
    String str = "";
    int i=0, pos=0;
    GregorianCalendar gCalendar;

    JMenuItem iCol1, iCol2, iCol3, iCol4, iCol5, iCol6;

    File fun = new File(this);
    Format format = new Format(this);
    Edit edit = new Edit(this);
    Colour col = new Colour(this);

    public static void main(String[] args) {
        new UIF();
    }

    public UIF()
    {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEdit();
        createFormatMenu();
        createColourMenu();

        format.selectedFont = "Arial";
        format.createFont(12);
        format.wordWrap();
        col.changeColour("White");
        window.setVisible(true);
    }

    public void createWindow()
    {
        window = new JFrame("Text Editor");
        window.setSize(1000,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea()
    {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar()
    {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColour = new JMenu("Background Color");
        menuBar.add(menuColour);
    }

    public void createFileMenu()
    {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createEdit()
    {
        iCopy = new JMenuItem("Copy to Stack");
        iCopy.addActionListener(this);
        iCopy.setActionCommand("Copy to Stack");
        menuEdit.add(iCopy);

        iCut = new JMenuItem("Cut to Stack");
        iCut.addActionListener(this);
        iCut.setActionCommand("Cut to Stack");
        menuEdit.add(iCut);

        iPaste = new JMenuItem("Paste from Stack");
        iPaste.addActionListener(this);
        iPaste.setActionCommand("Paste from Stack");
        menuEdit.add(iPaste);

        iCopy1 = new JMenuItem("Copy (Ctrl + C)");
        iCopy1.addActionListener(this);
        iCopy1.setActionCommand("Copy (Ctrl + C)");
        menuEdit.add(iCopy1);

        iCut1 = new JMenuItem("Cut (Ctrl + X)");
        iCut1.addActionListener(this);
        iCut1.setActionCommand("Cut (Ctrl + X)");
        menuEdit.add(iCut1);

        iPaste1 = new JMenuItem("Paste (Ctrl + V)");
        iPaste1.addActionListener(this);
        iPaste1.setActionCommand("Paste (Ctrl + V)");
        menuEdit.add(iPaste1);

        iTD = new JMenuItem("Time & Date");
        iTD.addActionListener(this);
        iTD.setActionCommand("Time & Date");
        menuFile.add(iTD);
    }

    public void createFormatMenu()
    {
        iWrap = new JMenuItem("Word Wrap : OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("World Wrap : OFF");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        iFontCalibri = new JMenuItem("Calibri");
        iFontCalibri.addActionListener(this);
        iFontCalibri.setActionCommand("Calibri");
        menuFont.add(iFontCalibri);

        iFontSans = new JMenuItem("Sans");
        iFontSans.addActionListener(this);
        iFontSans.setActionCommand("Sans");
        menuFont.add(iFontSans);

        iFontGeorgia = new JMenuItem("Georgia");
        iFontGeorgia.addActionListener(this);
        iFontGeorgia.setActionCommand("Georgia");
        menuFont.add(iFontGeorgia);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);

        iFontSize32 = new JMenuItem("32");
        iFontSize32.addActionListener(this);
        iFontSize32.setActionCommand("size32");
        menuFontSize.add(iFontSize32);

        iFontSize36 = new JMenuItem("36");
        iFontSize36.addActionListener(this);
        iFontSize36.setActionCommand("size36");
        menuFontSize.add(iFontSize36);
    }

    public void createColourMenu()
    {
        iCol1 = new JMenuItem("White");
        iCol1.addActionListener(this);
        iCol1.setActionCommand("White");
        menuColour.add(iCol1);

        iCol2 = new JMenuItem("Black");
        iCol2.addActionListener(this); 
        iCol2.setActionCommand("Black");
        menuColour.add(iCol2);        

        iCol3 = new JMenuItem("Blue");
        iCol3.addActionListener(this);
        iCol3.setActionCommand("Blue");
        menuColour.add(iCol3);

        iCol4 = new JMenuItem("Yellow");
        iCol4.addActionListener(this);
        iCol4.setActionCommand("Yellow");
        menuColour.add(iCol4);

        iCol5 = new JMenuItem("Orange");
        iCol5.addActionListener(this);
        iCol5.setActionCommand("Orange");
        menuColour.add(iCol5);

        iCol6 = new JMenuItem("Pink");
        iCol6.addActionListener(this);
        iCol6.setActionCommand("Pink");
        menuColour.add(iCol6);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        switch (command) {
            case "New"                  :    fun.newFile();
                                                break;

            case "Open"                 :    fun.open();
                                                break;

            case "SaveAs"               :    fun.saveAs();
                                                break;

            case "Save"                 :    fun.save();
                                                break;

            case "Exit"                 :    fun.exit();
                                                break;

            case "Word Wrap"            :    format.wordWrap();
                                                break;

            case "Arial"                :    format.setFont(command);
                                                break;
            
            case "Comic Sans MS"        :    format.setFont(command);
                                                break;

            case "Times New Roman"      :    format.setFont(command);
                                                break;

            case "Calibri"              :    format.setFont(command);
                                                break;

            case "Sans"                 :    format.setFont(command);
                                                break;
                                                
            case "Georgia"              :    format.setFont(command);
                                                break;
            
            case "size8"                :    format.createFont(8);
                                                break;
                                                
            case "size12"               :    format.createFont(12);
                                                break;
            
            case "size16"               :    format.createFont(16);
                                                break;
                                                
            case "size20"               :    format.createFont(20);
                                                break;

            case "size24"               :    format.createFont(24);
                                                break;  
                                                
            case "size28"               :    format.createFont(28);
                                                break;
                                                
            case "size32"               :    format.createFont(32);
                                                break;

            case "size36"               :    format.createFont(36);
                                                break;
                                                
            case "White"                :    col.changeColour(command);
                                                break;

            case "Black"                :    col.changeColour(command);
                                                break;

            case "Blue"                 :    col.changeColour(command);
                                                break;

            case "Yellow"               :    col.changeColour(command);
                                                break;

            case "Orange"               :    col.changeColour(command);
                                                break;

            case "Pink"                 :    col.changeColour(command);
                                                break;

            case "Copy to Stack"        :    edit.editText(command);
                                                break;

            case "Copy (Ctrl + C)"      :    edit.editText(command);
                                                break;

            case "Cut to Stack"         :    edit.editText(command);
                                                break;

            case "Cut (Ctrl + X)"       :    edit.editText(command);
                                                break;

            case "Paste from Stack"     :    edit.editText(command);
                                                break;

            case "Paste (Ctrl + V)"     :    edit.editText(command);
                                                break;

            case "Time & Date"          :    edit.editText(command);
                                                break;
        }
    }
}
