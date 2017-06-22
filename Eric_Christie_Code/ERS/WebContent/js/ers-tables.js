/* javascript for handling data presentation on the main page */
function setupTables() {
  var employeesList = new List('employees', {
    valueNames: [
      'firstname',
      'lastname',
      'email',
      { data: ['employee-id'] }
    ]
  });

  $('#employeeSearch').on('keyup', function() {
    var searchString = $(this).val();
    employeesList.search(searchString);
  })

  var pendingList = new List('pendingRequests', {valueNames: [
      'request-id',
      'requester-firstname',
      'requester-lastname',
      'request-timestamp',
      'request-purpose',
      'amount',
      { data: ['requester-id', 'requester-email'] }
    ]
  });

  var resolvedList = new List('resolvedRequests', {
    valueNames: [
      'request-id',
      'status',
      'requester-firstname',
      'requester-lastname',
      'request-timestamp',
      'resolver-firstname',
      'resolver-lastname',
      'resolve-timestamp',
      'amount',
      { data: ['requester-id', 'requester-email', 'purpose', 'resolver-id', 'resolver-email', 'note'] }
    ]
  });
}

