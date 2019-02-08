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

CREATE (n:Blacklist:ConstraintType {id: "Blacklist", name: "Blacklist"}) RETURN n;
CREATE (n:Whitelist:ConstraintType {id: "Whitelist", name: "Whitelist"}) RETURN n;

// TEST DATA FOR DISCREPANCY CHECK

// Entities
CREATE (br:BusinessRole {id: "br1", name: "br1"});
CREATE (br:BusinessRole {id: "br2", name: "br2"});
CREATE (br:BusinessRole {id: "br3", name: "br3"});

CREATE (:AssetFunction {id: "af1", name: "af1"});
CREATE (:AssetFunction {id: "af2", name: "af2"});
CREATE (:AssetFunction {id: "af3", name: "af3"});

// SOLL
CREATE (m:Matrix:SOLL {id: "m1"});
CREATE (c:Constraint {id: "c1"});
CREATE (c:Constraint {id: "c2"});
CREATE (c:Constraint {id: "c3"});
CREATE (c:Constraint {id: "c4"});

MATCH (c:Constraint {id: "c1"}), (n:Whitelist {id: "Whitelist"})
CREATE (c)-[:IS_TYPE]->(n);

MATCH (c:Constraint {id: "c2"}), (n:Whitelist {id: "Whitelist"})
CREATE (c)-[:IS_TYPE]->(n);

MATCH (c:Constraint {id: "c3"}), (n:Whitelist {id: "Whitelist"})
CREATE (c)-[:IS_TYPE]->(n);

MATCH (c:Constraint {id: "c4"}), (n:Whitelist {id: "Whitelist"})
CREATE (c)-[:IS_TYPE]->(n);

MATCH (m:Matrix:SOLL {id: "m1"}), (c:Constraint {id: "c1"})
CREATE (m)-[:HAS_CONSTRAINT]->(c);

MATCH (m:Matrix:SOLL {id: "m1"}), (c:Constraint {id: "c2"})
CREATE (m)-[:HAS_CONSTRAINT]->(c);

MATCH (m:Matrix:SOLL {id: "m1"}), (c:Constraint {id: "c3"})
CREATE (m)-[:HAS_CONSTRAINT]->(c);

MATCH (m:Matrix:SOLL {id: "m1"}), (c:Constraint {id: "c4"})
CREATE (m)-[:HAS_CONSTRAINT]->(c);

MATCH (br:BusinessRole {id: "br1"}), (af:AssetFunction {id: "af1"}), (c:Constraint {id: "c1"})
CREATE (c)-[:FROM]->(br)
CREATE (c)-[:TO]->(af);

MATCH (br:BusinessRole {id: "br2"}), (af:AssetFunction {id: "af2"}), (c:Constraint {id: "c2"})
CREATE (c)-[:FROM]->(br)
CREATE (c)-[:TO]->(af);

MATCH (br:BusinessRole {id: "br3"}), (af:AssetFunction {id: "af3"}), (c:Constraint {id: "c3"})
CREATE (c)-[:FROM]->(br)
CREATE (c)-[:TO]->(af);

MATCH (br:BusinessRole {id: "br2"}), (af:AssetFunction {id: "af1"}), (c:Constraint {id: "c4"})
CREATE (c)-[:FROM]->(br)
CREATE (c)-[:TO]->(af);

// IST
CREATE (:Account {id: "acc1", name: "acc1"});
CREATE (:Account {id: "acc2", name: "acc2"});
CREATE (:Account {id: "acc3", name: "acc3"});

MATCH (br:BusinessRole {id: "br1"}), (acc:Account {id: "acc1"})
CREATE (acc)-[:HAS_ROLE]->(br);

MATCH (br:BusinessRole {id: "br1"}), (acc:Account {id: "acc3"})
CREATE (acc)-[:HAS_ROLE]->(br);

MATCH (br:BusinessRole {id: "br3"}), (acc:Account {id: "acc1"})
CREATE (acc)-[:HAS_ROLE]->(br);

MATCH (br:BusinessRole {id: "br2"}), (acc:Account {id: "acc2"})
CREATE (acc)-[:HAS_ROLE]->(br);

MATCH (af:AssetFunction {id: "af1"}), (acc:Account {id: "acc1"})
CREATE (acc)-[:HAS_FUNCTION]->(af);

MATCH (af:AssetFunction {id: "af3"}), (acc:Account {id: "acc1"})
CREATE (acc)-[:HAS_FUNCTION]->(af);

MATCH (af:AssetFunction {id: "af1"}), (acc:Account {id: "acc2"})
CREATE (acc)-[:HAS_FUNCTION]->(af);

MATCH (af:AssetFunction {id: "af2"}), (acc:Account {id: "acc3"})
CREATE (acc)-[:HAS_FUNCTION]->(af);


// For all entities not connected by whitelist, connect by blacklist
MATCH(af:AssetFunction), (br:BusinessRole), (w:Whitelist)
  WHERE NOT (af)<-[:TO]-(:Constraint)-[:FROM]->(br)
WITH af,br
MATCH (b:Blacklist {id: "Blacklist"})
CREATE (c:Constraint {id: apoc.create.uuid()})
CREATE (af)<-[:TO]-(c)-[:FROM]->(br)
CREATE (c)-[:IS_TYPE]->(b)
RETURN af,br;


