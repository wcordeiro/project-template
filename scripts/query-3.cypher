// Number of elected female candidates by Constiruency
//This query retrives the number of female candidates electeds in each constituency and sort by this number 

match (cand:Candidate)-[r:RAN_FOR]->(cons:Constituency)
where cand.gender = 'Female' and cand.currentStatus = 'Elected'
return cons.name,count(cand.SurName) as countTotal
order by countTotal desc;