import java.util.Calendar;
import java.util.GregorianCalendar;

public class Edit {
    UIF uif;
    public Edit(UIF uif)
    {
        this.uif = uif;
    }

    public void editText(String command)
    {
        switch (command) {
            case "Copy to Stack"     :        uif.stack.push(uif.textArea.getSelectedText());
                                              break;

            case "Copy (Ctrl + C)"   :        uif.str = uif.textArea.getSelectedText();
                                              break;

            case "Cut to Stack"      :        uif.stack.push(uif.textArea.getSelectedText());
                                              uif.i = uif.textArea.getText().indexOf(uif.str);
                                              uif.textArea.replaceRange("", uif.i, uif.i+uif.str.length());
                                              break;

            case "Cut (Ctrl + X)"    :        uif.str = uif.textArea.getSelectedText();
                                              uif.i = uif.textArea.getText().indexOf(uif.str);
                                              uif.textArea.replaceRange("", uif.i, uif.str.length());
                                              break;
                                             
            case "Paste from Stack"  :        uif.pos = uif.textArea.getCaretPosition();
                                              try{
                                                uif.textArea.insert((String)uif.stack.pop(), uif.pos);
                                              } catch(Exception e){
                                                uif.textArea.insert("", uif.pos);
                                              }
                                              break;
                                    
            case "Paste (Ctrl + V)"  :        uif.pos = uif.textArea.getCaretPosition();
                                              uif.textArea.insert(uif.str, uif.pos);
                                              break;

            case "Time & Date"       :        uif.gCalendar = new GregorianCalendar();
                                              String hour = String.valueOf(uif.gCalendar.get(Calendar.HOUR));
                                              String min = String.valueOf(uif.gCalendar.get(Calendar.MINUTE));
                                              String sec = String.valueOf(uif.gCalendar.get(Calendar.SECOND));
                                              String date = String.valueOf(uif.gCalendar.get(Calendar.DATE));
                                              String month = String.valueOf(uif.gCalendar.get(Calendar.MONTH)+1);
                                              String year = String.valueOf(uif.gCalendar.get(Calendar.YEAR));

                                             if(Integer.parseInt(hour)<10)
                                                hour = "0"+hour;
                                             if(Integer.parseInt(min)<10)
                                                min = "0"+min;
                                             if(Integer.parseInt(sec)<10)
                                                sec = "0"+sec;
                                             if(Integer.parseInt(date)<10)
                                                date = "0"+date;
                                             if(Integer.parseInt(month)<10)
                                                month = "0"+month;
                                             if(Integer.parseInt(year)<10)
                                                year = "0"+year;
                                            
                                             String total = "Time :- "+hour+":"+min+":"+sec+"    Date :-"+date+"/"+month+"/"+year;
                                             int loc = uif.textArea.getCaretPosition();
                                             uif.textArea.insert(total, loc);
                                             break;
        }
    }
}
