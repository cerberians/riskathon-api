#!/bin/bash

function should_load_data() {
    neo4jUsername=${1}
    neo4jPassword=${2}

    response=$(curl -s -X POST \
      --user "${neo4jUsername}:${neo4jPassword}" \
      -H 'Accept: application/json; charset=UTF-8' \
      -H 'Content-type: application/json' \
      --data '{
      "statements" : [ {
          "statement" : "MATCH (n) RETURN count(n)"
        } ]
      }' http://riskathon-neo4j:7474/db/data/transaction/commit)
    count=$(echo ${response} | jq '.results[0].data[0].row[0]')

    echo ${response}

    if [[ ${count} == 0 ]];
    then
      return 0
    else
      return 1
    fi
}

function is_neo4j_up() {
    url=${1}
    curl -sq ${url}
}

function load_ist() {
    bin/cypher-shell \
        --address bolt://riskathon-neo4j:7687 \
        --username ${NEO4J_USERNAME} \
        --password ${NEO4J_PASSWORD} \
        < import/${IMPORTIST}
}

function load_data() {
    bin/cypher-shell \
        --address bolt://riskathon-neo4j:7687 \
        --username ${NEO4J_USERNAME} \
        --password ${NEO4J_PASSWORD} \
        < import/${IMPORTDATA}
    bin/cypher-shell \
        --address bolt://riskathon-neo4j:7687 \
        --username ${NEO4J_USERNAME} \
        --password ${NEO4J_PASSWORD} \
        < import/${IMPORTSOLL}
}

function load_indexes() {
    bin/cypher-shell \
        --address bolt://riskathon-neo4j:7687 \
        --username ${NEO4J_USERNAME} \
        --password ${NEO4J_PASSWORD} \
        < import/${IMPORTINDEXES}
}

function main() {
    echo "Start"

    sleep 5

    while true; do
        echo "Waiting for Neo4j..."
        is_neo4j_up "http://riskathon-neo4j:7474/"
        if [[ ${?} == 0 ]]; then
            break
        else
            sleep 2
        fi
    done

    echo "Neo4j is ready!"

#    Loads data every time
    load_data

#   Loads data conditionally: only if DB is empty
#    should_load_data ${NEO4J_USERNAME} ${NEO4J_PASSWORD}
#    if [[ ${?} == 0 ]]; then
#        echo "Loading data..."
#        load_data
#    else
#        echo "Data already loaded"
#    fi

    echo "Loading indexes"
    load_indexes

    load_ist

    echo "Done"
}

main