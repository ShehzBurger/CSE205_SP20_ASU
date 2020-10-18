// Assignment #: 7
//         Name: Shehzad Anwar
//    StudentID: 1216575295
//      Lecture: TTh 1:30PM
//  Description: PaneWithRectangles class creates a pane where we can use
//               mouse key to drag on grids and there will be some color following
//               the mouse. We can also use combo boxes to change its colors and stroke widths

//import any classes necessary here
//----
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.lang.reflect.Array;

public class PaneWithRectangles extends BorderPane
{
    private ComboBox<String> primaryColorCombo;
    private ComboBox<String> backColorCombo;
    private ComboBox<String> widthCombo;

    private Color primaryColor, secondaryColor, backgroundColor;
    private double selectWidth;

    private Rectangle[][] rectArray;

    private Color pickedColor;

    public PaneWithRectangles()
    {
        primaryColor = Color.BLACK;
        secondaryColor = Color.GRAY;
        backgroundColor = Color.WHITE;
        selectWidth = 1.0;

        //Instantiate and initialize labels, combo boxes
        Label lb1 = new Label("PrimaryColor");
        Label lb2 = new Label("BackgroundColor");
        Label lb3 = new Label("StrokeWidth");

        primaryColorCombo = new ComboBox<String>();
        primaryColorCombo.getItems().addAll("Black","Blue","Red","Green"); //options for primary color
        primaryColorCombo.setValue("Black");
        pickedColor = Color.BLACK;

        backColorCombo = new ComboBox<String>();
        backColorCombo.getItems().addAll("White","Yellow","Orange"); //options for background color
        backColorCombo.setValue("White");
        pickedColor = Color.WHITE;

        widthCombo = new ComboBox<String>();
        widthCombo.getItems().addAll("1","3","5", "7"); //options for stroke size
        widthCombo.setValue("1");

        //Instantiate and initialize the two dimensional array rectArray
        //to contain 7 columns and 7 rows (49 rectangles total)
        //It is recommended to use nested loops
        rectArray = new Rectangle[7][7]; //set up for shape of the GUI
        for (int i = 0; i<7; i++){
            for (int j = 0; j<7; j++){
                rectArray[i][j] = new Rectangle(1,1,470/7, 390/7);
                rectArray[i][j].setFill(Color.WHITE);
                rectArray[i][j].setStroke(Color.BLACK);
                rectArray[i][j].setStrokeWidth(1);
            }
        }

        //grid is a GridPane containing 49 rectangles.
        GridPane grid = new GridPane();
        //---- add 49 rectangles to the grid pane, it is recommended to use nested loops
        //----
        //----
        for (int i = 0; i<7; i++){
            for (int j = 0;j<7; j++ ){
                grid.add(rectArray[i][j], i, j);
            }
        }

        grid.setPadding(new Insets(10, 0, 10, 0));

        //leftPane is a VBox, it should contain labels and combo boxes
        VBox leftPane = new VBox();
        leftPane.setSpacing(20);
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        leftPane.getChildren().add(lb1);
        leftPane.getChildren().add(primaryColorCombo); //menu for primary color selection
        leftPane.getChildren().add(lb2);
        leftPane.getChildren().add(backColorCombo); //menu for background color selection
        leftPane.getChildren().add(lb3);
        leftPane.getChildren().add(widthCombo); //menu for width selection

        //add the left pane to the left of the pane
        //and the grid pane contains rectangles at the center
        this.setLeft(leftPane);
        this.setCenter(grid);

        //register/link the source nodes with its handler objects
        grid.setOnMouseDragged(new MouseHandler());

        //----
        //----
        //----
        primaryColorCombo.setOnAction(new PrimColorHandler());
        leftPane.setOnMouseReleased(new MouseHandler());
        leftPane.setOnMouseDragged(new MouseHandler());

        backColorCombo.setOnAction(new BackColorHandler());
        leftPane.setOnMouseReleased(new MouseHandler());
        leftPane.setOnMouseDragged(new MouseHandler());

        widthCombo.setOnAction(new WidthHandler());
        leftPane.setOnMouseReleased(new MouseHandler());
        leftPane.setOnMouseDragged(new MouseHandler());

    }


