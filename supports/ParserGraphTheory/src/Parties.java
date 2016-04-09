
public class Parties {
	private String code;
	private String mnemonic;
	private String name;
	private String numberSeats;
	private String numberQuotes;
	
	public Parties(String code, String mnentonic, String name, String numberSeats, String numberQuotes) {
		super();
		this.code = code;
		this.mnemonic = mnentonic;
		this.name = name;
		this.numberSeats = numberSeats;
		this.numberQuotes = numberQuotes;
	}

	public Parties() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(String mnentonic) {
		this.mnemonic = mnentonic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumberSeats() {
		return numberSeats;
	}

	public void setNumberSeats(String numberSeats) {
		this.numberSeats = numberSeats;
	}

	public String getNumberQuotes() {
		return numberQuotes;
	}

	public void setNumberQuotes(String numberQuotes) {
		this.numberQuotes = numberQuotes;
	}
	
	
}
