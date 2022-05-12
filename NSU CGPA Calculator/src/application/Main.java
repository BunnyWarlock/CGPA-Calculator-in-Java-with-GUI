package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;


public class Main extends Application {
	
	String[] eceCourseList = {"ENG 102", "ENG 103", "ENG 111", "PHI 101", "PHI 104", "LBA 101", "LBA 102", "POL 101", "POL 104",
			"ECO 101", "ECO 104", "SOC 101", "ENV 203", "GEO 205", "ANT 101", "BIO 103", "MAT 116", "MAT 120", "MAT 125", "MAT 130",
			"MAT 250", "MAT 350", "MAT 361", "PHY 107", "PHY 108", "CHE 101", "EEE 452", "CEE 110", "CSE 115", "CSE 115L", "CSE 215",
			"CSE 215L", "CSE 173", "CSE 225", "CSE 225L", "CSE 231", "CSE 231L", "CSE 299", "EEE 141", "EEE 141L", "EEE 111", "ETE 111",
			"EEE 111L", "ETE 111L", "EEE 154", "CSE 311", "CSE 311L", "CSE 323", "CSE 327", "CSE 331", "CSE 331L", "CSE 332", "CSE 373",
			"CSE 325", "CSE 425", "CSE 498", "EEE 498", "ETE 498", "CSE 499A", "EEE 499A", "ETE 499A", "CSE 499B", "EEE 499B", "ETE 499B",
			"CSE 417", "CSE 401", "CSE 418", "CSE 426", "CSE 473", "CSE 491", "CSE 411", "CSE 424", "CSE 427", "CSE 428", "CSE 429",
			"CSE 492", "CSE 422", "CSE 438", "CSE 482", "CSE 485", "CSE 486", "CSE 493", "CSE 433", "CSE 435", "CSE 413", "CSE 414",
			"CSE 494", "CSE 419", "CSE 440", "CSE 445", "CSE 465", "CSE 467", "CSE 468", "CSE 470", "CSE 495", "CSE 446", "CSE 447",
			"CSE 448", "CSE 449", "CSE 496"};
	String[] letterGrade = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F", "I", "W", "R"};
	
	public double gradeToGp(String g) {
		double gp;
		if (g.equals("A"))
			gp = 4.0;
		else if (g.equals("A-"))
			gp = 3.7;
		else if (g.equals("B+"))
			gp = 3.3;
		else if (g.equals("B"))
			gp = 3.0;
		else if (g.equals("B-"))
			gp = 2.7;
		else if (g.equals("C+"))
			gp = 2.3;
		else if (g.equals("C"))
			gp = 2.0;
		else if (g.equals("C-"))
			gp = 1.7;
		else if (g.equals("D+"))
			gp = 1.3;
		else if (g.equals("D"))
			gp = 1.0;
		else
			gp = 0;
		return gp;
	}
	
	public void comboBoxInit(ComboBox<String> course, ComboBox<Double> credit, ComboBox<String> grade) {
		for (int i = 0; i < eceCourseList.length; ++i)
			course.getItems().add(eceCourseList[i]);
		course.setMinWidth(100);
		
		credit.getItems().add(0D);
		credit.getItems().add(1D);
		credit.getItems().add(1.5D);
		credit.getItems().add(3D);
		credit.setMinWidth(100);
		
		for (int i = 0; i < letterGrade.length; ++i)
			grade.getItems().add(letterGrade[i]);
		grade.setMinWidth(100);
	}
	
	public void labelInit(Label lcourse, Label lcredit, Label lgrade) {
		lcourse.setMinWidth(100);
		lcredit.setMinWidth(100);
		lgrade.setMinWidth(100);
		lcourse.setAlignment(Pos.CENTER);
		lcredit.setAlignment(Pos.CENTER);
		lgrade.setAlignment(Pos.CENTER);
	}
	