    //Step #2(A) - MouseHandler
    private class MouseHandler implements EventHandler<MouseEvent>
    {
        public void handle(MouseEvent event)
        {
            //handle MouseEvent here
            //Note: you can use if(event.getEventType()== MouseEvent.MOUSE_DRAGGED)
            //to check whether the mouse key is dragged
            //write your own codes here
            //----
            double mousex = event.getX(); //X position of cursor
            double mousey = event.getY(); //Y position of cursor
            int x = 0; //holder for X-value
            int y = 0; //holder for Y-value
            x = (int) (mousex / (490 / 7));
            y = (int) (mousey / (390 / 7));

            try {
                if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    for (int i = 0; i < 7; i++) { //repaint boxes without cursor to background color
                        for (int j = 0; j < 7; j++) {
                            rectArray[i][j].setFill(backgroundColor);
                            rectArray[i][j].setStrokeWidth(selectWidth);
                        }
                    }
                    if (x==0 && (y!=0 && y!=6)){ //if the cursor is on the left edge
                        rectArray[x][y].setFill(primaryColor);
                        rectArray[x][y-1].setFill(secondaryColor);
                        rectArray[x][y+1].setFill(secondaryColor);
                        rectArray[x+1][y].setFill(secondaryColor);
                    }
                    else if (x==0 && y==0) { //if the cursor is on the top left corner
                        rectArray[x][y].setFill(primaryColor);
                        rectArray[x][y+1].setFill(secondaryColor);
                        rectArray[x+1][y].setFill(secondaryColor);
                    }
                    else if (x==0 && y==6) { //if the cursor is on a box over the bottom left corner
                        rectArray[x][y].setFill(primaryColor);
                        rectArray[x][y-1].setFill(secondaryColor);
                        rectArray[x+1][y].setFill(secondaryColor);
                    }
                    else if (x==6 && y==6){ //if the cursor is on the bottom right corner
                        rectArray[x][y].setFill(primaryColor);
                        rectArray[x-1][y].setFill(secondaryColor);
                        rectArray[x][y-1].setFill(secondaryColor);
                    }
                    else if (x==6 && y==0) { //if the cursor is on the top right corner
                        rectArray[x][y].setFill(primaryColor);
                        rectArray[x-1][y].setFill(secondaryColor);
                        rectArray[x][y+1].setFill(secondaryColor);
                    }
                    else if (y==0 && (x !=0 & x !=6)) { //if the cursor is on the top edge of grid
                        rectArray[x][y].setFill(primaryColor);
                        rectArray[x+1][y].setFill(secondaryColor);
                        rectArray[x-1][y].setFill(secondaryColor);
                        rectArray[x][y+1].setFill(secondaryColor);
                    }
                    else if (x==6 && (y!=0 && y!=6)){ //if the cursor is on box on the right edge of the grid
                        rectArray[x][y].setFill(primaryColor);
                        rectArray[x][y-1].setFill(secondaryColor);
                        rectArray[x][y+1].setFill(secondaryColor);
                        rectArray[x-1][y].setFill(secondaryColor);
                    }
                    else if (y==6 && (x!=0 && x!=6)) { //if the cursor is on box on the right edge of the grid
                        rectArray[x][y].setFill(primaryColor);
                        rectArray[x+1][y].setFill(secondaryColor);
                        rectArray[x-1][y].setFill(secondaryColor);
                        rectArray[x][y-1].setFill(secondaryColor);
                    }
                    else { //if the cursor is in the middle of the grid
                        rectArray[x][y].setFill(primaryColor);
                        rectArray[x+1][y].setFill(secondaryColor);
                        rectArray[x-1][y].setFill(secondaryColor);
                        rectArray[x][y+1].setFill(secondaryColor);
                        rectArray[x][y-1].setFill(secondaryColor);
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException e){

            }
        }//end handle()

    }//end MouseHandler

    //A handler class used to handle primary and secondary colors
    private class PrimColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            //write your own codes here
            //----
            //Prim Colors
            if(primaryColorCombo.getValue().equals("Black")) {
                primaryColor = Color.BLACK;
                secondaryColor = Color.GRAY;
            }else if
            (primaryColorCombo.getValue().equals("Blue")){
                primaryColor = Color.BLUE;
                secondaryColor = Color.POWDERBLUE;
            }else if (primaryColorCombo.getValue().equals("Red")){
                primaryColor = Color.RED;
                secondaryColor = Color.PINK;
            }else{
                primaryColor = Color.GREEN; secondaryColor = Color.LIGHTGREEN;}
        }
    }//end PrimColorHandler

    //A handler class used to handle background color
    private class BackColorHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            //write your own codes here
            //----
            if (backColorCombo.getValue().equals("White"))
                backgroundColor = Color.WHITE;
            else if(backColorCombo.getValue().equals("Yellow"))
                backgroundColor = Color.YELLOW;
            else
                backgroundColor = Color.ORANGE;

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    rectArray[i][j].setFill(backgroundColor);
                    rectArray[i][j].setStrokeWidth(selectWidth);
                }
            }
        }
    }//end BackColorHandler

    //A handler class used to handle stroke width
    private class WidthHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            //write your own codes here
            //----
            if (widthCombo.getValue().equals("1"))
                selectWidth = 1;
            else if(widthCombo.getValue().equals("3"))
                selectWidth = 3;
            else if(widthCombo.getValue().equals("5"))
                selectWidth = 5;
            else
                selectWidth = 7;

            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    rectArray[i][j].setFill(backgroundColor);
                    rectArray[i][j].setWidth(470 / 7 - selectWidth );
                    rectArray[i][j].setHeight(390 / 7 - selectWidth);
                    rectArray[i][j].setStrokeWidth(selectWidth);
                }
            }
        }
    }//end WidthHandler
} //end of PaneWithRectangles