package test;
 import javax.swing.UIManager;
 import view.QLTTView;
public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLTTView();
		}
		catch(Exception e){
             e.printStackTrace();
		}
	}

}
