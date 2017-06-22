<div id="request-action">
  <form class="form-horizontal" id="request-action-form" action="updateRequest" method="POST">
    <div class="form-group">
      <label class="control-label col-md-2" for="note-field">Note:</label>
      <input type="text" id="note-field" style="width: 60%" name="note"/>
    </div>
    <input type="hidden" id="hidden-action-field" name="action"/>
    <input type="hidden" id="hidden-id-field" name="id"/>
	<button id="cancel-action-btn" class="btn btn-default" type="button" data-dismiss="modal">Cancel</button>
    <button class="btn btn-default" type="submit">Submit</button>
  </form>
</div>