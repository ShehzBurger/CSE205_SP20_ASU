// Assignment #: Arizona State University CSE205 #6
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: TTh 1:30PM
//  Description: CreatePane generates a pane where a user can enter
//  a club information and create a list of available clubs.

import java.util.ArrayList;
import java.util.*;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;	//**Need to import
import javafx.event.EventHandler;	//**Need to import**
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextArea;

//import all other necessary javafx classes here
//----

public class CreatePane extends HBox
{
	ArrayList<Club> clubList;

	//The relationship between CreatePane and SelectPane is Aggregation
	private SelectPane selectPane;
	private TextField title, members, university;
	private Label error;
	TextArea textArea;

	//constructor
	public CreatePane(ArrayList<Club> list, SelectPane sePane)
	{
		super(2);
		this.clubList = list;
		this.selectPane = sePane;

		//initialize each instance variable (textfields, labels, textarea, button, etc.)
		//and set up the layout
		//----
		Button btn1 = new Button();
		btn1.setText("Create a Club");
		Label error = new Label("");
		error.setTextFill(Color.RED);
		Label lb1 = new Label("Title");
		title = new TextField();
		Label lb2 = new Label("Number of Members");
		members = new TextField();
		Label lb3 = new Label("University");
		university = new TextField();

		//create a GridPane hold those labels & text fields.
		//you can choose to use .setPadding() or setHgap(), setVgap()
		//to control the spacing and gap, etc.
		//----
		GridPane pane1 = new GridPane();
		pane1.setPadding((new Insets(10,10,10,10)));

		//Set up the layout for the left half of the CreatePane.
		//----
		pane1.add(error,1,0,1,1);
		pane1.add(lb1,0,1,1,1);
		pane1.add(lb2,0,2,1,1);
		pane1.add(lb3,0,3,1,1);

		pane1.add(title,1,1,1,1);
		pane1.add(members, 1,2,1,1);
		pane1.add(university,1,3,1,1);

		pane1.add(btn1,1,4,1,1); //row 0, column 0

		//the right half of the CreatePane is simply a TextArea object
		//Note: a ScrollPane will be added to it automatically when there are no
		//enough space
		textArea = new TextArea();
		textArea.setEditable(false);
		pane1.setAlignment(Pos.TOP_CENTER);
		pane1.setPrefWidth(350);

		//Add the left half and right half to the CreatePane
		//Note: CreatePane extends from HBox
		//----
		getChildren().add(error);
		setSpacing(10);

		//register/link source object with event handler
		//----
		this.getChildren().add(pane1);
		this.getChildren().add(textArea);

	} //end of constructor

	//Create a ButtonHandler class
	//ButtonHandler listens to see if the button "Create" is pushed or not,
	//When the event occurs, it get a club's Title, its number of members, and its university
	//information from the relevant text fields, then create a new club and add it inside
	//the clubList. Meanwhile it will display the club's information inside the text area.
	//using the toString method of the Club class.
	//It also does error checking in case any of the textfields are empty,
	//or a non-numeric value was entered for its number of members
	private class ButtonHandler implements EventHandler<ActionEvent>
	{
		//Override the abstact method handle()
		public void handle(ActionEvent event)
		{
			//declare any necessary local variables here
			boolean addClub = true;
					Club club = new Club();

			//when a text field is empty and the button is pushed
			if(title.getText().isEmpty() || members.getText().isEmpty() ||
					university.getText().isEmpty()){
				error.setText("Please fill all fields");
			}

			else
				{
					try{
						String title1 = title.getText();
						int members1 = Integer.parseInt(members.getText());
						String uni1 = university.getText();

						club.setClubName(title.getText());
						club.setNumberOfMembers(members1);
						club.setUniversity(university.getText());
						clubList.add(club);
						selectPane.updateClubList(club);
						title.setText("");
						members.setText("");
						university.setText("");
						error.setText("Club added");
					}catch (NumberFormatException e){
						error.setText("Please enter an integer for a number of members");
						addClub = false;
					}
				}
			//When a club of an existing club name in the list
			//was attempted to be added, do not add it to the list
			//and display a message "Club not added - duplicate"
			for(int i = 0; i < clubList.size(); i++)
			{
				if(clubList.get(i).getClubName().equalsIgnoreCase(club.getClubName()));
				{
					error.setText("Club not added - duplicate");
					addClub = false;
					break;
				}
			}
			//at the end, don't forget to update the new arrayList
			//information on the SelectPanel
			//----
			if(addClub)
			{
				club.setUniversity(title.getText());
				textArea.appendText(club.toString());
				selectPane.updateClubList(club);
				error.setText("Club Added");
			}

		} //end of handle() method
	} //end of ButtonHandler class

}
