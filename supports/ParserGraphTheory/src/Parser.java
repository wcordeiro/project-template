import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException; //http://www.java2s.com/Code/JarDownload/java/java-json.jar.zip
import org.json.JSONObject;

/* Delete whole database in neo4j
MATCH (n)
OPTIONAL MATCH (n)-[r]-()
DELETE n,r
 */

public class Parser {
	private List<Constituency> constituenciesList; // Hold the list of Constituencies
	private List<Candidates> CandidatesList; // Hold the list of Constituencies
	private List<Parties> Parties; // Hold the list of parties
	BufferedWriter bw;
	Integer index;
	
	public Parser(){
		this.constituenciesList = new ArrayList<Constituency>();
		this.Parties = new ArrayList<Parties>();
		this.CandidatesList = new ArrayList<Candidates>();
		try {
			bw = new BufferedWriter(new FileWriter("commands.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		index = 0;
	}
	
	
	public void parseJsonFiles() throws IOException{
		for(index = 1; index <= 40 ; index++){
			
		/*	Using Http request
		 * String url = "http://www.rte.ie/electionresults/2016/general/json/";
			
			if( index < 10)
				url+= "fullconstituency_c0"+ index.toString()+".json";
			else{
				url += "Data/fullconstituency_c"+ index.toString()+".json";
			}
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			// optional default is GET
			con.setRequestMethod("GET");

			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("content-type", "application/json");
			con.setRequestProperty("content-type", "text/html; charset=UTF-8");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println(response.toString());
			*/
			
			File fileDir;
			
			if( index < 10)
				fileDir = new File("C:\\Users\\Wilson\\workspace\\ParserGraphTheory\\Data\\fullconstituency_c0"+ index.toString()+".json");
			else{
				fileDir = new File("C:\\Users\\Wilson\\workspace\\ParserGraphTheory\\Data\\fullconstituency_c"+ index.toString()+".json");
			}
			
			BufferedReader in = new BufferedReader(
			   new InputStreamReader(
	                      new FileInputStream(fileDir), "UTF8"));
			
			String aux;
		    String finalString = new String();  
			while ((aux = in.readLine()) != null) {
			    finalString += aux;
			}
			in.close();
			this.createObjects(finalString.replace("'", ""));
			this.createCommand();
		}
		bw.close();
	}

	private void createCommand() throws IOException {
		
		String command = new String();
		//command += "Create";
		command += this.createConstituencyCommand() + "\n";
		command += this.createPartiesCommand() + "\n";
		command += this.createCandidatesCommand();
		this.CandidatesList.clear();
		this.Parties.clear();
		bw.write((command.replace('-', '_')).replace('*', '-'));
		//bw.close();
		
	}
	
	private String replaceMacro(String aux){
		return (((((aux.replace("'","")).replace("(", "")).replace(")","")).replace(' ', '_').replace('\'', '_')).replace('.', '_'));
	}

	private String createRelationConstituencyParties(Parties party) {
		String command = new String();
		command = "("+replaceMacro(party.getName())+"_"+replaceMacro(this.constituenciesList.get(index-1).getName())+")*[:IN]*>("+replaceMacro(this.constituenciesList.get(index-1).getName())+")";
		return command;
	}

	private String createCandidatesCommand() {
		String command = new String();
		for(Integer k = 0; k < this.CandidatesList.size(); k++){
			Candidates candidate = this.CandidatesList.get(k); 	
			command += "("+replaceMacro(candidate.getSurName())+"_"+replaceMacro(candidate.getFirstName())+"_"+replaceMacro(constituenciesList.get(index-1).getName())+":Candidate{";
			command += "firstName: '" + candidate.getFirstName() +"', ";
			command += "SurName: '" + candidate.getSurName().replace('\'', '_') +"', ";
			command += "sitting: '" + candidate.getSitting() +"', ";
			command += "gender: '" + candidate.getGender() +"', ";
			command += "currentStatus: '" + candidate.getCurrentStatus() +"'}),\n";
			command += this.createRelationCandidateParties(candidate);
			command += ",\n";
			command += this.createRelationCandidateConstituency(candidate);
			command += ",\n";
		}
		return command;
	}

	private String createRelationCandidateConstituency(Candidates candidate) {
		String command = new String();
		command = "("+replaceMacro(candidate.getSurName())+"_"+replaceMacro(candidate.getFirstName())+"_"+replaceMacro(constituenciesList.get(index-1).getName())+")*[:RAN_FOR]*>("+replaceMacro(constituenciesList.get(index-1).getName())+")";
		return command;
	}

	private String createRelationCandidateParties(Candidates candidate) {
		String command = new String();
		command = "("+replaceMacro(candidate.getSurName())+"_"+replaceMacro(candidate.getFirstName())+"_"+replaceMacro(constituenciesList.get(index-1).getName())+")*[:BELONGS_TO]*>("+replaceMacro(candidate.getPartyName())+"_"+replaceMacro(this.constituenciesList.get(index-1).getName())+")";
		return command;
	}

	private String createPartiesCommand() {
		String command = new String();
		for(Integer k = 0; k < Parties.size(); k++){
			Parties party = this.Parties.get(k); 	
			command += "("+replaceMacro(party.getName())+"_"+replaceMacro(this.constituenciesList.get(index-1).getName())+":Party{";
			command += "name: '" + party.getName() +"', ";
			command += "numberSeats: " + party.getNumberSeats() +", ";
			command += "numberQuotes: " + party.getNumberQuotes() +"}),\n";
			command += this.createRelationConstituencyParties(party);
			command += ",";
		}
		return command;
	}

	private String createConstituencyCommand() {
		Constituency constituency = this.constituenciesList.get(index-1); 
		String command = new String();
		command += "("+replaceMacro(constituency.getName())+":Constituency{";
		command += "name: '" + constituency.getName() +"', ";
		command += "irishName: '" + constituency.getIrishName() +"', ";
		command += "shortName: '" + constituency.getShortName() +"', ";
		command += "countTime: '" + constituency.getCountTime() +"', ";
		command += "noCandidates: " + constituency.getNoCandidates() +", ";
		command += "noSeats: " + constituency.getNoSeats() +", ";
		command += "quota: '" + constituency.getQuota() +"', ";
		command += "electorate: " + constituency.getElectorate().replace(",","") +", ";
		command += "turnout: " + constituency.getTurnOut().replace(",","") +", ";
		command += "percentTurnout: '" + constituency.getPercentTurnOut() +"', ";
		command += "spoiled: '" + constituency.getSpoiled() +"', ";
		command += "percentSpoiled: '" + constituency.getPercentSpoiled() +"', ";
		command += "validPool: '" + constituency.getValidPool() +"', ";
		command += "RegionName: '" + constituency.getRegionName() +"'}),";
		return command;
	}

	private void createObjects(String finalString) {
		this.createConstituency(finalString);
		this.createParties(finalString);
		this.createCandidates(finalString);
	}

	private void createCandidates(String finalString) {
		try {
			JSONObject obj;
			obj = new JSONObject(finalString);
			JSONObject objElection = obj.getJSONObject("ELECTION");
			JSONArray candidatesArray = objElection.getJSONArray("CANDIDATES");
			for(Integer i = 0; i < candidatesArray.length(); i++){
				JSONObject objCandidate = candidatesArray.getJSONObject(i);
				Candidates candidate = new Candidates();
				candidate.setFirstName(objCandidate.getString("FIRSTNAME"));
				candidate.setSurName(objCandidate.getString("SURNAME"));
				candidate.setSitting(objCandidate.getString("SITTING"));
				candidate.setGender(objCandidate.getString("GENDER"));
				candidate.setPartyId(objCandidate.getString("PARTY_ID"));
				candidate.setPartyName(objCandidate.getString("PARTY_NAME"));
				candidate.setCurrentStatus(objCandidate.getString("CURRENT_STATUS"));
				this.CandidatesList.add(candidate);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void createParties(String finalString) {
		try {
			JSONObject obj = new JSONObject(finalString);
			JSONObject objElection = obj.getJSONObject("ELECTION");
			JSONArray partiesArray = objElection.getJSONArray("PARTIES");
			for(Integer i = 0; i < partiesArray.length(); i++){
				JSONObject objParty = partiesArray.getJSONObject(i);
				Parties party = new Parties();
				party.setCode(objParty.getString("CODE"));
				party.setName(objParty.getString("PARTY_NAME"));
				JSONArray seatsArray = objParty.getJSONArray("SEATS");
				for(Integer j = 0; j < seatsArray.length(); j++){
					JSONObject objSeats = seatsArray.getJSONObject(j);
					if(objSeats.getString("NUMBER").equals("2016")){
						party.setNumberSeats(objSeats.getString("NUMBER_SEATS"));
					}
				}
				JSONArray quotasArray = objParty.getJSONArray("QUOTAS");
				for(Integer j = 0; j < quotasArray.length(); j++){
					JSONObject objSeats = quotasArray.getJSONObject(j);
					if(objSeats.getString("NUMBER").equals("2016")){
						party.setNumberSeats(objSeats.getString("NUMBER_QUOTAS"));
					}
				}
				this.Parties.add(party);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void createConstituency(String finalString) {
		try {
			Constituency constituency = new Constituency();
			JSONObject obj = new JSONObject(finalString);
			JSONObject objElection = obj.getJSONObject("ELECTION");
			JSONObject objSummary = objElection.getJSONObject("SUMMARY");
			constituency.setCode(objSummary.getString("CONSTITUENCY"));
			constituency.setName(objSummary.getString("NAME"));
			constituency.setIrishName(objSummary.getString("CONSTITUENCY_IRISH_NAME"));
			constituency.setShortName(objSummary.getString("CONSTITUECY_SHORT_NAME"));
			constituency.setCountTime(objSummary.getString("COUNT_TIME"));
			constituency.setNoCandidates(objSummary.getString("NOCANDIDATES"));
			constituency.setNoSeats(objSummary.getString("NOSEATS"));
			constituency.setQuota(objSummary.getString("QUOTA"));
			constituency.setElectorate(objSummary.getString("ELECTORATE"));
			constituency.setTurnOut(objSummary.getString("TURNOUT"));
			constituency.setPercentTurnOut(objSummary.getString("PERCENTTURNOUT"));
			constituency.setSpoiled(objSummary.getString("SPOILED"));
			constituency.setPercentSpoiled(objSummary.getString("PERCENTSPOILED"));
			constituency.setValidPool(objSummary.getString("VALIDPOLL"));
			constituency.setRegionName(objSummary.getString("REGION_NAME"));
			this.constituenciesList.add(constituency);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
