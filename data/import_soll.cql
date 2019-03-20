LOAD CSV WITH HEADERS FROM 'file:///soll_business_roles.csv'
AS row WITH row
CREATE (n:BusinessRole:Entity { id: row.id, name: row.id });

LOAD CSV WITH HEADERS FROM 'file:///soll_asset_functions.csv'
AS row WITH row
CREATE (n:AssetFunction:Entity { id: row.id, name: row.id });

LOAD CSV WITH HEADERS FROM 'file:///soll_br_af.csv'
AS row WITH row
MATCH (br:BusinessRole:Entity { id: row.brId}), (af:AssetFunction:Entity { id: row.afId}), (w:Whitelist {id: "Whitelist"})
CREATE (c:Constraint {id: apoc.create.uuid()})
CREATE (c)-[:IS_TYPE]->(w)
CREATE (br)<-[:FROM]-(c)-[:TO]->(af);