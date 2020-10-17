// Assignment #: Arizona State University CSE205 #6
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: TTh 1:30PM
//  Description: ReviewPane displays a list of available clubs
//  from which a user can select and compute their total number of members.

import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import
import java.util.ArrayList;

//import all other necessary javafx classes here
//----

public class SelectPane extends BorderPane
{
    private ArrayList<Club> clubList;
    private ArrayList<CheckBox> checkBoxList = new ArrayList<CheckBox>();
    VBox CountBoxPane;
    Label sum;
    int cCounter = 0;
    int totMembers = 0;

    //constructor
    public SelectPane(ArrayList<Club> list)
    {
        //initialize instance variables
        this.clubList = list;

        //set up the layout
        //----
        BorderPane border = new BorderPane();

        //create an empty pane where you can add check boxes later
        //----
        CountBoxPane = new VBox();
        sum = new Label("The total number of members for the selected club(s):" + totMembers);

        //SelectPane is a BorderPane - add the components here
        //----
        this.setCenter(CountBoxPane);
        this.setBottom(sum);

    } //end of constructor

    //This method uses the newly added parameter Club object
    //to create a CheckBox and add it to a pane created in the constructor
    //Such check box needs to be linked to its handler class
    public void updateClubList(Club newClub)
    {
        clubList.add(newClub);
        CheckBox aBox = new CheckBox(clubList.get(cCounter).toString());
        checkBoxList.add(aBox);
        checkBoxList.get(cCounter).setOnAction(new SelectionHandler());
        CountBoxPane.getChildren().add(checkBoxList.get(cCounter));
        cCounter++;
    }

    //create a SelectionHandler class
    private class SelectionHandler implements EventHandler<ActionEvent>
    {
        //Override the abstract method handle()
        public void handle(ActionEvent event)
        {
            totMembers = 0;
            //When any radio button is selected or unselected
            //the total number of members of selected clubs should be updated
            //and displayed using a label.
            for(int i = 0; i < checkBoxList.size(); i++)
            {
                if (checkBoxList.get(i).isSelected());
                totMembers += clubList.get(i).getNumberOfMembers();
            }

            sum.setText("The number of members for the selected club(s) is:" + totMembers);
        }
    } //end of SelectHandler class
} //end of SelectPane class