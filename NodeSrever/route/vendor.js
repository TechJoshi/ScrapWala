var express=require("express");
var mysql=require("mysql");
var config=require("config");

var route=express();

var connection=mysql.createConnection({
    host:config.get("host"),
    user:config.get("user"),
    database:config.get("database"),
    password:config.get("password")
});

connection.connect();
route.use(express.json());



route.get("/vendorlist",(request,response)=>{
    var queryText="select * from user where user_role='VENDOR'";
    connection.query(queryText,(err,result)=>{
        if(err==null)
        {
            response.send(JSON.stringify(result));
        }
        else{
            response.send(JSON.stringify(err.message));
        }
    });
});

module.exports=route;
