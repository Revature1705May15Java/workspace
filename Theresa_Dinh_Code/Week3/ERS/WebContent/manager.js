$(document).ready(function() 
{
    $('#body-table').DataTable( 
    {
//        data: //javascript table name here,
        columns: 
        [
            {title: "First Name"},
            {title: "Last Name"},
            {title: "Email"},
            {title: "Amount Requested"},
            {title: "Purpose"},
            {title: "Date Submitted"}, 
            {title: "Approve/Deny Request"}
        ],
        "serverSide": true,
        "ajax": "pendingRequests.txt"  // table data supplied by Ajax json file instead
    });
});


$("#approve-req").click
(
function()
{
    // show table of approved requests 
}
);    

$("#deny-req").click
(
function()
{
    // show table of denied requests 
}
);      

$("#all-req").click
(
function()
{
    // show table of all requests 
}
);  

$("own-req").click
(
function()
{
    //show table of your own requests 
}
)

$("new-req").click
(
function()
{
    //popup window to to submit new request 
}
)