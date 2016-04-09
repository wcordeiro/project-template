// Number of re-elected candidates 
// This query retreives the Number of re-elected candidates by constituency.

match (cand:Candidate)-[r:RAN_FOR]->(cons:Constituency)
where cand.sitting = 'Yes' and cand.currentStatus = 'Elected'
return cons.name, count(cand.SurName) as Total, round(100*(toFloat(count(cand.SurName)) / toFloat(cons.noSeats))) as Percent 
order by count(cand.SurName) desc;