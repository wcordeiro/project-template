# Irish Constituencies Neo4j Database
###### Wilson Cordeiro, G00330453

## Introduction
The main objective of this assignment is get the students update with the graph technology and how the same is used those days.

The assigment uses the Neo4j database in order to facilitate the understandment and use of graphs.
The project's objective is to build a Graph Database using the Neo4j interface, and run some queries using the cypher language.

The Database must be about the general election hold in Ireland in 2016.

The Databae will hold information about constituencies, parties and candidates of this election.  

## Database
The first challenge in building the database was finding a reliable and accessible source of information. The main sources are inclomplete or not easy to access or parse. 

After a few failures I found the [RTE page](http://www.rte.ie/news/election-2016/), where the information can be accessed by a JSON formatted response.

![RTE page](https://github.com/wcordeiro/project-template/blob/master/supports/images/RTE.JPG) 
The information in this website is divided by constituencies and the JSON format is really easy to parse.

Example of JSON response.
```json
{
  "ELECTION": {
    "YEAR": "2016",
    "TITLE": "Full Constituency",
    "GENERATED": "2016-02-27 23:54:15Z",
    "SUMMARY": {
      "CONSTITUENCY": "C01",
      "NAME": "Carlow-Kilkenny",
      "CONSTITUENCY_IRISH_NAME": "Ceatharlach-Cill Chainnigh",
      "CONSTITUECY_SHORT_NAME": "Carlow-Kilk",
      "COUNT_TIME": "2016-02-27 23:54:12Z",
      "NOCANDIDATES": "15",
      "NOSEATS": "5",
      "QUOTA": "11,669",
      "ELECTORATE": "107,023",
      "TURNOUT": "70,514",
      "PERCENTTURNOUT": "65.9",
      "SPOILED": "505",
      "PERCENTSPOILED": "0.7",
      "VALIDPOLL": "70,009",
      "CONS_STATUS": "Complete",
      "CURRENT_COUNT": "11",
      "RECOUNTINPROGRESS": "No",
      "REGION_ID": "R03",
      "REGION_NAME": "Leinster (Excl Dublin)",
      "REGION_IRISH_NAME": "Laighin",
      "REGION_SHORT_NAME": "Leinster (Ex Dublin)"
    },
    "CANDIDATES": [
      {
        "NUMBER": "01",
        "CANDIDATE_ID": "1",
        "FIRSTNAME": "Bobby",
        "SURNAME": "AYLWARD",
        "SITTING": "Yes",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P03",
        "PARTY_MNEMONIC": "FF",
        "PARTY_NAME": "Fianna Fáil",
        "LAST_ACTIVE_COUNT": "11",
        "CURRENT_STATUS": "Elected",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "9366",
            "PERCENTFIRSTPREF": "13.4",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "9375",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "9",
            "PERCENT_TRANSFERS": "1.5"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "9469",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "94",
            "PERCENT_TRANSFERS": "8.2"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "9491",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "22",
            "PERCENT_TRANSFERS": "1.8"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "9549",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "58",
            "PERCENT_TRANSFERS": "2.5"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "9803",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "254",
            "PERCENT_TRANSFERS": "8.5"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "9956",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "153",
            "PERCENT_TRANSFERS": "4.2"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "10030",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "74",
            "PERCENT_TRANSFERS": "31.6"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "10634",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "604",
            "PERCENT_TRANSFERS": "10.8"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "11077",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "443",
            "PERCENT_TRANSFERS": "6.7"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "11335",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "258",
            "PERCENT_TRANSFERS": "10.2"
          }
        ]
      },
      {
        "NUMBER": "02",
        "CANDIDATE_ID": "2",
        "FIRSTNAME": "Pat",
        "SURNAME": "DEERING",
        "SITTING": "Yes",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P01",
        "PARTY_MNEMONIC": "FG",
        "PARTY_NAME": "Fine Gael",
        "LAST_ACTIVE_COUNT": "11",
        "CURRENT_STATUS": "Elected",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "6562",
            "PERCENTFIRSTPREF": "9.4",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "6580",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "18",
            "PERCENT_TRANSFERS": "2.9"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "6606",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "26",
            "PERCENT_TRANSFERS": "2.3"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "6623",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "17",
            "PERCENT_TRANSFERS": "1.4"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "6693",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "70",
            "PERCENT_TRANSFERS": "3.0"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "6829",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "136",
            "PERCENT_TRANSFERS": "4.5"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "6937",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "108",
            "PERCENT_TRANSFERS": "3.0"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "6940",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "3",
            "PERCENT_TRANSFERS": "1.3"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "7675",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "735",
            "PERCENT_TRANSFERS": "13.1"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "8935",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "1260",
            "PERCENT_TRANSFERS": "19.1"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "11149",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "2214",
            "PERCENT_TRANSFERS": "87.5"
          }
        ]
      },
      {
        "NUMBER": "03",
        "CANDIDATE_ID": "3",
        "FIRSTNAME": "David",
        "SURNAME": "FITZGERALD",
        "SITTING": "No",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P01",
        "PARTY_MNEMONIC": "FG",
        "PARTY_NAME": "Fine Gael",
        "LAST_ACTIVE_COUNT": "09",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "5017",
            "PERCENTFIRSTPREF": "7.2",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "5021",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "4",
            "PERCENT_TRANSFERS": "0.6"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "5094",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "73",
            "PERCENT_TRANSFERS": "6.4"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "5106",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "12",
            "PERCENT_TRANSFERS": "1.0"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "5122",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "16",
            "PERCENT_TRANSFERS": "0.7"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "5355",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "233",
            "PERCENT_TRANSFERS": "7.8"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "5686",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "331",
            "PERCENT_TRANSFERS": "9.0"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "5721",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "35",
            "PERCENT_TRANSFERS": "15.0"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "6588",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "867",
            "PERCENT_TRANSFERS": "15.5"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "-6588",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "04",
        "CANDIDATE_ID": "4",
        "FIRSTNAME": "Kathleen",
        "SURNAME": "FUNCHION",
        "SITTING": "No",
        "GENDER": "Female",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P04",
        "PARTY_MNEMONIC": "SF",
        "PARTY_NAME": "Sinn Féin",
        "LAST_ACTIVE_COUNT": "10",
        "CURRENT_STATUS": "Elected",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "8700",
            "PERCENTFIRSTPREF": "12.4",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "8838",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "138",
            "PERCENT_TRANSFERS": "22.3"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "8891",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "53",
            "PERCENT_TRANSFERS": "4.6"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "9094",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "203",
            "PERCENT_TRANSFERS": "16.5"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "9856",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "762",
            "PERCENT_TRANSFERS": "32.5"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "10228",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "372",
            "PERCENT_TRANSFERS": "12.4"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "10934",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "706",
            "PERCENT_TRANSFERS": "19.3"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "10970",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "36",
            "PERCENT_TRANSFERS": "15.4"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "11516",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "546",
            "PERCENT_TRANSFERS": "9.8"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "11720",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "204",
            "PERCENT_TRANSFERS": "3.1"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "11720",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "05",
        "CANDIDATE_ID": "5",
        "FIRSTNAME": "Keith",
        "SURNAME": "GILLIGAN",
        "SITTING": "No",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P09",
        "PARTY_MNEMONIC": "IND",
        "PARTY_NAME": "Independent",
        "LAST_ACTIVE_COUNT": "01",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "456",
            "PERCENTFIRSTPREF": "0.7",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "-456",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "06",
        "CANDIDATE_ID": "6",
        "FIRSTNAME": "Conor",
        "SURNAME": "MacLIAM",
        "SITTING": "No",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P05",
        "PARTY_MNEMONIC": "AAA-PBP",
        "PARTY_NAME": "Anti-Austerity Alliance-People Before Profit",
        "LAST_ACTIVE_COUNT": "03",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "1120",
            "PERCENTFIRSTPREF": "1.6",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "1179",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "59",
            "PERCENT_TRANSFERS": "9.5"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "1231",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "52",
            "PERCENT_TRANSFERS": "4.6"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "-1231",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "07",
        "CANDIDATE_ID": "7",
        "FIRSTNAME": "Paddy",
        "SURNAME": "MANNING",
        "SITTING": "No",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P09",
        "PARTY_MNEMONIC": "IND",
        "PARTY_NAME": "Independent",
        "LAST_ACTIVE_COUNT": "02",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "1078",
            "PERCENTFIRSTPREF": "1.5",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "1142",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "64",
            "PERCENT_TRANSFERS": "10.3"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "-1142",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "08",
        "CANDIDATE_ID": "8",
        "FIRSTNAME": "John",
        "SURNAME": "McGUINNESS",
        "SITTING": "Yes",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P03",
        "PARTY_MNEMONIC": "FF",
        "PARTY_NAME": "Fianna Fáil",
        "LAST_ACTIVE_COUNT": "07",
        "CURRENT_STATUS": "Elected",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "10528",
            "PERCENTFIRSTPREF": "15.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "10545",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "17",
            "PERCENT_TRANSFERS": "2.7"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "10823",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "278",
            "PERCENT_TRANSFERS": "24.3"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "10886",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "63",
            "PERCENT_TRANSFERS": "5.1"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "10965",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "79",
            "PERCENT_TRANSFERS": "3.4"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "11490",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "525",
            "PERCENT_TRANSFERS": "17.5"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "11903",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "413",
            "PERCENT_TRANSFERS": "11.3"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "11903",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "11903",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "11903",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "11903",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "09",
        "CANDIDATE_ID": "9",
        "FIRSTNAME": "Patrick",
        "SURNAME": "McKEE",
        "SITTING": "No",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P06",
        "PARTY_MNEMONIC": "RN",
        "PARTY_NAME": "Renua Ireland",
        "LAST_ACTIVE_COUNT": "05",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "2483",
            "PERCENTFIRSTPREF": "3.5",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "2511",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "28",
            "PERCENT_TRANSFERS": "4.5"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "2656",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "145",
            "PERCENT_TRANSFERS": "12.7"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "2752",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "96",
            "PERCENT_TRANSFERS": "7.8"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "3005",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "253",
            "PERCENT_TRANSFERS": "10.8"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "-3005",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "10",
        "CANDIDATE_ID": "10",
        "FIRSTNAME": "Jennifer",
        "SURNAME": "MURNANE O'CONNOR",
        "SITTING": "No",
        "GENDER": "Female",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P03",
        "PARTY_MNEMONIC": "FF",
        "PARTY_NAME": "Fianna Fáil",
        "LAST_ACTIVE_COUNT": "11",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "8373",
            "PERCENTFIRSTPREF": "12.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "8436",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "63",
            "PERCENT_TRANSFERS": "10.2"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "8502",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "66",
            "PERCENT_TRANSFERS": "5.8"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "8540",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "38",
            "PERCENT_TRANSFERS": "3.1"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "8745",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "205",
            "PERCENT_TRANSFERS": "8.8"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "8919",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "174",
            "PERCENT_TRANSFERS": "5.8"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "9023",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "104",
            "PERCENT_TRANSFERS": "2.8"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "9049",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "26",
            "PERCENT_TRANSFERS": "11.1"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "9371",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "322",
            "PERCENT_TRANSFERS": "5.8"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "9459",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "88",
            "PERCENT_TRANSFERS": "1.3"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "9518",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "59",
            "PERCENT_TRANSFERS": "2.3"
          }
        ]
      },
      {
        "NUMBER": "11",
        "CANDIDATE_ID": "11",
        "FIRSTNAME": "Malcolm",
        "SURNAME": "NOONAN",
        "SITTING": "No",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P10",
        "PARTY_MNEMONIC": "GP",
        "PARTY_NAME": "Green Party",
        "LAST_ACTIVE_COUNT": "06",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "2621",
            "PERCENTFIRSTPREF": "3.7",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "2655",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "34",
            "PERCENT_TRANSFERS": "5.5"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "2717",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "62",
            "PERCENT_TRANSFERS": "5.4"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "2816",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "99",
            "PERCENT_TRANSFERS": "8.0"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "3208",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "392",
            "PERCENT_TRANSFERS": "16.7"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "3660",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "452",
            "PERCENT_TRANSFERS": "15.0"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "-3660",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "12",
        "CANDIDATE_ID": "12",
        "FIRSTNAME": "Ann",
        "SURNAME": "PHELAN",
        "SITTING": "Yes",
        "GENDER": "Female",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P02",
        "PARTY_MNEMONIC": "LAB",
        "PARTY_NAME": "Labour Party",
        "LAST_ACTIVE_COUNT": "08",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "4391",
            "PERCENTFIRSTPREF": "6.3",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "4396",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "5",
            "PERCENT_TRANSFERS": "0.8"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "4442",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "46",
            "PERCENT_TRANSFERS": "4.0"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "4465",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "23",
            "PERCENT_TRANSFERS": "1.9"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "4548",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "83",
            "PERCENT_TRANSFERS": "3.5"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "4740",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "192",
            "PERCENT_TRANSFERS": "6.4"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "5566",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "826",
            "PERCENT_TRANSFERS": "22.6"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "5596",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "30",
            "PERCENT_TRANSFERS": "12.8"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "-5596",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "13",
        "CANDIDATE_ID": "13",
        "FIRSTNAME": "John Paul",
        "SURNAME": "PHELAN",
        "SITTING": "Yes",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P01",
        "PARTY_MNEMONIC": "FG",
        "PARTY_NAME": "Fine Gael",
        "LAST_ACTIVE_COUNT": "10",
        "CURRENT_STATUS": "Elected",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "7568",
            "PERCENTFIRSTPREF": "10.8",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "7577",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "9",
            "PERCENT_TRANSFERS": "1.5"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "7689",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "112",
            "PERCENT_TRANSFERS": "9.8"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "7713",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "24",
            "PERCENT_TRANSFERS": "1.9"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "7768",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "55",
            "PERCENT_TRANSFERS": "2.3"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "8080",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "312",
            "PERCENT_TRANSFERS": "10.4"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "8420",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "340",
            "PERCENT_TRANSFERS": "9.3"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "8450",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "30",
            "PERCENT_TRANSFERS": "12.8"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "10222",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "1772",
            "PERCENT_TRANSFERS": "31.7"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "14200",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "3978",
            "PERCENT_TRANSFERS": "60.4"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "14200",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Elected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "14",
        "CANDIDATE_ID": "14",
        "FIRSTNAME": "Adrienne",
        "SURNAME": "WALLACE",
        "SITTING": "No",
        "GENDER": "Female",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P05",
        "PARTY_MNEMONIC": "AAA-PBP",
        "PARTY_NAME": "Anti-Austerity Alliance-People Before Profit",
        "LAST_ACTIVE_COUNT": "04",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "1582",
            "PERCENTFIRSTPREF": "2.3",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "1728",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "146",
            "PERCENT_TRANSFERS": "23.5"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "1769",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Unelected",
            "NO_TRANSFERS": "41",
            "PERCENT_TRANSFERS": "3.6"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "2342",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "573",
            "PERCENT_TRANSFERS": "46.5"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "-2342",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      },
      {
        "NUMBER": "15",
        "CANDIDATE_ID": "15",
        "FIRSTNAME": "Noel G.",
        "SURNAME": "WALSH",
        "SITTING": "No",
        "GENDER": "Male",
        "CEANNCOMHAIRLE": "No",
        "KEYCANDIDATE": "Yes",
        "PARTY_ID": "P09",
        "PARTY_MNEMONIC": "IND",
        "PARTY_NAME": "Independent",
        "LAST_ACTIVE_COUNT": "01",
        "CURRENT_STATUS": "Excluded",
        "VOTES": [
          {
            "NUMBER": "01",
            "RECOUNT": "No",
            "NOVOTES": "164",
            "PERCENTFIRSTPREF": "0.2",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "02",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "-164",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "03",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "04",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "05",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "06",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "07",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "08",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "09",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "10",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          },
          {
            "NUMBER": "11",
            "RECOUNT": "No",
            "NOVOTES": "0",
            "PERCENTFIRSTPREF": "0.0",
            "STATUS": "Excluded",
            "NO_TRANSFERS": "0",
            "PERCENT_TRANSFERS": "0.0"
          }
        ]
      }
    ],
    "SPOILED_NONTRANSFERS": [
      {
        "NUMBER": "01",
        "RECOUNT": "No",
        "STATUS": "Spoiled",
        "VOTES": "505",
        "VOTES_PERCENT": "0.7"
      },
      {
        "NUMBER": "02",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "26",
        "VOTES_PERCENT": "4.2"
      },
      {
        "NUMBER": "03",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "94",
        "VOTES_PERCENT": "8.2"
      },
      {
        "NUMBER": "04",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "61",
        "VOTES_PERCENT": "5.0"
      },
      {
        "NUMBER": "05",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "369",
        "VOTES_PERCENT": "15.8"
      },
      {
        "NUMBER": "06",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "355",
        "VOTES_PERCENT": "11.8"
      },
      {
        "NUMBER": "07",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "679",
        "VOTES_PERCENT": "18.6"
      },
      {
        "NUMBER": "08",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "0",
        "VOTES_PERCENT": "0.0"
      },
      {
        "NUMBER": "09",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "750",
        "VOTES_PERCENT": "13.4"
      },
      {
        "NUMBER": "10",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "615",
        "VOTES_PERCENT": "9.3"
      },
      {
        "NUMBER": "11",
        "RECOUNT": "No",
        "STATUS": "Non Transferable",
        "VOTES": "0",
        "VOTES_PERCENT": "0.0"
      }
    ],
    "PARTIES": [
      {
        "CODE": "P01",
        "PARTY_MNEMONIC": "FG",
        "PARTY_NAME": "Fine Gael",
        "MAJOR_PARTY": "Yes",
        "NOFIRSTPREF": "19,147",
        "PERCENTFIRSTPREF": "27.3",
        "SEATS": [
          {
            "NUMBER": "2016",
            "NUMBER_SEATS": "2"
          },
          {
            
          },
          {
            
          }
        ],
        "QUOTAS": [
          {
            "NUMBER": "2016",
            "NUMBER_QUOTAS": "1.6"
          },
          {
            "NUMBER": "2011",
            "NUMBER_QUOTAS": "2.4"
          },
          {
            "NUMBER": "2007",
            "NUMBER_QUOTAS": "1.8"
          }
        ],
        "CHANGES": [
          {
            "NUMBER": "2011",
            "PERCENTAGECHANGE": "-11.9"
          },
          {
            "NUMBER": "2007",
            "PERCENTAGECHANGE": "-2.3"
          }
        ],
        "TRANSFERS": [
          {
            "CODE": "P01",
            "TRANSMNEMONIC": "FG",
            "TRANSNAME": "Fine Gael",
            "TRANSVOTES": "5,238",
            "TRANSPERCENT": "79.5"
          },
          {
            "CODE": "P03",
            "TRANSMNEMONIC": "FF",
            "TRANSNAME": "Fianna Fáil",
            "TRANSVOTES": "531",
            "TRANSPERCENT": "8.1"
          },
          {
            "CODE": "P04",
            "TRANSMNEMONIC": "SF",
            "TRANSNAME": "Sinn Féin",
            "TRANSVOTES": "204",
            "TRANSPERCENT": "3.1"
          },
          {
            "CODE": "P99",
            "TRANSNAME": "NON TRANSFERS",
            "TRANSVOTES": "615",
            "TRANSPERCENT": "9.3"
          },
          {
            "CODE": "P01",
            "TRANSMNEMONIC": "FG",
            "TRANSNAME": "Fine Gael",
            "TRANSVOTES": "2,214",
            "TRANSPERCENT": "87.5"
          },
          {
            "CODE": "P03",
            "TRANSMNEMONIC": "FF",
            "TRANSNAME": "Fianna Fáil",
            "TRANSVOTES": "317",
            "TRANSPERCENT": "12.5"
          }
        ]
      },
      {
        "CODE": "P02",
        "PARTY_MNEMONIC": "LAB",
        "PARTY_NAME": "Labour Party",
        "MAJOR_PARTY": "Yes",
        "NOFIRSTPREF": "4,391",
        "PERCENTFIRSTPREF": "6.3",
        "SEATS": [
          {
            "NUMBER": "2016",
            "NUMBER_SEATS": "0"
          },
          {
            
          },
          {
            
          }
        ],
        "QUOTAS": [
          {
            "NUMBER": "2016",
            "NUMBER_QUOTAS": "0.4"
          },
          {
            "NUMBER": "2011",
            "NUMBER_QUOTAS": "1.0"
          },
          {
            "NUMBER": "2007",
            "NUMBER_QUOTAS": "0.6"
          }
        ],
        "CHANGES": [
          {
            "NUMBER": "2011",
            "PERCENTAGECHANGE": "-10.0"
          },
          {
            "NUMBER": "2007",
            "PERCENTAGECHANGE": "-3.1"
          }
        ],
        "TRANSFERS": {
          "COUNT": [
            {
              "CODE": "P01",
              "TRANSMNEMONIC": "FG",
              "TRANSNAME": "Fine Gael",
              "TRANSVOTES": "3,374",
              "TRANSPERCENT": "60.3"
            },
            {
              "CODE": "P03",
              "TRANSMNEMONIC": "FF",
              "TRANSNAME": "Fianna Fáil",
              "TRANSVOTES": "926",
              "TRANSPERCENT": "16.5"
            },
            {
              "CODE": "P04",
              "TRANSMNEMONIC": "SF",
              "TRANSNAME": "Sinn Féin",
              "TRANSVOTES": "546",
              "TRANSPERCENT": "9.8"
            },
            {
              "CODE": "P99",
              "TRANSNAME": "NON TRANSFERS",
              "TRANSVOTES": "750",
              "TRANSPERCENT": "13.4"
            }
          ]
        }
      },
      {
        "CODE": "P03",
        "PARTY_MNEMONIC": "FF",
        "PARTY_NAME": "Fianna Fáil",
        "MAJOR_PARTY": "Yes",
        "NOFIRSTPREF": "28,267",
        "PERCENTFIRSTPREF": "40.4",
        "SEATS": [
          {
            "NUMBER": "2016",
            "NUMBER_SEATS": "2"
          },
          {
            
          },
          {
            
          }
        ],
        "QUOTAS": [
          {
            "NUMBER": "2016",
            "NUMBER_QUOTAS": "2.4"
          },
          {
            "NUMBER": "2011",
            "NUMBER_QUOTAS": "1.7"
          },
          {
            "NUMBER": "2007",
            "NUMBER_QUOTAS": "2.9"
          }
        ],
        "CHANGES": [
          {
            "NUMBER": "2011",
            "PERCENTAGECHANGE": "+12.3"
          },
          {
            "NUMBER": "2007",
            "PERCENTAGECHANGE": "-7.3"
          }
        ],
        "TRANSFERS": {
          "COUNT": [
            {
              "CODE": "P01",
              "TRANSMNEMONIC": "FG",
              "TRANSNAME": "Fine Gael",
              "TRANSVOTES": "68",
              "TRANSPERCENT": "29.1"
            },
            {
              "CODE": "P02",
              "TRANSMNEMONIC": "LAB",
              "TRANSNAME": "Labour Party",
              "TRANSVOTES": "30",
              "TRANSPERCENT": "12.8"
            },
            {
              "CODE": "P03",
              "TRANSMNEMONIC": "FF",
              "TRANSNAME": "Fianna Fáil",
              "TRANSVOTES": "100",
              "TRANSPERCENT": "42.7"
            },
            {
              "CODE": "P04",
              "TRANSMNEMONIC": "SF",
              "TRANSNAME": "Sinn Féin",
              "TRANSVOTES": "36",
              "TRANSPERCENT": "15.4"
            }
          ]
        }
      },
      {
        "CODE": "P04",
        "PARTY_MNEMONIC": "SF",
        "PARTY_NAME": "Sinn Féin",
        "MAJOR_PARTY": "Yes",
        "NOFIRSTPREF": "8,700",
        "PERCENTFIRSTPREF": "12.4",
        "SEATS": [
          {
            "NUMBER": "2016",
            "NUMBER_SEATS": "1"
          },
          {
            
          },
          {
            
          }
        ],
        "QUOTAS": [
          {
            "NUMBER": "2016",
            "NUMBER_QUOTAS": "0.7"
          },
          {
            "NUMBER": "2011",
            "NUMBER_QUOTAS": "0.6"
          },
          {
            "NUMBER": "2007",
            "NUMBER_QUOTAS": "0.2"
          }
        ],
        "CHANGES": [
          {
            "NUMBER": "2011",
            "PERCENTAGECHANGE": "+2.9"
          },
          {
            "NUMBER": "2007",
            "PERCENTAGECHANGE": "+8.6"
          }
        ]
      },
      {
        "CODE": "P05",
        "PARTY_MNEMONIC": "AAA-PBP",
        "PARTY_NAME": "Anti-Austerity Alliance-People Before Profit",
        "MAJOR_PARTY": "Yes",
        "NOFIRSTPREF": "2,702",
        "PERCENTFIRSTPREF": "3.9",
        "SEATS": [
          {
            "NUMBER": "2016",
            "NUMBER_SEATS": "0"
          },
          {
            
          },
          {
            
          }
        ],
        "QUOTAS": [
          {
            "NUMBER": "2016",
            "NUMBER_QUOTAS": "0.2"
          },
          {
            "NUMBER": "2011",
            "NUMBER_QUOTAS": "0.0"
          },
          {
            "NUMBER": "2007",
            "NUMBER_QUOTAS": "0.0"
          }
        ],
        "CHANGES": [
          {
            "NUMBER": "2011",
            "PERCENTAGECHANGE": "+3.9"
          },
          {
            "NUMBER": "2007",
            "PERCENTAGECHANGE": "+3.9"
          }
        ],
        "TRANSFERS": [
          {
            "CODE": "P01",
            "TRANSMNEMONIC": "FG",
            "TRANSNAME": "Fine Gael",
            "TRANSVOTES": "53",
            "TRANSPERCENT": "4.3"
          },
          {
            "CODE": "P02",
            "TRANSMNEMONIC": "LAB",
            "TRANSNAME": "Labour Party",
            "TRANSVOTES": "23",
            "TRANSPERCENT": "1.9"
          },
          {
            "CODE": "P03",
            "TRANSMNEMONIC": "FF",
            "TRANSNAME": "Fianna Fáil",
            "TRANSVOTES": "123",
            "TRANSPERCENT": "10.0"
          },
          {
            "CODE": "P04",
            "TRANSMNEMONIC": "SF",
            "TRANSNAME": "Sinn Féin",
            "TRANSVOTES": "203",
            "TRANSPERCENT": "16.5"
          },
          {
            "CODE": "P05",
            "TRANSMNEMONIC": "AAA-PBP",
            "TRANSNAME": "Anti-Austerity Alliance-People Before Profit",
            "TRANSVOTES": "573",
            "TRANSPERCENT": "46.5"
          },
          {
            "CODE": "P06",
            "TRANSMNEMONIC": "RN",
            "TRANSNAME": "Renua Ireland",
            "TRANSVOTES": "96",
            "TRANSPERCENT": "7.8"
          },
          {
            "CODE": "P10",
            "TRANSMNEMONIC": "GP",
            "TRANSNAME": "Green Party",
            "TRANSVOTES": "99",
            "TRANSPERCENT": "8.0"
          },
          {
            "CODE": "P99",
            "TRANSNAME": "NON TRANSFERS",
            "TRANSVOTES": "61",
            "TRANSPERCENT": "5.0"
          },
          {
            "CODE": "P01",
            "TRANSMNEMONIC": "FG",
            "TRANSNAME": "Fine Gael",
            "TRANSVOTES": "141",
            "TRANSPERCENT": "6.0"
          },
          {
            "CODE": "P02",
            "TRANSMNEMONIC": "LAB",
            "TRANSNAME": "Labour Party",
            "TRANSVOTES": "83",
            "TRANSPERCENT": "3.5"
          },
          {
            "CODE": "P03",
            "TRANSMNEMONIC": "FF",
            "TRANSNAME": "Fianna Fáil",
            "TRANSVOTES": "342",
            "TRANSPERCENT": "14.6"
          },
          {
            "CODE": "P04",
            "TRANSMNEMONIC": "SF",
            "TRANSNAME": "Sinn Féin",
            "TRANSVOTES": "762",
            "TRANSPERCENT": "32.5"
          },
          {
            "CODE": "P06",
            "TRANSMNEMONIC": "RN",
            "TRANSNAME": "Renua Ireland",
            "TRANSVOTES": "253",
            "TRANSPERCENT": "10.8"
          },
          {
            "CODE": "P10",
            "TRANSMNEMONIC": "GP",
            "TRANSNAME": "Green Party",
            "TRANSVOTES": "392",
            "TRANSPERCENT": "16.7"
          },
          {
            "CODE": "P99",
            "TRANSNAME": "NON TRANSFERS",
            "TRANSVOTES": "369",
            "TRANSPERCENT": "15.8"
          }
        ]
      },
      {
        "CODE": "P06",
        "PARTY_MNEMONIC": "RN",
        "PARTY_NAME": "Renua Ireland",
        "MAJOR_PARTY": "Yes",
        "NOFIRSTPREF": "2,483",
        "PERCENTFIRSTPREF": "3.5",
        "SEATS": [
          {
            "NUMBER": "2016",
            "NUMBER_SEATS": "0"
          },
          {
            
          },
          {
            
          }
        ],
        "QUOTAS": [
          {
            "NUMBER": "2016",
            "NUMBER_QUOTAS": "0.2"
          },
          {
            "NUMBER": "2011",
            "NUMBER_QUOTAS": "0.0"
          },
          {
            "NUMBER": "2007",
            "NUMBER_QUOTAS": "0.0"
          }
        ],
        "CHANGES": [
          {
            "NUMBER": "2011",
            "PERCENTAGECHANGE": "+3.5"
          },
          {
            "NUMBER": "2007",
            "PERCENTAGECHANGE": "+3.5"
          }
        ],
        "TRANSFERS": {
          "COUNT": [
            {
              "CODE": "P01",
              "TRANSMNEMONIC": "FG",
              "TRANSNAME": "Fine Gael",
              "TRANSVOTES": "681",
              "TRANSPERCENT": "22.7"
            },
            {
              "CODE": "P02",
              "TRANSMNEMONIC": "LAB",
              "TRANSNAME": "Labour Party",
              "TRANSVOTES": "192",
              "TRANSPERCENT": "6.4"
            },
            {
              "CODE": "P03",
              "TRANSMNEMONIC": "FF",
              "TRANSNAME": "Fianna Fáil",
              "TRANSVOTES": "953",
              "TRANSPERCENT": "31.7"
            },
            {
              "CODE": "P04",
              "TRANSMNEMONIC": "SF",
              "TRANSNAME": "Sinn Féin",
              "TRANSVOTES": "372",
              "TRANSPERCENT": "12.4"
            },
            {
              "CODE": "P10",
              "TRANSMNEMONIC": "GP",
              "TRANSNAME": "Green Party",
              "TRANSVOTES": "452",
              "TRANSPERCENT": "15.0"
            },
            {
              "CODE": "P99",
              "TRANSNAME": "NON TRANSFERS",
              "TRANSVOTES": "355",
              "TRANSPERCENT": "11.8"
            }
          ]
        }
      },
      {
        "CODE": "P10",
        "PARTY_MNEMONIC": "GP",
        "PARTY_NAME": "Green Party",
        "MAJOR_PARTY": "Yes",
        "NOFIRSTPREF": "2,621",
        "PERCENTFIRSTPREF": "3.7",
        "SEATS": [
          {
            "NUMBER": "2016",
            "NUMBER_SEATS": "0"
          },
          {
            
          },
          {
            
          }
        ],
        "QUOTAS": [
          {
            "NUMBER": "2016",
            "NUMBER_QUOTAS": "0.2"
          },
          {
            "NUMBER": "2011",
            "NUMBER_QUOTAS": "0.2"
          },
          {
            "NUMBER": "2007",
            "NUMBER_QUOTAS": "0.5"
          }
        ],
        "CHANGES": [
          {
            "NUMBER": "2011",
            "PERCENTAGECHANGE": "+0.9"
          },
          {
            "NUMBER": "2007",
            "PERCENTAGECHANGE": "-4.2"
          }
        ],
        "TRANSFERS": {
          "COUNT": [
            {
              "CODE": "P01",
              "TRANSMNEMONIC": "FG",
              "TRANSNAME": "Fine Gael",
              "TRANSVOTES": "779",
              "TRANSPERCENT": "21.3"
            },
            {
              "CODE": "P02",
              "TRANSMNEMONIC": "LAB",
              "TRANSNAME": "Labour Party",
              "TRANSVOTES": "826",
              "TRANSPERCENT": "22.6"
            },
            {
              "CODE": "P03",
              "TRANSMNEMONIC": "FF",
              "TRANSNAME": "Fianna Fáil",
              "TRANSVOTES": "670",
              "TRANSPERCENT": "18.3"
            },
            {
              "CODE": "P04",
              "TRANSMNEMONIC": "SF",
              "TRANSNAME": "Sinn Féin",
              "TRANSVOTES": "706",
              "TRANSPERCENT": "19.3"
            },
            {
              "CODE": "P99",
              "TRANSNAME": "NON TRANSFERS",
              "TRANSVOTES": "679",
              "TRANSPERCENT": "18.6"
            }
          ]
        }
      },
      {
        "CODE": "P09",
        "PARTY_MNEMONIC": "IND",
        "PARTY_NAME": "Independent",
        "MAJOR_PARTY": "Yes",
        "NOFIRSTPREF": "1,698",
        "PERCENTFIRSTPREF": "2.4",
        "SEATS": [
          {
            "NUMBER": "2016",
            "NUMBER_SEATS": "0"
          },
          {
            
          },
          {
            
          }
        ],
        "QUOTAS": [
          {
            "NUMBER": "2016",
            "NUMBER_QUOTAS": "0.1"
          },
          {
            "NUMBER": "2011",
            "NUMBER_QUOTAS": "0.2"
          },
          {
            "NUMBER": "2007",
            "NUMBER_QUOTAS": "0.0"
          }
        ],
        "CHANGES": [
          {
            "NUMBER": "2011",
            "PERCENTAGECHANGE": "-0.1"
          },
          {
            "NUMBER": "2007",
            "PERCENTAGECHANGE": "+2.4"
          }
        ],
        "TRANSFERS": [
          {
            "CODE": "P01",
            "TRANSMNEMONIC": "FG",
            "TRANSNAME": "Fine Gael",
            "TRANSVOTES": "31",
            "TRANSPERCENT": "5.0"
          },
          {
            "CODE": "P02",
            "TRANSMNEMONIC": "LAB",
            "TRANSNAME": "Labour Party",
            "TRANSVOTES": "5",
            "TRANSPERCENT": "0.8"
          },
          {
            "CODE": "P03",
            "TRANSMNEMONIC": "FF",
            "TRANSNAME": "Fianna Fáil",
            "TRANSVOTES": "89",
            "TRANSPERCENT": "14.4"
          },
          {
            "CODE": "P04",
            "TRANSMNEMONIC": "SF",
            "TRANSNAME": "Sinn Féin",
            "TRANSVOTES": "138",
            "TRANSPERCENT": "22.3"
          },
          {
            "CODE": "P05",
            "TRANSMNEMONIC": "AAA-PBP",
            "TRANSNAME": "Anti-Austerity Alliance-People Before Profit",
            "TRANSVOTES": "205",
            "TRANSPERCENT": "33.1"
          },
          {
            "CODE": "P06",
            "TRANSMNEMONIC": "RN",
            "TRANSNAME": "Renua Ireland",
            "TRANSVOTES": "28",
            "TRANSPERCENT": "4.5"
          },
          {
            "CODE": "P10",
            "TRANSMNEMONIC": "GP",
            "TRANSNAME": "Green Party",
            "TRANSVOTES": "34",
            "TRANSPERCENT": "5.5"
          },
          {
            "CODE": "P09",
            "TRANSMNEMONIC": "IND",
            "TRANSNAME": "Independent",
            "TRANSVOTES": "64",
            "TRANSPERCENT": "10.3"
          },
          {
            "CODE": "P99",
            "TRANSNAME": "NON TRANSFERS",
            "TRANSVOTES": "26",
            "TRANSPERCENT": "4.2"
          },
          {
            "CODE": "P01",
            "TRANSMNEMONIC": "FG",
            "TRANSNAME": "Fine Gael",
            "TRANSVOTES": "211",
            "TRANSPERCENT": "18.5"
          },
          {
            "CODE": "P02",
            "TRANSMNEMONIC": "LAB",
            "TRANSNAME": "Labour Party",
            "TRANSVOTES": "46",
            "TRANSPERCENT": "4.0"
          },
          {
            "CODE": "P03",
            "TRANSMNEMONIC": "FF",
            "TRANSNAME": "Fianna Fáil",
            "TRANSVOTES": "438",
            "TRANSPERCENT": "38.4"
          },
          {
            "CODE": "P04",
            "TRANSMNEMONIC": "SF",
            "TRANSNAME": "Sinn Féin",
            "TRANSVOTES": "53",
            "TRANSPERCENT": "4.6"
          },
          {
            "CODE": "P05",
            "TRANSMNEMONIC": "AAA-PBP",
            "TRANSNAME": "Anti-Austerity Alliance-People Before Profit",
            "TRANSVOTES": "93",
            "TRANSPERCENT": "8.1"
          },
          {
            "CODE": "P06",
            "TRANSMNEMONIC": "RN",
            "TRANSNAME": "Renua Ireland",
            "TRANSVOTES": "145",
            "TRANSPERCENT": "12.7"
          },
          {
            "CODE": "P10",
            "TRANSMNEMONIC": "GP",
            "TRANSNAME": "Green Party",
            "TRANSVOTES": "62",
            "TRANSPERCENT": "5.4"
          },
          {
            "CODE": "P99",
            "TRANSNAME": "NON TRANSFERS",
            "TRANSVOTES": "94",
            "TRANSPERCENT": "8.2"
          }
        ]
      },
      {
        "CODE": "P99",
        "PARTY_NAME": "OTHERS",
        "MAJOR_PARTY": "No",
        "NOFIRSTPREF": "0",
        "PERCENTFIRSTPREF": "0.0",
        "SEATS": [
          {
            "NUMBER": "2016",
            "NUMBER_SEATS": "0"
          },
          {
            
          },
          {
            
          }
        ],
        "QUOTAS": [
          {
            "NUMBER": "2016",
            "NUMBER_QUOTAS": "0.0"
          },
          {
            "NUMBER": "2011",
            "NUMBER_QUOTAS": "0.1"
          },
          {
            "NUMBER": "2007",
            "NUMBER_QUOTAS": "0.1"
          }
        ],
        "CHANGES": [
          {
            "NUMBER": "2011",
            "PERCENTAGECHANGE": "-1.5"
          },
          {
            "NUMBER": "2007",
            "PERCENTAGECHANGE": "-1.6"
          }
        ]
      }
    ]
  }
}
``` 

Using this information I created a Java program to parse the information and to create the script that create the database. This java code can be found in the suuport folder.

The Java Parser is used to create all the CREATE statments that the database will need to work properly, including the relations between the nodes.

Finally, I got my Graphy Database representing the elections:

![Graphy](https://github.com/wcordeiro/project-template/blob/master/supports/images/database.JPG)

The database, briefly, has: 40 nodes representing Constituencies, 552 nodes representing Candidates, 385 nodes representing regionally Parties (by constituency), 552 relationships "ran_for", 552 relationships "belongs_to" and 385 "in" between the Candidates and their Constituency and their Parties respectively and Parties and Constituencies.


## Queries
As asked in the assignment the following queries are a try of giving useful information about the elections and show the cypher language and the graph database functionality.

#### Parties Rank.
The parties ranked by number of elected candidates.
```cypher
match (cand:Candidate)-[r:BELLONGS_TO]->(p:Party)
where cand.currentStatus = 'Elected'
return p.name, count(cand.firstName) as CountTotal
order by CountTotal desc
```
Output:
![Query1](https://github.com/wcordeiro/project-template/blob/master/supports/images/query1.JPG)

#### Number of elected female candidates by Constiruency
This query retrives the number of female candidates electeds in each constituency and sort by this number 
```cypher
match (cand:Candidate)-[r:RAN_FOR]->(cons:Constituency)
where cand.gender = 'Female' and cand.currentStatus = 'Elected'
return cons.name,count(cand.SurName) as countTotal
order by countTotal desc
```
Output:
![Query2](https://github.com/wcordeiro/project-template/blob/master/supports/images/query2.JPG)

#### Real Number of electors for Region
This query retreives the real number of electors for region.
```cypher
match (cons:Constituency)
return distinct cons.RegionName as RegionName, sum(cons.electorate) as Electorate, sum(cons.electorate - cons.turnout) as TotalVoters, round(100*(toFloat(toFloat(sum(cons.electorate - cons.turnout)) / toFloat(sum(cons.electorate))))) as Percent 
order by sum(cons.electorate - cons.turnout) desc
```
Output:
![Query3](https://github.com/wcordeiro/project-template/blob/master/supports/images/query3.JPG)

## References
1. [Neo4J website](http://neo4j.com/), the website of the Neo4j database.
2. [RTE website](http://www.rte.ie/news/election-2016/), all information about 2016 Irish General Elections RTE page
3. [Agregation](http://neo4j.com/docs/stable/query-aggregation.html)
4. [Order by](http://neo4j.com/docs/stable/query-order.html)
5. [With](http://stackoverflow.com/questions/18975647/neo4j-cypher-query-to-return-relationship-property-and-sum-of-all-matching-relat)
6. [JSON](http://www.java2s.com/Code/JarDownload/java/java-json.jar.zip)