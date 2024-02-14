import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class File {
    UIF uif;
    String fileName;
    String fileAddress;

    public File(UIF uif)
    {
        this.uif = uif;
    }

    public void newFile()
    {
        uif.textArea.setText("");
        uif.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }

    public void open()
    {
        FileDialog fd = new FileDialog(uif.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile() != null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            uif.window.setTitle(fileName);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));

            uif.textArea.setText("");
            String line = null;

            while((line = br.readLine()) != null)
            {
                uif.textArea.append(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File Not Opened!");
        }
    }

    public void save()
    {
        if(fileName == null)
        {
            saveAs();
        }
        else{
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(uif.textArea.getText());
                uif.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                System.out.println("Something wrong happened!");
            }
        }
    }

    public void saveAs()
    {
        FileDialog fd = new FileDialog(uif.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile() != null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            uif.window.setTitle(fileName);
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(uif.textArea.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("Something wrong happened!");
        }
    }

    public void exit()
    {
        System.exit(0);
    }
}
