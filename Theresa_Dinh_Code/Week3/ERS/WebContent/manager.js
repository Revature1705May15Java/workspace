$(document).ready(function() 
{
    var table = $('#req-table').dataTable( 
    {
        columns: 
        [
            {title: "Request ID"},
            {title: "First Name"},
            {title: "Last Name"},
            {title: "Email"},
            {title: "Amount Requested"},
            {title: "Date Submitted"},
            {title: "Purpose"},
            {title: "Request Status"}
        ],
        "processing": true, 
        "ajax": 
        {
            "url": "/ERS/TableRequestServlet",  
            "dataSrc": "data",
            "type": "POST"
        },
        "orderFixed": [7, 'asc'],
        "rowGroup": 
        {
            "dataSrc": 7
        }
    });
    table.on('click', 'tr', function()
    {
        if($(this).hasClass('selected'))
        {
            $(this).removeClass('selected'); 
        }
        else
        {
            console.log("else called"); 
            table.$('tr.selected').removeClass('selected'); 
            $(this).addClass('selected'); 
            
            var id = parseInt($('.selected :first-child').text());  
            var status = $('.selected :last-child').text(); 
            
            var $row = $('tr.selected').closest('tr'); 
            
            var $data = $row.find("td:nth-child(2)"); 
            $.each($data, function()
            {
                firstname = $(this).text(); 
            }); 
                        
            $data = $row.find("td:nth-child(3)"); 
            $.each($data, function()
            {
                lastname = $(this).text(); 
            }); 
            name = firstname + " " + lastname; 
            
            $data = $row.find("td:nth-child(4)"); 
            $.each($data, function()
            {
                email = $(this).text(); 
            }); 
            
            $data = $row.find("td:nth-child(5)"); 
            $.each($data, function()
            {
                amount = $(this).text(); 
            });             
            
            $data = $row.find("td:nth-child(6)"); 
            $.each($data, function()
            {
                purpose = $(this).text();
                if(purpose == null)
                    purpose = "-"; 
            });             

            if(status == "Pending")
            {
                console.log("if" + id); 
                $('#resolve-modal').modal('show');
                $('#reqid').val(id); 
//                $('#reqid').html(id);
            }
        }
    }); 
    $('#resolve-modal').on('show.bs.modal', function () 
    {
        $('#rname').text(name); 
        $('#remail').text(email);
        $("#ramount").text(amount); 
        $("#rpurpose").text(purpose); 
    });
});
