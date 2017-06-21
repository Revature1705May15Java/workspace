<div id="create-request">
  <h2>Create Request</h2>
  <form class="form-horizontal" id="create-request-form" action="submitRequest" method="POST">
    <div class="form-group">
      <label class="control-label col-md-2" for="purpose-field">Purpose:</label>
      <input type="text" id="purpose-field" style="width: 60%" name="purpose"/>
    </div>
    <div class="form-group">
      <label class="control-label col-md-2" for="amount-field">Amount:</label>
      <input type="number" id="amount-field" step=".01" min="0" name="amount"/>
    </div>
    <button class="btn btn-default" type="submit">Submit Request</button>
  </form>
</div>