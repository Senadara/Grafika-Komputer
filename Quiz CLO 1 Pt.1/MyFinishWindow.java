import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFinishWindow extends WindowAdapter {
    public void windowClosing(WindowEvent event){
        System.exit(0);
    }
}
