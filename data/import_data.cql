MATCH (n) DETACH DELETE n;

LOAD CSV WITH HEADERS FROM 'file:///business_role.csv'
AS row WITH row
MERGE (n:BusinessRole { id: row.id, name: row.name })
  ON CREATE SET n = row
  ON MATCH SET n = row
RETURN 'BusinessRole count: ' as entity, COUNT(n) as count;