package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UIPrimartyController implements Initializable {
	
	
	//this group is all of the text feilds and CheckBox for Manual Input tab
	@FXML
	private TextField UserKA;
	@FXML
	private TextField UserDeaths;
	@FXML
	private TextField UserSiegeDmg;
	@FXML
	private TextField UserHeroDmg;
	@FXML
	private TextField UserHealing;
	@FXML
	private TextField UserSelfHealing;
	@FXML
	private TextField UserEXP;
	@FXML
	private TextField OtherKA;
	@FXML
	private TextField OtherDeaths;
	@FXML
	private TextField OtherSiegeDmg;
	@FXML
	private TextField OtherHeroDmg;
	@FXML
	private TextField OtherHealing;
	@FXML
	private TextField OtherSelfHealing;
	@FXML
	private TextField OtherEXP;
	@FXML
	private CheckBox IsTeamMate;
	
	// this group is for the Stats table
    @FXML
    private TableView<Player> StatsTable;
    @FXML
    private TableColumn<Player, Integer> KillsAssitsTable;
	@FXML
    private TableColumn<Player, Integer> DeathsTable;
	@FXML
    private TableColumn<Player, Integer> SiegeDmgTable;
	@FXML
    private TableColumn<Player, Integer> HeroDmgTable;
	@FXML
    private TableColumn<Player, Integer> HealingTable;
	@FXML
    private TableColumn<Player, Integer> SelfHealingTable;
    @FXML
    private TableColumn<Player, Integer> ExpSoakTable;
    
    
    
  
    
    

    
    ObservableList<Player> list = FXCollections.observableArrayList(
    		
    		new Player (1,2,3,4,5,6,7),
    		new Player (1,2,3,4,5,6,7),
    		new Player (1,2,3,4,5,6,7)
    		
    		);
  

@Override
public void initialize(URL url, ResourceBundle rb) {
	
	KillsAssitsTable.setCellValueFactory(new PropertyValueFactory<Player, Integer>("killsAssists"));
	DeathsTable.setCellValueFactory(new PropertyValueFactory<Player, Integer>("deaths"));
	SiegeDmgTable.setCellValueFactory(new PropertyValueFactory<Player, Integer>("siegeDmg"));
	HeroDmgTable.setCellValueFactory(new PropertyValueFactory<Player, Integer>("heroDmg"));
	HealingTable.setCellValueFactory(new PropertyValueFactory<Player, Integer>("healing"));
	SelfHealingTable.setCellValueFactory(new PropertyValueFactory<Player, Integer>("selfHealing"));
	ExpSoakTable.setCellValueFactory(new PropertyValueFactory<Player, Integer>("expSoak"));
	
	StatsTable.setItems(list);
	
}
	
	
	
	
	
	//this is for the submit button
	public void submit(ActionEvent e) {
		System.out.println(UserKA.getText());
		
		try {
			int test = Integer.parseInt(UserKA.getText());
			UserKA.setText(null);
			
		}
		catch(Exception E) {
			UserKA.setText("Error non number");
		}
		
		
		System.out.println(IsTeamMate.isSelected());
		
		
	}





}
