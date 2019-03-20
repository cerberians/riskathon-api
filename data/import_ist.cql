LOAD CSV WITH HEADERS FROM 'file:///ist_accounts_af.csv'
AS row WITH row
MERGE (account:Account { id: row.account })
MERGE (af:AssetFunction { id: row.assetfunction })
CREATE (account)-[:HAS_FUNCTION]->(af)
;

LOAD CSV WITH HEADERS FROM 'file:///ist_accounts_br.csv'
AS row WITH row
MERGE (account:Account { id: row.account })
MERGE (br:BusinessRole { id: row.businessrole })
CREATE (account)-[:HAS_ROLE]->(br)
;


// For all entities not connected by whitelist, connect by blacklist
MATCH(af:AssetFunction), (br:BusinessRole), (w:Whitelist)
  WHERE NOT (af)<-[:TO]-(:Constraint)-[:FROM]->(br)
WITH af,br
MATCH (b:Blacklist {id: "Blacklist"})
CREATE (c:Constraint {id: apoc.create.uuid()})
CREATE (af)<-[:TO]-(c)-[:FROM]->(br)
CREATE (c)-[:IS_TYPE]->(b)
RETURN af,br;

MATCH (account:Account {id:"mz35tm"})-[:HAS_ROLE]->(br:BusinessRole),
      (account)-[:HAS_FUNCTION]->(af:AssetFunction),
      (:Blacklist)<-[:IS_TYPE]-(constraint:Constraint)-[:FROM]->(br),
      (constraint)-[:TO]->(af)
RETURN account, br, af, constraint;