$(document).ready(function() 
{
    console.log("ready called"); 
    
    var pending = 
    $('#req-table').dataTable( 
    {
        columns: 
        [
            {title: "First Name"},
            {title: "Last Name"},
            {title: "Email"},
            {title: "Amount Requested"},
            {title: "Date Submitted"},
            {title: "Purpose"}
//            {title: "Approve/Deny Request"}
        ],
        "processing": true, 
//        "serverSide": true,
        "ajax": 
        {
            "url": "/ERS/TableRequestServlet",  // table data supplied by Ajax json file instead
            "dataSrc": "data",
            "type": "POST"
        }
    });
});

//function addParam(name, value)
//{
//    var href = window.location.href;
//    var regex = new RegExp("[&\\?]" + name + "=");
//    if(regex.test(href))
//    {
//    regex = new RegExp("([&\\?])" + name + "=\\d+");
//    window.location.href = href.replace(regex, "$1" + name + "=" + value);
//    }
//    else
//    {
//        if(href.indexOf("?") > -1)
//          window.location.href = href + "&" + name + "=" + value;
//        else
//          window.location.href = href + "?" + name + "=" + value;
//    }
//}

$("#approve-req").click
(
    var approve = 
    $('#req-table').dataTable( 
    {
        columns: 
        [
            {title: "First Name"},
            {title: "Last Name"},
            {title: "Email"},
            {title: "Amount Requested"},
            {title: "Date Submitted"}
        ],
        "processing": true, 
        "ajax": 
        {
            "url": "/ERS/TableApproveServlet",  
            "dataSrc": "data",
            "type": "POST"
        }
    });
);    

//$("#deny-req").click
//(
//function()
//{
//    // show table of denied requests 
//}
//);      
//
//$("#all-req").click
//(
//function()
//{
//    // show table of all requests 
//}
//);  
//
//$("own-req").click
//(
//function()
//{
//    //show table of your own requests 
//}
//)
//
//$("new-req").click
//(
//    function()
//    {
//        //popup window to to submit new request 
//    }
//)
