<!DOCTYPE html>
<html lang="en">

<body>

  <#if user.isManager()>
    <h2>Welcome to the Manager Homepage, ${user.getFirstname()} ${user.getLastname()}</h2>

    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Status</th>
          <th >Amount</th>
          <th id="requester">Requested by</th>
          <th id="request-date">On</th>
          <th id="request-purpose">For</th>
          <th id="resolver">Resolved by</th>
          <th id="resolved-date">On</th>
          <th id="resolve-note">Because</th>
          <th></th>
          <th></th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>

      </tbody>
    </table>
  <#else>
    <h2>Welcome to the Employee Homepage, ${user.getFirstname()} ${user.getLastname()}</h2>

    <table>
      <thead>
        <tr>
          <th id="request-id">ID</th>
          <th id="request-state">Status</th>
          <th id="request-amount">Amount</th>
          <th id="requester">Requested by</th>
          <th id="request-purpose">For</th>
          <th id="resolver">Resolved by</th>
          <th id="resolved-date">On</th>
          <th id="resolve-note">Because</th>
        </tr>
      </thead>
      <tbody>

      </tbody>
    </table>
  </#if>
  
</body>
</html>