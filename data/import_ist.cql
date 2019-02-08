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
