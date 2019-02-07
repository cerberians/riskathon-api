MATCH (n) DETACH DELETE n;

LOAD CSV WITH HEADERS FROM 'file:///app.csv'
AS row WITH row
MERGE (n:Application { id: row.id, name: row.name })
  ON CREATE SET n = row
  ON MATCH SET n = row
RETURN 'Application' as entity, COUNT(n) as count;

LOAD CSV WITH HEADERS FROM 'file:///asset.csv'
AS row WITH row
MERGE (n:Asset { id: row.id, name: row.name })
  ON CREATE SET n = row
  ON MATCH SET n = row
RETURN 'Asset' as entity, COUNT(n) as count;

LOAD CSV WITH HEADERS FROM 'file:///asset.csv'
AS row WITH ROW
MATCH (a:Application),(b:Asset)
  WHERE a.id = row.idApp AND b.id = row.id
CREATE (a)-[r:HAS_ASSET]->(b)
RETURN type(r)