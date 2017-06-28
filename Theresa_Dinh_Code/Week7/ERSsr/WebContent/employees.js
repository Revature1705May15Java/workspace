$(document).ready(function() 
{
    console.log("ready called"); 
    
    table = 
    $('#emp-table').dataTable( 
    {
        columns: 
        [
            {title: "First Name"},
            {title: "Last Name"},
            {title: "Email"},
            {title: "Position"}
        ],
        "processing": true, 
        "ajax": 
        {
            "url": "/ERS/TableEmployeeServlet",  
            "dataSrc": "data",
            "type": "POST"
        },
        "orderFixed": [3, 'dsc'],
        "rowGroup": 
        {
            "dataSrc": 3
        }
    });
    $('#emp-table tbody').on('click', 'tr', function()
    {
        console.log("click acknowledged"); 
            if($(this).hasClass('selected'))
            {
                $(this).removeClass('selected'); 
            }
            else
            {
                table.$('tr.selected').removeClass('selected'); 
                $(this).addClass('selected'); 

                var $row = $('tr.selected').closest('tr'); 
            
                var $data = $row.find("td:nth-child(1)"); 
                $.each($data, function()
                {
                    firstname = $(this).text();
                });  
                
                $data = $row.find("td:nth-child(2)"); 
                $.each($data, function()
                {
                    lastname = $(this).text();
                });  
                name = firstname + " " + lastname;
                
                 $data = $row.find("td:nth-child(3)"); 
                $.each($data, function()
                {
                    email = $(this).text();
                });         
                
//                $data = $row.find("td:nth-child(4)"); 
//                $.each($data, function()
//                {
//                    position = $(this).text();
//                });    
            }
    });    
    $('#manager-modal').on('show.bs.modal', function () 
    {
        $('#ename').text(name); 
        $('#eemail').text(email);
    });
});



