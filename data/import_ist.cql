LOAD CSV WITH HEADERS FROM 'file:///account.csv'
AS row WITH row
MERGE (account),(as:Asset)
  WHERE app.id = row.idApp AND as.id = row.id
CREATE (app)-[rel:HAS_ASSET]->(as);