package application;

public class Player {
	
	int killsAssists;
	int deaths;
	int siegeDmg;
	int heroDmg;
	int healing;
	int selfHealing;
	int expSoak;
	

	public Player(int killsAssists, int deaths, int siegeDmg, int heroDmg, int healing, int selfHealing,int expSoak ) {
		this.killsAssists=killsAssists;
		this.deaths=deaths;
		this.siegeDmg=siegeDmg;
		this.heroDmg=heroDmg;
		this.healing=healing;
		this.selfHealing=selfHealing;
		this.expSoak=expSoak;	
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


	public int getHealing() {
		return healing;
	}


	public void setHealing(int healing) {
		this.healing = healing;
	}


	public int getSelfHealing() {
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
	
}



