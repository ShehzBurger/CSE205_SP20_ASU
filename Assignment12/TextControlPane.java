// Assignment #: Arizona State University CSE205 #12
//         Name: Shehzad Anwar
//    StudentID: 1216575295

//      Lecture: TTh 1:30PM:
//  Description: The TextControlPane class creates 4 buttons, 1 label, 1 textfield
//               and 1 sliders to to control the movement of words,
//               and also contains a panel displaying words.


import javafx.scene.layout.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;
import javafx.scene.control.ColorPicker;

import javafx.scene.paint.Color;
import javafx.geometry.Orientation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TextControlPane extends BorderPane
 {
      //components of the pane
      private TextPane tPane;
      private Button start, stop, clear, change;
      private Slider speed;
      private Label label1;
      private GridPane buttons1;
      private TextField textField;
      private ColorPicker picker;

      private int width, height;
      private Color color;

     //Constructor to create all components, set their handler/listener,
     //and arrange them using layout panes.
      public TextControlPane(int width, int height, Color initialColor, String initialString)
       {
           color = initialColor;
           this.width = width;
           this.height = height;

           //create a pane displaying texts, with the specified color and string
           tPane = new TextPane(initialColor, initialString);

           //create 3 buttons, start, stop, and clear
           start = new Button("Start");
           stop = new Button("Stop");
           clear = new Button("Clear");
           
           start.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
           stop.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
           clear.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

           buttons1 = new GridPane();

           buttons1.add(start, 0, 0);
           buttons1.add(stop, 1, 0);
           buttons1.add(clear, 2, 0);

           //create a button to change the word
           change = new Button("Change the text");
           
           //create a textfield to enter a text
           textField = new TextField(initialString);
           
           //create a color picker for a text
           picker = new ColorPicker(initialColor);
           
           //create a label for the rate
           label1 = new Label("Rate");

           //create a slider for the rate for the text drawing with major tick unit 5,
           //minor tick count 1. The minimum value is 0, the maximum
           //is 10, and the initial set value is 1.
           speed = new Slider(0, 10, 1);
           speed.setMajorTickUnit(5);
           speed.setMinorTickCount(1);
           speed.setShowTickLabels(true);
           speed.setShowTickMarks(true);
           speed.setOrientation(Orientation.HORIZONTAL);
           

           speed.valueProperty().addListener(new SpeedHandler());

           GridPane pane5 = new GridPane();
           pane5.add(buttons1, 0, 0);
           pane5.add(textField, 0, 1);
           pane5.add(change, 0, 2);
           pane5.add(picker, 0, 3);
           pane5.add(label1, 0, 4);
           pane5.add(speed, 0, 5);

           
           pane5.setMinSize(width/3, height);
           tPane.setMinSize(width*(2.0)/(3.0), height);
           this.setCenter(tPane);
           this.setLeft(pane5);
           
           //Step #1: set an appropriate handler object to the buttons and the color picker
           /***to be completed***/
           
           
           //Step #2: set an appropriate handler object to the slider
           /***to be completed***/

      }

     //ButtonHandler defines actions to be performed when each button
     //is pushed.
     private class ButtonHandler implements EventHandler<ActionEvent>
     {
         public void handle(ActionEvent event)
         {
             //Step #3 complete the method here
             /***to be completed***/
         }
     } //end of ButtonHandler

     //ColorHandler defines actions to be performed when a color is chosen
     //using the color picker
     private class ColorHandler implements EventHandler<ActionEvent>
     {
         public void handle(ActionEvent event)
         {
             //Step #4 complete the method here
             /***to be completed***/
         }
     } //end of ColorHandler
     
     
     //SpeedHandler adjusts the speed/rate of drawing based on
     //the chosen integer in the corresponding slider.
     private class SpeedHandler implements ChangeListener<Number>
     {
         public void changed(ObservableValue<? extends Number> observable,
                             Number oldValue, Number newValue)
         {
             //Step #5 complete the method here
             /***to be completed***/
         }
         
     } //end of SpeedHandler
 }
