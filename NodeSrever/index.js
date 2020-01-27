var express=require("express");
var itemRoute=require("./route/item");
var customerRoute=require("./route/customer");
var vendorRoute=require("./route/vendor");
var requestRoute=require("./route/request");
var config=require("config");

var app=express();
var port=parseInt(config.get("port"));
app.use(express.json());
app.use(function(req,res,next){
    res.header("Access-Control-Allow-Origin","*");
    res.header("Access-Control-Allow-Methods","POST,GET,PUT,DELETE");
    res.header("Access-Control-Allow-Headers","Origin,X-Reqested-With,Content-Type,Accept");
    next();
});

app.use("/item",itemRoute);
app.use(express.static('images'));
app.use("/customer",customerRoute);
app.use("/vendor",vendorRoute);
app.use("/request",requestRoute);


app.listen(port,()=>{
    console.log(`Node Server Started on port ${port}!!!`);
})