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

route.get("/requestlist",(request,response)=>{
    var queryText="select * from orders";
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

route.get("/getRequest/:id",(request,response)=>{
    var queryText=`select * from orders where id=${request.params.id}`;
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

route.put("/updateRequest/:id",(request,response)=>{
    var id=request.params.id;
    var vendor_id=request.body.vendor_id;
    var OTP=request.body.OTP;
    
    var queryText=`update orders set vendor_id=${vendor_id}, OTP=${OTP} where id='${id}'`;
   
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

route.get("/RequestDetails/:order_id",(request,response)=>{
    var order_id=request.params.order_id;
     
    var queryText=`select * from order_details where order_id=${order_id}`;
   
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
