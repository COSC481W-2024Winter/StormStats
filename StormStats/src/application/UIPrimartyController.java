package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	@FXML
	private CheckBox Won;
	@FXML
	private TextField MapName;
	@FXML
	private TextField Name;
	@FXML
	private TextField Hero;
	@FXML
	private TextField HeroOther;
	
	// this group is for the Stats table
    @FXML
    private TableView<Encounter> StatsTable;
    @FXML
    private TableColumn<Encounter, Integer> KillsAssitsTable;
	@FXML
    private TableColumn<Encounter, Integer> DeathsTable;
	@FXML
    private TableColumn<Encounter, Integer> SiegeDmgTable;
	@FXML
    private TableColumn<Encounter, Integer> HeroDmgTable;
	@FXML
    private TableColumn<Encounter, Integer> HealingTable;
	@FXML
    private TableColumn<Encounter, Integer> SelfHealingTable;
    @FXML
    private TableColumn<Encounter, Integer> ExpSoakTable;
    
    ArrayList<Player> playerList = new ArrayList<Player>(); 
  
   
    
    
    
  
   // add new table for displaying playerList data 
    

   
    ObservableList<Encounter> encounterList = FXCollections.observableArrayList(
    		
    		
    		//add 2* loop that gets all players then gets all encounters of that player
    		/* observable list accepts encountrs in this format
    		playerList.get(0).Encounters.get(0),  <-- it wants these commas inbetween
    		playerList.get(1).Encounters.get(1),
    		playerList.get(2).Encounters.get(2)
    		*/
    		
    		//these encounters are wrong because the conttructor updated
    		
    		//new Encounter (10,20,30,40,50,60,70),
    		//new Encounter (22,33,44,55,66,77,88),
    		//new Encounter (44,456,3215236,125,1251325,4563456,123)
    		
    		);
  

@Override
public void initialize(URL url, ResourceBundle rb) {
	initializeSQL();
	StatsTable.setItems(encounterList);
	
	
	
	KillsAssitsTable.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("killsAssists"));
	DeathsTable.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("deaths"));
	SiegeDmgTable.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("siegeDmg"));
	HeroDmgTable.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("heroDmg"));
	HealingTable.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("healing"));
	SelfHealingTable.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("selfHealing"));
	ExpSoakTable.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("expSoak"));
	
	StatsTable.setItems(encounterList);
	
}

public void initializeSQL() {
	
}


	
	
	
	
	
	//this is for the submit button

