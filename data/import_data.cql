MATCH (n) DETACH DELETE n;

LOAD CSV WITH HEADERS FROM 'file:///business_role.csv'
AS row WITH row
MERGE (n:BusinessRole { id: row.id, name: row.name })
  ON CREATE SET n = row
  ON MATCH SET n = row
RETURN 'BusinessRole count: ' as entity, COUNT(n) as count;

LOAD CSV WITH HEADERS FROM 'file:///privilege.csv'
AS row WITH row
MERGE (n:Privilege { id: row.id, name: row.name })
  ON CREATE SET n = row
  ON MATCH SET n = row
RETURN 'Privilege count: ' as entity, COUNT(n) as count;

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