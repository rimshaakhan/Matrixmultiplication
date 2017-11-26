import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LanguageVote {
   private JFrame frame;
   private JLabel title;
   private JLabel evaluationLabel;
   private JPanel panel;
   private ButtonGroup radioGroup;

   private  int lang1 = 0;
   private  int lang2 = 0;
   private  int lang3 = 0;
   private  int lang4 = 0;

   public LanguageVote(){
      buildLayout();
   }
   public static void main(String[] args){
      LanguageVote votingMachine = new LanguageVote();  
      votingMachine.populateLayout();       
   }
   private void buildLayout(){
      frame = new JFrame("Language Selector");
      frame.setSize(500,400);
      frame.setLayout(new GridLayout(3, 10));
      frame.getContentPane().setBackground(Color.GREEN);

      panel = new JPanel();
      panel.setLayout(new GridLayout(0,1,10,10));
      panel.setSize(new Dimension(300, 200));

      title = new JLabel();
      evaluationLabel = new JLabel("",JLabel.CENTER);        
      evaluationLabel.setSize(400,400);
      
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent a){
            System.exit(0);
         } 
        
      });    
      
      frame.add(title);
      frame.add(panel);
      frame.add(evaluationLabel);
      
      frame.setVisible(true);  
   }

   private void populateLayout(){
      title.setText("<html><h1>  CHOOSE YOUR FAVOURITE LANGUAGE <h1><html>");
      title.setFont(new Font("Myriad Pro",Font.PLAIN, 10));

      final JRadioButton C = new JRadioButton("C", true);
      final JRadioButton Ruby = new JRadioButton("Ruby");
      final JRadioButton Java = new JRadioButton("Java");
      final JRadioButton Python = new JRadioButton("Python");


      final JButton confirmButton = new JButton("Vote"); 
      confirmButton.addActionListener(new onclick());

	final JButton Result= new JButton("Result");
	Result.addActionListener(new resultdeclare());
	Result.setActionCommand("Result");

      C.setActionCommand("C");
      Ruby.setActionCommand("Ruby");
      Java.setActionCommand("Java");
      Python.setActionCommand("Python");

     radioGroup = new ButtonGroup();
     radioGroup.add(C);
     radioGroup.add(Ruby);
     radioGroup.add(Java);
     radioGroup.add(Python);

      panel.add(C);
      panel.add(Ruby);
      panel.add(Java);
      panel.add(Python);

      panel.add(confirmButton);
      panel.add(Result);
      frame.setVisible(true);  
   }

  private void setEvaluationLabel(){
	

   	evaluationLabel.setText("<html><br>Here is your Result:<br>C Votes: " + lang1 + "<br>Ruby Votes:" + lang2 + "<br>Java Votes: " + lang3 + "<br>Python votes: " +lang4);


   }

   private class onclick implements ActionListener{
      public void actionPerformed(ActionEvent e) {

	Object[] options={"YES, I am sure", "Go back"};
	int click=JOptionPane.showOptionDialog(frame,"Are you sure " + "You choose this language?", "Please CONFIRM", JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[1]); 

	     if (click == JOptionPane.OK_OPTION) {
	      String selection =radioGroup.getSelection().getActionCommand(); 
	      if (selection == "C"){
	      	lang1+=1;
                 frame.getContentPane().setBackground(Color.YELLOW);
	      	
	      }
	      else if (selection == "Ruby"){
	      	lang2+=1;
                 frame.getContentPane().setBackground(Color.RED);
	      	
	      }else if (selection == "Java"){
	      	lang3+=1;
                 frame.getContentPane().setBackground(Color.PINK);
	      
	      }
	      else{
	      	lang4+=1;
                frame.getContentPane().setBackground(Color.ORANGE);
	      	
	      }
		
	    }
	    else
		 frame.getContentPane().setBackground(Color.GREEN);
		

      }		
   }

private class resultdeclare implements ActionListener{
	 public void actionPerformed(ActionEvent e) {
	  String command=e.getActionCommand();
	if(command.equals("Result")){
	  setEvaluationLabel();
	}
	}
}
   


}
