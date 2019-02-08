MATCH (n) DETACH DELETE n;

//LOAD CSV WITH HEADERS FROM 'file:///business_role.csv'
//AS row WITH row
//MERGE (n:BusinessRole:Entity { id: row.id, name: row.name })
//  ON CREATE SET n = row
//  ON MATCH SET n = row
//RETURN 'BusinessRole count: ' as entity, COUNT(n) as count;
//
//LOAD CSV WITH HEADERS FROM 'file:///privilege.csv'
//AS row WITH row
//MERGE (n:Privilege { id: row.id, name: row.name })
//  ON CREATE SET n = row
//  ON MATCH SET n = row
//RETURN 'Privilege count: ' as entity, COUNT(n) as count;
//
//LOAD CSV WITH HEADERS FROM 'file:///app.csv'
//AS row WITH row
//MERGE (n:Application { id: row.id, name: row.name })
//  ON CREATE SET n = row
//  ON MATCH SET n = row
//RETURN 'Application' as entity, COUNT(n) as count;
//
//LOAD CSV WITH HEADERS FROM 'file:///asset.csv'
//AS row WITH row
//MERGE (n:Asset { id: row.id, name: row.name })
//  ON CREATE SET n = row
//  ON MATCH SET n = row
//RETURN 'Asset' as entity, COUNT(n) as count;
//
//LOAD CSV WITH HEADERS FROM 'file:///asset_type.csv'
//AS row WITH row
//MERGE (n:AssetType { id: row.id, name: row.name })
//  ON CREATE SET n = row
//  ON MATCH SET n = row
//RETURN 'AssetType' as entity, COUNT(n) as count;
//
//LOAD CSV WITH HEADERS FROM 'file:///asset.csv'
//AS row WITH row
//MATCH (app:Application),(as:Asset)
//  WHERE app.id = row.idApp AND as.id = row.id
//CREATE (app)-[rel:HAS_ASSET]->(as);
//
//LOAD CSV WITH HEADERS FROM 'file:///asset.csv'
//AS row WITH row
//MATCH (asset:Asset),(type:AssetType)
//  WHERE asset.id = row.id AND type.id = row.idType
//CREATE (asset)-[relation:HAS_TYPE]->(type);

CREATE (n:Blacklist {id: "Blacklist", name: "Blacklist"}) RETURN n;
CREATE (n:Whitelist {id: "Whitelist", name: "Whitelist"}) RETURN n;