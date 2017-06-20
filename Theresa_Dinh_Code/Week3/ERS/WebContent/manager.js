$(document).ready(function() 
{
    console.log("ready called"); 
    
    var pending = 
    $('#req-table').DataTable( 
    {
        columns: 
        [
            {title: "First Name"},
            {title: "Last Name"},
            {title: "Email"},
            {title: "Amount Requested"},
            {title: "Purpose"},
            {title: "Date Submitted"}
//            {title: "Approve/Deny Request"}
        ],
        "processing": true,
//        "serverSide": true,
        "ajax": 
        {
            "url": "src/data/pendingRequests.json",  // table data supplied by Ajax json file instead
            "type": "POST"
        }
    });
});

function addParam(name, value)
{
    var href = window.location.href;
    var regex = new RegExp("[&\\?]" + name + "=");
    if(regex.test(href))
    {
    regex = new RegExp("([&\\?])" + name + "=\\d+");
    window.location.href = href.replace(regex, "$1" + name + "=" + value);
    }
    else
    {
        if(href.indexOf("?") > -1)
          window.location.href = href + "&" + name + "=" + value;
        else
          window.location.href = href + "?" + name + "=" + value;
    }
}

$("#approve-req").click
(
    function()
    {
        alert("function called"); 
        
        $("#table-subheader").text("Approved Requests"); 

        var approve = $('#req-table').DataTable( 
        {
            columns: 
            [
                {title: "First Name"},
                {title: "Last Name"},
                {title: "Email"},
                {title: "Amount Requested"},
                {title: "Purpose"},
                {title: "Date Submitted"}, 
            ],
            "processing": true,
//            "serverSide": true,
            "ajax":
            {
                "url": "ERS/src/data/approvedRequests.txt",  // table data supplied by Ajax json file instead
                "type": "post"
            }
        });
    }
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