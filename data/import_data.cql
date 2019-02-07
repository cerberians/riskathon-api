MATCH (n) DETACH DELETE n;

LOAD CSV WITH HEADERS FROM 'file:///languages.csv'
AS row WITH row
MERGE (n:Language { id: row.id })
  ON CREATE SET n = row
  ON MATCH SET n = row
RETURN 'Language' as entity, COUNT(n) as count;