/*
 * TO DO: this method needs to be updated to create a Encounter object and then run EncounterSubmit when all feilds sucsefuly inputed
 * 
 */
	public void submit(ActionEvent e) {
		boolean noError=true;
		
		
		// the defualt values are ERROR values which should never show up
		String name="THIS IS ERROR"; 
		String heroOther="THIS IS ERROR";
		int killsAssists=-1;
		int deaths=-1;
		int siegeDmg=-1;
		int heroDmg=-1;
		int healing=-1;
		int selfHealing=-1;
		int expSoak=-1;
		
		
		String hero;
		int userKillsAssists=-1; 
		int userDeaths=-1; 
		int userSiegeDmg=-1;
		int userHeroDmg=-1;
		int userHealing=-1; 
		int userSelfHealing=-1;
		int userExpSoak=-1;
		
		String Map="THIS IS ERROR";
		Boolean won=null; 
		Boolean SameTeam=null;
		
		//map
		try {
			Map = (MapName.getText());
			
		}
		catch(Exception E) {
			OtherEXP.setText("Error; ??");
			System.out.println(E);
			noError=false;
		}
		
		// Other EXP soak
		try {
			expSoak = (Integer.parseInt(OtherEXP.getText()));
			OtherEXP.setText("");
			
		}
		catch(Exception E) {
			OtherEXP.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		//Other self Healing
		try {
			selfHealing = (Integer.parseInt(OtherSelfHealing.getText()));
			OtherSelfHealing.setText("");

			
		}
		catch(Exception E) {
			OtherSelfHealing.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		// Other Healing
		try {
			healing = (Integer.parseInt(OtherHealing.getText()));
			OtherHealing.setText("");

			
		}
		catch(Exception E) {
			OtherHealing.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		// Other Hero Dmg
		try {
			heroDmg = (Integer.parseInt(OtherHeroDmg.getText()));
			OtherHeroDmg.setText("");

			
		}
		catch(Exception E) {
			OtherHeroDmg.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		
		// Other SiegeDmg
		try {
			siegeDmg = (Integer.parseInt(OtherSiegeDmg.getText()));
			OtherSiegeDmg.setText("");

			
		}
		catch(Exception E) {
			OtherSiegeDmg.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		
		// Other deaths
		try {
			deaths = (Integer.parseInt(OtherDeaths.getText()));
			OtherDeaths.setText("");

			
		}
		catch(Exception E) {
			OtherDeaths.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		// other Kills Assits
		try {
			killsAssists = (Integer.parseInt(OtherKA.getText()));
			OtherKA.setText("");

			
		}
		catch(Exception E) {
			OtherKA.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		// hero other
		try {
			heroOther = HeroOther.getText();
			HeroOther.setText("");

			
		}
		catch(Exception E) {
			HeroOther.setText("Error");
			System.out.println(E);
			noError=false;
		}
		
		
		// User EXP
		try {
			userExpSoak = (Integer.parseInt(UserEXP.getText()));
			UserEXP.setText("");

			
		}
		catch(Exception E) {
			UserEXP.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		
		//User Self Healing
		try {
			userSelfHealing = (Integer.parseInt(UserSelfHealing.getText()));

			
		}
		catch(Exception E) {
			UserSelfHealing.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		
		//User Healing
		try {
			userHealing = (Integer.parseInt(UserHealing.getText()));

			
		}
		catch(Exception E) {
			UserHealing.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		
		try {
			userHeroDmg = (Integer.parseInt(UserHeroDmg.getText()));

			
		}
		catch(Exception E) {
			UserHeroDmg.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		//User SiegeDmg
		try {
			userSiegeDmg = (Integer.parseInt(UserSiegeDmg.getText()));

			
		}
		catch(Exception E) {
			UserSiegeDmg.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		//User Deaths
		try {
			userDeaths = (Integer.parseInt(UserDeaths.getText()));

			
		}
		catch(Exception E) {
			UserDeaths.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		//KillsAssits of User
		try {
			userKillsAssists = (Integer.parseInt(UserKA.getText()));
			
			
		}
		catch(Exception E) {
			UserKA.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		//need to add a check here to force correct names only
		//name of hero played by User
		try {
			hero = (Hero.getText());
			
			
		}
		catch(Exception E) {
			System.out.println(E);
			noError=false;
		}
		
		//User name of Other
		try {
			name = (Name.getText());
			Name.setText(null);
			
		}
		catch(Exception E) {
			System.out.println(E);
			noError=false;
		}
		
		//is team mate
		try {
			SameTeam = IsTeamMate.isSelected();
			IsTeamMate.setSelected(false);
			
		}
		catch(Exception E) {
			noError=false;
		}
		
		// won game
		try {
			won = (Won.isSelected());
			Won.setSelected(false);
			
		}
		catch(Exception E) {
			noError=false;
		}
		
		// if there were no wrong inputs create the encounter and sent it to the player list
		if(noError==true) {			
			EncounterSubmit(new Encounter( name ,killsAssists, deaths, siegeDmg, heroDmg, healing, selfHealing, expSoak, userKillsAssists, userDeaths, userSiegeDmg, userHeroDmg, userHealing,userSelfHealing, userExpSoak, Map, won, SameTeam));
		}
		
		
	}
	
	

	public void EncounterSubmit(Encounter e) {
		boolean playerAlreadyExists=false;
		int currentgameNumber=0;
		
		//would like to change this out for binary search/some other search
		for(int i=0; i<playerList.size(); i++) {
			//if if Player has been encounterd before add that encounter to their player encounter List
			if(e.UserName.equals(playerList.get(i).UserName)) {
				playerList.get(i).newEncounter(playerList.get(i), e);
				playerAlreadyExists=true;
			}
			
		}
		// if no one with the same name was found make a new player object for them
		if(playerAlreadyExists==false) {
			playerList.add(new Player(e.UserName, 0, 0, 0, 0, 0, 0, e));
		}
		
		
		//update SQLite database
		
		try
        (
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/ssdatabase.db");
            Statement statement = connection.createStatement();
        ) {
			 statement.setQueryTimeout(30);
			 
			 //get the current game number
			 if((Integer)statement.executeUpdate("select max(gamenumber) from playergames")==null) {
			//do nothing IE gamenumber=0	 
			 }
			 else {
				 currentgameNumber=statement.executeUpdate("select max(gamenumber) from playergames")+1;
			 }
			 
			 System.out.println("insert into playergames values("+"'"+e.UserName+"'"+ ","+currentgameNumber+","+ e.UserkillsAssists+","+ e.Userdeaths+","+ e.UsersiegeDmg+ ","+ e.UserheroDmg+","+ e.Userhealing+","+ e.UserselfHealing+ ","+ e.UserexpSoak+","+ "'"+e.Map+"'"+","+ e.Won+")");
			 System.out.println("insert into encounters values("+"'"+e.UserName+"'"+","+ currentgameNumber+","+ e.killsAssists+","+ e.deaths+","+ e.siegeDmg+","+ e.heroDmg+","+ e.healing+","+ e.selfHealing+","+e.expSoak+","+e.SameTeam+")");
			 
			 statement.executeUpdate("insert into playergames values("+"'"+e.UserName+"'"+","+currentgameNumber+","+ e.UserkillsAssists+","+ e.Userdeaths+","+ e.UsersiegeDmg+ ","+ e.UserheroDmg+","+ e.Userhealing+","+ e.UserselfHealing+ ","+ e.UserexpSoak+","+ "'"+ e.Map+"'"+","+ e.Won+")" );
			 statement.executeUpdate("insert into encounters values("+"'"+e.UserName+"'"+","+ currentgameNumber+","+ e.killsAssists+","+ e.deaths+","+ e.siegeDmg+","+ e.heroDmg+","+ e.healing+","+ e.selfHealing+","+e.expSoak+","+e.SameTeam+")");
			
			connection.close();
		} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
	}





}
