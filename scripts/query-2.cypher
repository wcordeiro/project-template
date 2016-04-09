// Real Number of electors for Region
//This query retreives the real number of electors for region.

match (cons:Constituency)
return distinct cons.RegionName as RegionName, sum(cons.electorate) as Electorate, sum(cons.electorate - cons.turnout) as TotalVoters, round(100*(toFloat(toFloat(sum(cons.electorate - cons.turnout)) / toFloat(sum(cons.electorate))))) as Percent 
order by sum(cons.electorate - cons.turnout) desc;