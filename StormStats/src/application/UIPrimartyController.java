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
	private CheckBox NewGame;
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
    private TableColumn<Encounter, Integer> KillsAssitsColumn;
	@FXML
    private TableColumn<Encounter, Integer> DeathsColumn;
	@FXML
    private TableColumn<Encounter, Integer> SiegeDmgColumn;
	@FXML
    private TableColumn<Encounter, Integer> HeroDmgColumn;
	@FXML
    private TableColumn<Encounter, Integer> HealingColumn;
	@FXML
    private TableColumn<Encounter, Integer> SelfHealingColumn;
    @FXML
    private TableColumn<Encounter, Integer> ExpSoakColumn;
    @FXML
    private TableColumn<Encounter, String> UserNameColumn;
    @FXML
    private TableColumn<Encounter, Boolean> SameTeamColumn;
    @FXML
    private TableColumn<Encounter, String> HeroColumn;
    
    
    ArrayList<Player> playerList = new ArrayList<Player>(); 
  
   
    @FXML
    private TableView<Player> PlayersTable;
    @FXML
    private TableColumn<Player, String> UsernamePlayerColumn;
    @FXML
    private TableColumn<Player, Double> AvgKillsAssitsColumn;
    @FXML
    private TableColumn<Player, Double> AvgDeathsColumn;
    @FXML
    private TableColumn<Player, Integer> AvgHeroDmgColumn;
    @FXML
    private TableColumn<Player, Integer> AvgSiegeDmgColumn;
    @FXML
    private TableColumn<Player, Integer> AvgHealingColumn;
    @FXML
    private TableColumn<Player, Integer> AvgSelfHealingColumn;
	
    ObservableList<Player> randomList = FXCollections.observableArrayList();
    
  
   // add new table for displaying playerList data 
    

   
    ObservableList<Encounter> encounterList = FXCollections.observableArrayList();
  

@Override
public void initialize(URL url, ResourceBundle rb) {
	initializeSQL();
	StatsTable.setItems(encounterList);
	
	KillsAssitsColumn.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("killsAssists"));
	DeathsColumn.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("deaths"));
	SiegeDmgColumn.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("siegeDmg"));
	HeroDmgColumn.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("heroDmg"));
	HealingColumn.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("healing"));
	SelfHealingColumn.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("selfHealing"));
	ExpSoakColumn.setCellValueFactory(new PropertyValueFactory<Encounter, Integer>("expSoak"));
	
	UserNameColumn.setCellValueFactory(new PropertyValueFactory<Encounter, String>("UserName"));
	SameTeamColumn.setCellValueFactory(new PropertyValueFactory<Encounter, Boolean>("SameTeam"));
	
	HeroColumn.setCellValueFactory(new PropertyValueFactory<Encounter, String>("hero"));
	
	StatsTable.setItems(encounterList);
	
	
	
	
	PlayersTable.setItems(randomList);
	UsernamePlayerColumn.setCellValueFactory(new PropertyValueFactory<Player, String>("UserName"));
	AvgKillsAssitsColumn.setCellValueFactory(new PropertyValueFactory<Player, Double>("AvgKillsAssits"));
	AvgDeathsColumn.setCellValueFactory(new PropertyValueFactory<Player, Double>("AvgDeaths"));
	AvgHeroDmgColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("AvgHeroDmg"));
	AvgSiegeDmgColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("AvgSiegeDmg"));
	AvgHealingColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("AvgHealing"));
	AvgSelfHealingColumn.setCellValueFactory(new PropertyValueFactory<Player, Integer>("AvgSelfHealing"));
	
	
	
	
	
	
	PlayersTable.setItems(randomList);
	
	
}

