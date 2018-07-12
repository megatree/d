package index.groovy

import groovy.sql.Sql

/**
 * Created by mythss on 2018-07-12.
 */

sql = Sql.newInstance(DbConn.mytest)

def qry = 'INSERT INTO t_name (id, name) VALUES (?,?)'

def insert(){
    sql.withBatch(3, qry) { ps ->
        ps.addBatch(1,'name1')
        ps.addBatch(2,'name2')
        ps.addBatch(3,'name3')
        ps.addBatch(4,'name4')
        ps.addBatch(5,'name5')
        ps.addBatch(6,'name6')
        ps.addBatch(7,'name7')
    }
}

def query(){

    sql.eachRow('SELECT id,name FROM t_name') { row ->
        def id = row["id"]
        def name = row["name"]
        println "${id} ${name}"
    }

}

query()