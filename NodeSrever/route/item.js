var express=require("express");
var mysql=require("mysql");
var config=require("config");
const multer = require('multer');
const upload = multer({ dest: 'images/' })

var route=express();

var connection=mysql.createConnection({
    host:config.get("host"),
    user:config.get("user"),
    database:config.get("database"),
    password:config.get("password")
});

connection.connect();
route.use(express.json());



route.get("/itemlist",(request,response)=>{
    var queryText="select * from item";
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

route.get("/getItem/:id",(request,response)=>{
    var queryText=`select * from item where id=${request.params.id}`;
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

route.delete("/deleteItem/:id",(request,response)=>{
    var queryText=`delete  from item where id=${request.params.id}`;
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



route.put("/updateItem/:id",(request,response)=>{
    var id=request.params.id;
    var item_category=request.body.item_category;
    var item_image=request.body.item_image;
    var item_name=request.body.item_name;
    var item_price=request.body.item_price;
    var queryText=`update item set item_category='${item_category}',item_image='${item_image}',item_name='${item_name}',item_price=${item_price} where id=${id}`;
   
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


route.post("/addItem",upload.single('item_image'),(request,response)=>{
    console.log(request.body.id+" "+request.file.item_image)

    var item_category=request.body.item_category;
    var item_image=request.file.filename;
    var item_name=request.body.item_name;
    var item_price=request.body.item_price;
    console.log(item_image+" "+item_name)
    var queryText=`insert into item(item_category,item_image,item_name,item_price)values('${item_category}','${item_image}','${item_name}',${item_price})`;

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