	@Override
	public void start(Stage primaryStage) {
		//UI elements
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		
		//Subject 1
		ComboBox<String> course1 = new ComboBox<String>();	
		ComboBox<Double> credit1 = new ComboBox<Double>();
		ComboBox<String> grade1 = new ComboBox<String>();
		comboBoxInit(course1, credit1, grade1);
		
		//Subject 2
		ComboBox<String> course2 = new ComboBox<String>();	
		ComboBox<Double> credit2 = new ComboBox<Double>();
		ComboBox<String> grade2 = new ComboBox<String>();
		comboBoxInit(course2, credit2, grade2);
		
		//Subject 3
		ComboBox<String> course3 = new ComboBox<String>();	
		ComboBox<Double> credit3 = new ComboBox<Double>();
		ComboBox<String> grade3 = new ComboBox<String>();
		comboBoxInit(course3, credit3, grade3);
		
		//Subject 4
		ComboBox<String> course4 = new ComboBox<String>();	
		ComboBox<Double> credit4 = new ComboBox<Double>();
		ComboBox<String> grade4 = new ComboBox<String>();
		comboBoxInit(course4, credit4, grade4);
		
		//Subject 5
		ComboBox<String> course5 = new ComboBox<String>();	
		ComboBox<Double> credit5 = new ComboBox<Double>();
		ComboBox<String> grade5 = new ComboBox<String>();
		comboBoxInit(course5, credit5, grade5);
		
		Label programName = new Label("NSU CGPA Calculator");
		programName.setFont(new Font(25));
		Label name = new Label("Name: ");
		Label id = new Label("ID: ");
		Label sub = new Label("Subject 1: ");
		Label space = new Label();
		space.setMinWidth(50);
		Label lb1 = new Label(" Course Code");
		lb1.setMinWidth(100);
		lb1.setAlignment(Pos.CENTER);
		Label lb2 = new Label(" Credit");
		lb2.setMinWidth(100);
		lb2.setAlignment(Pos.CENTER);
		Label lb3 = new Label(" Letter Grade");
		lb3.setMinWidth(100);
		lb3.setAlignment(Pos.CENTER);
		
		Button calc = new Button("Calculate");
		calc.setFont(new Font(20));
		calc.setMinSize(150, 50);
		calc.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					String s1 = course1.getSelectionModel().getSelectedItem(),
						   s2 = course2.getSelectionModel().getSelectedItem(),
						   s3 = course3.getSelectionModel().getSelectedItem(),
						   s4 = course4.getSelectionModel().getSelectedItem(),
						   s5 = course5.getSelectionModel().getSelectedItem();
					double c1 = credit1.getSelectionModel().getSelectedItem(),
						   c2 = credit2.getSelectionModel().getSelectedItem(),
						   c3 = credit3.getSelectionModel().getSelectedItem(),
						   c4 = credit4.getSelectionModel().getSelectedItem(),
						   c5 = credit5.getSelectionModel().getSelectedItem();
					String g1 = grade1.getSelectionModel().getSelectedItem(),
						   g2 = grade2.getSelectionModel().getSelectedItem(),
						   g3 = grade3.getSelectionModel().getSelectedItem(),
						   g4 = grade4.getSelectionModel().getSelectedItem(),
						   g5 = grade5.getSelectionModel().getSelectedItem();
					double cc = c1 + c2 + c3 + c4 + c5;
					double cgp = c1 * gradeToGp(g1) + c2 * gradeToGp(g2) + 
								 c3 * gradeToGp(g3) + c4 * gradeToGp(g4) +
								 c5 * gradeToGp(g5);
					
					double cgpa = (cc == 0)?0:cgp/cc;
					String stuName = tf1.getText().toString();
					String stuID = tf2.getText().toString();
					if (stuName.equals("") || stuID.equals(""))
						throw new Exception("Please fill out name and ID");
					DecimalFormat dc = new DecimalFormat("#.##");
					
					try {
						File obj = new File("results.txt");
						obj.createNewFile();
						FileWriter fw = new FileWriter("results.txt");
						fw.write("NSU CGPA Calculator\n" + "Result of " + stuName + " (" + stuID + ")\n\n");
						fw.write("\t\tCourse Code\tCredit\t\tGrade\n");
						fw.write("Subject 1:\t" + s1 + "\t\t" + String.valueOf(c1) + "\t\t" + g1 + "\n");
						fw.write("Subject 2:\t" + s2 + "\t\t" + String.valueOf(c2) + "\t\t" + g2 + "\n");
						fw.write("Subject 3:\t" + s3 + "\t\t" + String.valueOf(c3) + "\t\t" + g3 + "\n");
						fw.write("Subject 4:\t" + s4 + "\t\t" + String.valueOf(c4) + "\t\t" + g4 + "\n");
						fw.write("Subject 5:\t" + s5 + "\t\t" + String.valueOf(c5) + "\t\t" + g5 + "\n");
						fw.write("\nCGPA: " + dc.format(cgpa));
						fw.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					Alert al = new Alert(AlertType.INFORMATION);
					al.setContentText("Your CGPA: " + dc.format(cgpa));
					al.setTitle("Results");
					al.setHeaderText("Result of " + stuName + " (" + stuID + ")");
					al.show();
					
					Label cred = new Label("Result of " + stuName + " (" + stuID + ")");
					cred.setAlignment(Pos.CENTER);
					cred.setFont(new Font(20));
					Label lcourse1 = new Label(s1);
					Label lcredit1 = new Label(String.valueOf(c1));
					Label lgrade1 = new Label(g1);
					labelInit(lcourse1, lcredit1, lgrade1);
					
					Label lcourse2 = new Label(s2);
					Label lcredit2 = new Label(String.valueOf(c2));
					Label lgrade2 = new Label(g2);
					labelInit(lcourse2, lcredit2, lgrade2);
					
					Label lcourse3 = new Label(s3);
					Label lcredit3 = new Label(String.valueOf(c3));
					Label lgrade3 = new Label(g3);
					labelInit(lcourse3, lcredit3, lgrade3);
					
					Label lcourse4 = new Label(s4);
					Label lcredit4 = new Label(String.valueOf(c4));
					Label lgrade4 = new Label(g4);
					labelInit(lcourse4, lcredit4, lgrade4);
					
					Label lcourse5 = new Label(s5);
					Label lcredit5 = new Label(String.valueOf(c5));
					Label lgrade5 = new Label(g5);
					labelInit(lcourse5, lcredit5, lgrade5);
					
					Label sub = new Label("Subject 1: ");
					sub.setMinWidth(50);
					Label lcgpa = new Label("Your CGPA:");
					lcgpa.setFont(new Font(20));
					Label results = new Label(dc.format(cgpa));
					results.setFont(new Font(20));
					
					HBox hb = new HBox(20, space, lb1, lb2, lb3);
					hb.setAlignment(Pos.CENTER);
					HBox hb1 = new HBox(20, sub, lcourse1, lcredit1, lgrade1);
					hb1.setAlignment(Pos.CENTER);
					sub = new Label("Subject 2: ");
					HBox hb2 = new HBox(20, sub, lcourse2, lcredit2, lgrade2);
					hb2.setAlignment(Pos.CENTER);
					sub = new Label("Subject 3: ");
					HBox hb3 = new HBox(20, sub, lcourse3, lcredit3, lgrade3);
					hb3.setAlignment(Pos.CENTER);
					sub = new Label("Subject 4: ");
					HBox hb4 = new HBox(20, sub, lcourse4, lcredit4, lgrade4);
					hb4.setAlignment(Pos.CENTER);
					sub = new Label("Subject 5: ");
					HBox hb5 = new HBox(20, sub, lcourse5, lcredit5, lgrade5);
					hb5.setAlignment(Pos.CENTER);
					VBox vb1 = new VBox(10, lcgpa, results);
					vb1.setAlignment(Pos.CENTER);
					VBox vb2 = new VBox(20, hb, hb1, hb2, hb3, hb4, hb5);
					vb2.setAlignment(Pos.CENTER);
					VBox vb3 = new VBox(10, programName, cred);
					vb3.setAlignment(Pos.CENTER);
					VBox root = new VBox(30, vb3, vb2, vb1);
					root.setAlignment(Pos.CENTER);
					
					Scene scene = new Scene(root, 500, 500);
					
					primaryStage.setScene(scene);
					primaryStage.setTitle("NSU CGPA Calculator");
					primaryStage.show();
				} catch (Exception e) {
					Label error = new Label("*Please fill out every entry in the form*");
					error.setTextFill(Color.color(1,  0, 0));
					Label sub = new Label("Subject 1: ");
					sub.setMinWidth(50);
					
					HBox intro = new HBox(10, name, tf1, id, tf2);
					intro.setAlignment(Pos.TOP_CENTER);
					HBox hb = new HBox(20, space, lb1, lb2, lb3);
					hb.setAlignment(Pos.CENTER);
					HBox hb1 = new HBox(20, sub, course1, credit1, grade1);
					hb1.setAlignment(Pos.CENTER);
					sub = new Label("Subject 2: ");
					HBox hb2 = new HBox(20, sub, course2, credit2, grade2);
					hb2.setAlignment(Pos.CENTER);
					sub = new Label("Subject 3: ");
					HBox hb3 = new HBox(20, sub, course3, credit3, grade3);
					hb3.setAlignment(Pos.CENTER);
					sub = new Label("Subject 4: ");
					HBox hb4 = new HBox(20, sub, course4, credit4, grade4);
					hb4.setAlignment(Pos.CENTER);
					sub = new Label("Subject 5: ");
					HBox hb5 = new HBox(20, sub, course5, credit5, grade5);
					hb5.setAlignment(Pos.CENTER);
					VBox vb1 = new VBox(10, programName, intro);
					vb1.setAlignment(Pos.CENTER);
					VBox vb2 = new VBox(20, hb, hb1, hb2, hb3, hb4, hb5, error);
					vb2.setAlignment(Pos.CENTER);
					VBox root = new VBox(30, vb1, vb2, calc);
					root.setAlignment(Pos.CENTER);
					
					Scene scene = new Scene(root, 500, 500);
					
					primaryStage.setScene(scene);
					primaryStage.setTitle("NSU CGPA Calculator");
					primaryStage.show();
				}
			}
		});
		
		//Layout
		HBox intro = new HBox(10, name, tf1, id, tf2);
		intro.setAlignment(Pos.TOP_CENTER);
		HBox hb = new HBox(20, space, lb1, lb2, lb3);
		hb.setAlignment(Pos.CENTER);
		HBox hb1 = new HBox(20, sub, course1, credit1, grade1);
		hb1.setAlignment(Pos.CENTER);
		sub = new Label("Subject 2: ");
		HBox hb2 = new HBox(20, sub, course2, credit2, grade2);
		hb2.setAlignment(Pos.CENTER);
		sub = new Label("Subject 3: ");
		HBox hb3 = new HBox(20, sub, course3, credit3, grade3);
		hb3.setAlignment(Pos.CENTER);
		sub = new Label("Subject 4: ");
		HBox hb4 = new HBox(20, sub, course4, credit4, grade4);
		hb4.setAlignment(Pos.CENTER);
		sub = new Label("Subject 5: ");
		HBox hb5 = new HBox(20, sub, course5, credit5, grade5);
		hb5.setAlignment(Pos.CENTER);
		VBox vb1 = new VBox(10, programName, intro);
		vb1.setAlignment(Pos.CENTER);
		VBox vb2 = new VBox(20, hb, hb1, hb2, hb3, hb4, hb5);
		vb2.setAlignment(Pos.CENTER);
		VBox root = new VBox(30, vb1, vb2, calc);
		root.setAlignment(Pos.CENTER);
		
		//Scene
		Scene scene = new Scene(root, 500, 500);
		
		//Stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("NSU CGPA Calculator");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
