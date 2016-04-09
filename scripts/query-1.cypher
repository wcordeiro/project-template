// Parties Rank.
// The parties ranked by number of elected candidates.

match (cand:Candidate)-[r:BELLONGS_TO]->(p:Party)
where cand.currentStatus = 'Elected'
return p.name, count(cand.firstName) as CountTotal
order by CountTotal desc;