public void initializeSQL() {
	boolean playerAlreadyExists=false;
	
	try
    (
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/ssdatabase.db");
        Statement statement = connection.createStatement();
    ) {
		 statement.setQueryTimeout(30);
		 
		 
		 ResultSet rs2 = statement.executeQuery("select * from playergames");
         while(rs2.next())
         {
        	 int tempgamenumber2 =rs2.getInt("gamenumber");
        	 
        	 
        	 String tempuserhero= rs2.getString("userhero");
        	 int tempuserkillassits =rs2.getInt("userkillsassists");
        	 int tempuserdeaths =rs2.getInt("userdeaths");
        	 int tempusersiegedmg =rs2.getInt("usersiegedmg");
        	 int tempuserherodmg =rs2.getInt("userherodmg");
        	 int tempuserhealing =rs2.getInt("userhealing");
        	 int tempuserselfhealing =rs2.getInt("userselfhealing");
        	 int tempuserexpsoak =rs2.getInt("userexpsoak");
        	 String tempmap =rs2.getString("map");
        	 boolean tempwon =rs2.getBoolean("won");
        	 
        	 Statement statement2 = connection.createStatement();
        	 ResultSet rs = statement2.executeQuery("select * from encounters where gamenumber == " + tempgamenumber2);
        	 while(rs.next()) {
		         // read the result set
		    	 String tempusername= rs.getString("username");
		         int tempgamenumber =rs.getInt("gamenumber"); // dont need this for java but im reading it anyway just in case it needs to be read to be cleared or soemthing
		         int tempkillsassits =rs.getInt("killsassists");
		         int tempdeaths = rs.getInt("deaths");
		         int tempsiegedmg = rs.getInt("siegedmg");
		         int tempherodmg = rs.getInt("herodmg");
		         int temphealing = rs.getInt("healing");
		         int tempselfhealing = rs.getInt("selfhealing");
		         int tempexpsoak = rs.getInt("expsoak");
		         boolean tempsameteam = rs.getBoolean("sameteam");
		         String temphero= rs.getString("hero");
					
		         
		         Encounter encounter = new Encounter(
		     			tempusername,
		     			tempkillsassits, tempdeaths, tempsiegedmg, tempherodmg, temphealing, tempselfhealing, tempexpsoak, temphero, tempuserkillassits, tempuserdeaths, tempusersiegedmg, tempuserherodmg, tempuserhealing, tempuserselfhealing, tempuserexpsoak, tempuserhero, tempmap, tempwon, tempsameteam
		     	);
		     	this.encounterList.add(encounter);
		     	
		     	for(int i=0; i<randomList.size(); i++) {
					//if if Player has been encounterd before add that encounter to their player encounter List
					if(encounter.UserName.equals(randomList.get(i).UserName)) {
						randomList.get(i).newEncounter(randomList.get(i), encounter);
						playerAlreadyExists=true;
					}
					
				}
				// if no one with the same name was found make a new player object for them
				if(playerAlreadyExists==false) {
					randomList.add(new Player(tempusername, 0, 0, 0, 0, 0, 0, encounter));
				}
		     	
		     	//this.randomList.add(new Player(tempusername,0 ,0 ,0 ,0 ,0 ,0, encounter));
             }
         }
		 
		 
		 		connection.close();
	} 
	catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	//this.randomList.add(new Player("UserName", 0, 0, 0, 0, 0, 0, null));
}


	
	
	
	
	
	//this is for the submit button

	public void submit(ActionEvent e) {
		boolean noError=true;
		
		
		// the defualt values are ERROR values which should never show up
		String name="THIS IS ERROR"; 
		String heroOther="THIS IS ERROR";
		int killsAssists=-1;
		int deaths=-1;
		int siegeDmg=-1;
		int heroDmg=-1;
		Integer healing=-1;
		Integer selfHealing=-1;
		int expSoak=-1;
		
		
		String hero= "THIS IS ERROR";
		int userKillsAssists=-1; 
		int userDeaths=-1; 
		int userSiegeDmg=-1;
		int userHeroDmg=-1;
		Integer userHealing=-1; 
		Integer userSelfHealing=-1;
		int userExpSoak=-1;
		
		String Map="THIS IS ERROR";
		Boolean won=null; 
		Boolean SameTeam=null;
		Boolean newGame=false;
		
		
		
		
		
		//map
		try {
			Map = (MapName.getText().toLowerCase());
			//System.out.println(Map);
			
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
			if(OtherSelfHealing.getText().equals("")) {
				selfHealing=null;
			}
			else {
			selfHealing = (Integer.parseInt(OtherSelfHealing.getText()));
			OtherSelfHealing.setText("");
			}
			
		}
		catch(Exception E) {
			OtherSelfHealing.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		// Other Healing
		try {
			if(OtherHealing.getText().equals("")) {
				healing=null;
			}
			else {
			healing = (Integer.parseInt(OtherHealing.getText()));
			OtherHealing.setText("");
			}
			
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
			heroOther = HeroOther.getText().toLowerCase();
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

			
		}
		catch(Exception E) {
			UserEXP.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		
		//User Self Healing
		try {
			if(UserSelfHealing.getText().equals("")) {
			userSelfHealing=null;
			}
			else {
				userSelfHealing = (Integer.parseInt(UserSelfHealing.getText()));	
			}
			
			

			
		}
		catch(Exception E) {
			UserSelfHealing.setText("Error; non number");
			System.out.println(E);
			noError=false;
		}
		
		
		//User Healing
		try {
			if(UserHealing.getText().equals("")) {
				userHealing=null;
			}
			else {
			userHealing = (Integer.parseInt(UserHealing.getText()));
			}
			
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
			hero = (Hero.getText().toLowerCase());
			
			
			
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
		//new game checkbox
		try {
			newGame = (NewGame.isSelected());
			Won.setSelected(false);
			
		}
		catch(Exception E) {
			noError=false;
		}
		
		// if there were no wrong inputs create the encounter and sent it to the player list
		if(noError==true) {			
			EncounterSubmit(newGame,new Encounter( name ,killsAssists, deaths, siegeDmg, heroDmg, healing, selfHealing, expSoak, heroOther, userKillsAssists, userDeaths, userSiegeDmg, userHeroDmg, userHealing,userSelfHealing, userExpSoak, hero, Map,  won, SameTeam));
		}
		
		
	}
	
	

	public void EncounterSubmit(Boolean newgame,Encounter e) {
		boolean playerAlreadyExists=false;
		int currentgameNumber=0;
		encounterList.add(e);
		
		//would like to change this out for binary search/some other search
		for(int i=0; i<randomList.size(); i++) {
			//if if Player has been encounterd before add that encounter to their player encounter List
			if(e.UserName.equals(randomList.get(i).UserName)) {
				randomList.get(i).newEncounter(randomList.get(i), e);
				playerAlreadyExists=true;
			}
			
		}
		// if no one with the same name was found make a new player object for them
		if(playerAlreadyExists==false) {
			randomList.add(new Player(e.UserName, 0, 0, 0, 0, 0, 0, e));
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
				 ResultSet rs = statement.executeQuery("select max(gamenumber) from playergames");
				 while(rs.next()) {
					 // if if new game true +1 to game counter else no gamenumber=max gamenumber IE same game
					 if(newgame==true) {
					 currentgameNumber=rs.getInt(1)+1;
					 }
					 else {
						 currentgameNumber=rs.getInt(1);
					 }
				 }
			 }
			 
			 System.out.println("insert into playergames values("+"'"+e.UserName+"'"+","+currentgameNumber+","+ e.UserkillsAssists+","+ e.Userdeaths+","+ e.UsersiegeDmg+ ","+ e.UserheroDmg+","+ e.Userhealing+","+ e.UserselfHealing+ ","+ e.UserexpSoak+","+ "'"+ e.Map+"'"+","+ e.Won+","+"'"+e.UserHero+"'"+")" );
			 System.out.println("insert into encounters values("+"'"+e.UserName+"'"+","+ currentgameNumber+","+ e.killsAssists+","+ e.deaths+","+ e.siegeDmg+","+ e.heroDmg+","+ e.healing+","+ e.selfHealing+","+e.expSoak+","+e.SameTeam+","+"'"+e.hero+"'"+")");
			 
			//if theres not a new game there should only be one game per the encounters 
			if(newgame==true) {
			 statement.executeUpdate("insert into playergames values("+"'"+e.UserName+"'"+","+currentgameNumber+","+ e.UserkillsAssists+","+ e.Userdeaths+","+ e.UsersiegeDmg+ ","+ e.UserheroDmg+","+ e.Userhealing+","+ e.UserselfHealing+ ","+ e.UserexpSoak+","+ "'"+ e.Map+"'"+","+ e.Won+","+"'"+e.UserHero+"'"+")" );
			}
			 statement.executeUpdate("insert into encounters values("+"'"+e.UserName+"'"+","+ currentgameNumber+","+ e.killsAssists+","+ e.deaths+","+ e.siegeDmg+","+ e.heroDmg+","+ e.healing+","+ e.selfHealing+","+e.expSoak+","+e.SameTeam+","+"'"+e.hero+"'"+")");
			
			connection.close();
		} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
	}





}
