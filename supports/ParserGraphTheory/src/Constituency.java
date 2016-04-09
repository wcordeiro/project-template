
public class Constituency {
	private String code;
	private String name;
	private String irishName;
	private String shortName;
	private String countTime;
	private String noCandidates;
	private String noSeats;
	private String quota;
	private String electorate;
	private String turnOut;
	private String percentTurnOut;
	private String spoiled;
	private String percentSpoiled;
	private String validPool;
	private String regionName;
	
	public Constituency(String code, String name, String irishName, String shortName, String countTime,
			String noCandidates, String noSeats, String quota, String electorate, String turnOut, String percentTurnOut,
			String spoiled, String percentSpoiled, String validPool, String regionName) {
		super();
		this.code = code;
		this.name = name;
		this.irishName = irishName;
		this.shortName = shortName;
		this.countTime = countTime;
		this.noCandidates = noCandidates;
		this.noSeats = noSeats;
		this.quota = quota;
		this.electorate = electorate;
		this.turnOut = turnOut;
		this.percentTurnOut = percentTurnOut;
		this.spoiled = spoiled;
		this.percentSpoiled = percentSpoiled;
		this.validPool = validPool;
		this.regionName = regionName;
	}
	
	public Constituency() {
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIrishName() {
		return irishName;
	}
	public void setIrishName(String irishName) {
		this.irishName = irishName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getCountTime() {
		return countTime;
	}
	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}
	public String getNoCandidates() {
		return noCandidates;
	}
	public void setNoCandidates(String noCandidates) {
		this.noCandidates = noCandidates;
	}
	public String getNoSeats() {
		return noSeats;
	}
	public void setNoSeats(String noSeats) {
		this.noSeats = noSeats;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getElectorate() {
		return electorate;
	}
	public void setElectorate(String electorate) {
		this.electorate = electorate;
	}
	public String getTurnOut() {
		return turnOut;
	}
	public void setTurnOut(String turnOut) {
		this.turnOut = turnOut;
	}
	public String getPercentTurnOut() {
		return percentTurnOut;
	}
	public void setPercentTurnOut(String percentTurnOut) {
		this.percentTurnOut = percentTurnOut;
	}
	public String getSpoiled() {
		return spoiled;
	}
	public void setSpoiled(String spoiled) {
		this.spoiled = spoiled;
	}
	public String getPercentSpoiled() {
		return percentSpoiled;
	}
	public void setPercentSpoiled(String percentSpoiled) {
		this.percentSpoiled = percentSpoiled;
	}
	public String getValidPool() {
		return validPool;
	}
	public void setValidPool(String validPool) {
		this.validPool = validPool;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
