function activatePasswordConfirmation(passwordInputSelector, confirmationInputSelector) {
  $(passwordInputSelector).on('change', function() {
    $(confirmationInputSelector).attr('pattern', '^' + $(passwordInputSelector).val() + '$');
  });
}

/*
 * - have non-ajax form submission trigger an event handler that instead sends an ajax request
 * - have the event fired when a modal is hidden trigger the calling of the reset method for the form in that modal
 */


function setupAjaxSubmit(formId) {
  if (!formId.startsWith('#')) {
    formId = '#' + formId;
  }
  $(formId).submit(function(event) {
    // cancel the normal, non-ajax form submission request
    event.preventDefault();

    let url = $(this).attr('action');

    let inputsObject = {};
    let inputsArray = $(this).serializeArray().forEach((input) => {
      console.log(input);
      inputsObject[input.name] = input.value;
    });

    let xhr = $.post({
      url: url,
      data: inputsObject,
      dataType: 'json',
      // global: true, // this controls whether or not this request triggers global ajax event handlers.
        // could be useful if you want other parts of the document to do things whenever an ajax request is send
      headers: {},
      // ifModified: true, // use this to only allow a request to be successful when the response has changed
        // since the previous request
      success: function(res, status, xhr) {
        console.log(`account settings update success: ${status}`);
        console.log(res);
      },
      error: function(xhr, status, error) {
        console.log(`account settings update error: ${status} - ${error}`);
      },
      complete: function(xhr, status) {
        console.log(`account settings update complete: ${status}`);
      }
    });
  });
}

function setupResetActions() {
  $('button[type="reset"]').each(function(i, elem) {

  });
}

function setupSubmitButtons() {
  $('button[type="submit"]').each(function(i, elem) {

  });
}

function resetForm(formId) {
  document.getElementById(formId).reset();
}

function submitSettingsForm() {
  $.ajax({
    url: 'settings',
    method: 'POST',
    data: {
      email: $('#userEmail').val(),
      password: $('#userPassword').val(),
      confirm: $('#userConfirm').val(),
      firstname: $('#userFirstname').val(),
      lastname: $('#userLastname').val(),
      emailAlertsOn: $('#userEmailAlerts').checked
    },
    dataType: 'json',
    success: function(res, status, xhr) {
      console.log(`account settings update success: ${status}`);
      console.log(res);
    },
    error: function(xhr, status, error) {
      console.log(`account settings update error: ${status} - ${error}`);

    },
    complete: function(xhr, status) {
      console.log(`account settings update complete: ${status}`);

    }
  });
}

function submitRegisterForm() {
  $.ajax({
    url: 'user',
    method: 'POST',
    data: {
      firstname: $('form#registerForm #newFirstname').val(),
      lastname: $('form#registerForm #newLastname').val(),
      email: $('form#registerForm #newEmail').val(),
      isManager: $('form#registerForm #newAccountType').val()=='manager'
    },
    dataType: 'json',
    success: function(res, status, xhr) {
      console.log(`registration success: ${status}`);
      console.log(res);
    },
    error: function(xhr, status, error) {
      console.log(`registration error: ${status} - ${error}`);

    },
    complete: function(xhr, status) {
      console.log(`registration complete: ${status}`);

    }
  });
}

function submitRequestForm() {
  $.ajax({
    url: 'request',
    method: 'POST',
    data: {},
    dataType: 'json',
    success: function(res, status, xhr) {
      console.log(`request creation success ${status}`);
      console.log(res);
    },
    error: function(xhr, status, error) {
      console.log(`request creation error: ${status} - ${error}`);

    },
    complete: function(xhr, status) {
      console.log(`request creation complete: ${status}`);

    }
  });
}

