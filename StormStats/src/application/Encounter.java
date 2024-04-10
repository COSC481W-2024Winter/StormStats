package application;

public class Encounter {
	
	int killsAssists;
	int deaths;
	int siegeDmg;
	int heroDmg;
	Integer healing;
	Integer selfHealing;
	int expSoak;
	String hero;
	
	String UserHero;
	int UserkillsAssists;
	int Userdeaths;
	


	int UsersiegeDmg;
	int UserheroDmg;
	Integer Userhealing;
	Integer UserselfHealing;
	int UserexpSoak;
	
	String UserName;
	String Map;
	Boolean Won;
	Boolean SameTeam;
	
	




	public Encounter(String name,int killsAssists, int deaths, int siegeDmg, int heroDmg, Integer healing, Integer selfHealing, int expSoak, String hero, int userkillsAssists, int userdeaths, int usersiegeDmg, int userheroDmg, Integer userhealing,Integer userselfHealing, int userexpSoak,String userHero, String map, Boolean won, Boolean sameteam) {
		
		this.killsAssists = killsAssists;
		this.deaths = deaths;
		this.siegeDmg = siegeDmg;
		this.heroDmg = heroDmg;
		this.healing = healing;
		this.selfHealing = selfHealing;
		this.expSoak = expSoak;
		this.hero=hero;
		
		this.UserkillsAssists = userkillsAssists;
		this.Userdeaths = userdeaths;
		this.UsersiegeDmg = usersiegeDmg;
		this.UserheroDmg = userheroDmg;
		this.Userhealing = userhealing;
		this.UserselfHealing = userselfHealing;
		this.UserexpSoak = userexpSoak;
		this.UserHero=userHero;
		
		this.UserName=name;
		this.Map=map;
		this.Won=won;
		this.SameTeam=sameteam;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getMap() {
		return Map;
	}


	public void setMap(String map) {
		Map = map;
	}


	public Boolean getWon() {
		return Won;
	}


	public void setWon(Boolean won) {
		Won = won;
	}


	public Boolean getSameTeam() {
		return SameTeam;
	}


	public void setSameTeam(Boolean sameTeam) {
		SameTeam = sameTeam;
	}


	public int getUserkillsAssists() {
		return UserkillsAssists;
	}


	public void setUserkillsAssists(int userkillsAssists) {
		UserkillsAssists = userkillsAssists;
	}


	public int getUserdeaths() {
		return Userdeaths;
	}


	public void setUserdeaths(int userdeaths) {
		Userdeaths = userdeaths;
	}


	public int getUsersiegeDmg() {
		return UsersiegeDmg;
	}


	public void setUsersiegeDmg(int usersiegeDmg) {
		UsersiegeDmg = usersiegeDmg;
	}


	public int getUserheroDmg() {
		return UserheroDmg;
	}


	public void setUserheroDmg(int userheroDmg) {
		UserheroDmg = userheroDmg;
	}


	public Integer getUserhealing() {
		return Userhealing;
	}


	public void setUserhealing(int userhealing) {
		Userhealing = userhealing;
	}


	public Integer getUserselfHealing() {
		return UserselfHealing;
	}


	public void setUserselfHealing(int userselfHealing) {
		UserselfHealing = userselfHealing;
	}


	public int getUserexpSoak() {
		return UserexpSoak;
	}


	public void setUserexpSoak(int userexpSoak) {
		UserexpSoak = userexpSoak;
	}


	public int getKillsAssists() {
		return killsAssists;
	}


	public void setKillsAssists(int killsAssists) {
		this.killsAssists = killsAssists;
	}


	public int getDeaths() {
		return deaths;
	}


	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}


	public int getSiegeDmg() {
		return siegeDmg;
	}


	public void setSiegeDmg(int siegeDmg) {
		this.siegeDmg = siegeDmg;
	}


	public int getHeroDmg() {
		return heroDmg;
	}


	public void setHeroDmg(int heroDmg) {
		this.heroDmg = heroDmg;
	}


	public Integer getHealing() {
		return healing;
	}


	public void setHealing(int healing) {
		this.healing = healing;
	}


	public Integer getSelfHealing() {
		return selfHealing;
	}


	public void setSelfHealing(int selfHealing) {
		this.selfHealing = selfHealing;
	}


	public int getExpSoak() {
		return expSoak;
	}


	public void setExpSoak(int expSoak) {
		this.expSoak = expSoak;
	}
	public String getHero() {
		return hero;
	}


	public void setHero(String hero) {
		this.hero = hero;
	}


	public String getUserHero() {
		return UserHero;
	}


	public void setUserHero(String userHero) {
		UserHero = userHero;
	}


	public void setHealing(Integer healing) {
		this.healing = healing;
	}


	public void setSelfHealing(Integer selfHealing) {
		this.selfHealing = selfHealing;
	}


	public void setUserhealing(Integer userhealing) {
		Userhealing = userhealing;
	}


	public void setUserselfHealing(Integer userselfHealing) {
		UserselfHealing = userselfHealing;
	}
	
}



