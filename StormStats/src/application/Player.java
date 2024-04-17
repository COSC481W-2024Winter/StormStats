package application;

import java.util.ArrayList;

public class Player {

	
	String UserName;
	double AvgKillsAssits;
	double AvgDeaths;
	int AvgHeroDmg;
	int AvgSiegeDmg;
	int AvgHealing;
	int AvgSelfHealing;
	ArrayList<Encounter> Encounters;
	
	public Player(String userName, double avgKillsAssits, double avgDeaths, int avgHeroDmg, int avgSiegeDmg, int avgHealing,int avgSelfHealing, Encounter Encounter) {
		
		UserName = userName;
		AvgKillsAssits = avgKillsAssits;
		AvgDeaths = avgDeaths;
		AvgHeroDmg = avgHeroDmg;
		AvgSiegeDmg = avgSiegeDmg;
		AvgHealing = avgHealing;
		AvgSelfHealing=avgSelfHealing;
		Encounters= new ArrayList<Encounter>();
		newEncounter(this,Encounter);
	}
	
	
	public void newEncounter(Player player, Encounter encounter) {
		if(encounter != null) {
			player.Encounters.add(encounter);
			updateAverages(player);	
		}		
	}




	private void updateAverages(Player player) {
		int KillsAssitsCount=0;
		int DeathsCount=0;
		int HeroDmgCount=0;
		int SiegeDmgCount=0;
		Integer HealingCount=0;
		Integer SelfHealingCount=0;
		
		
		
		for(int i=0; i<player.Encounters.size(); i++) {
			
			KillsAssitsCount=  KillsAssitsCount+player.Encounters.get(i).getKillsAssists();
			DeathsCount     =  DeathsCount+player.Encounters.get(i).getDeaths();
			HeroDmgCount    =  HeroDmgCount+player.Encounters.get(i).getHeroDmg();
			SiegeDmgCount   =  SiegeDmgCount+player.Encounters.get(i).getSiegeDmg();
			if(player.Encounters.get(i).getHealing()==null) {
				
			}
			else {
			HealingCount    =  HealingCount+player.Encounters.get(i).getHealing();
			}
			
			if(player.Encounters.get(i).getSelfHealing()==null) {
				//if null value do nothing else act normal
			}
			else {
			SelfHealingCount=  SelfHealingCount+player.Encounters.get(i).getSelfHealing();
			}
			
		}
		
		player.AvgKillsAssits=KillsAssitsCount/Encounters.size();
		player.AvgDeaths=DeathsCount/Encounters.size();
		player.AvgHeroDmg=HeroDmgCount/Encounters.size();
		player.AvgSiegeDmg=SiegeDmgCount/Encounters.size();
		player.AvgHealing=HealingCount/Encounters.size();
		player.AvgSelfHealing=SelfHealingCount/Encounters.size();
		
		
	}
	
	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public double getAvgKillsAssits() {
		return AvgKillsAssits;
	}


	public void setAvgKillsAssits(double avgKillsAssits) {
		AvgKillsAssits = avgKillsAssits;
	}


	public double getAvgDeaths() {
		return AvgDeaths;
	}


	public void setAvgDeaths(double avgDeaths) {
		AvgDeaths = avgDeaths;
	}


	public int getAvgHeroDmg() {
		return AvgHeroDmg;
	}


	public void setAvgHeroDmg(int avgHeroDmg) {
		AvgHeroDmg = avgHeroDmg;
	}


	public int getAvgSiegeDmg() {
		return AvgSiegeDmg;
	}


	public void setAvgSiegeDmg(int avgSiegeDmg) {
		AvgSiegeDmg = avgSiegeDmg;
	}


	public int getAvgHealing() {
		return AvgHealing;
	}


	public void setAvgHealing(int avgHealing) {
		AvgHealing = avgHealing;
	}


	public int getAvgSelfHealing() {
		return AvgSelfHealing;
	}


	public void setAvgSelfHealing(int avgSelfHealing) {
		AvgSelfHealing = avgSelfHealing;
	}


	public ArrayList<Encounter> getEncounters() {
		return Encounters;
	}


	public void setEncounters(ArrayList<Encounter> encounters) {
		Encounters = encounters;
	}


	

}
