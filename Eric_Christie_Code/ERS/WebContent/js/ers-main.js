/* javascript file for the main page of the application */

$(document).ready(function() {
  setupAjaxSubmit('#registrationForm');
  setupAjaxSubmit('#requestForm');
  setupAjaxSubmit('#settingsForm');
});

/*
 * - have non-ajax form submission trigger an event handler that instead sends an ajax request
 * - have the event fired when a modal is hidden trigger the calling of the reset method for the form in that modal
 */

function activatePasswordConfirmation(passwordInputSelector, confirmationInputSelector) {
  $(passwordInputSelector).on('change', function() {
    $(confirmationInputSelector).attr('pattern', '^' + $(passwordInputSelector).val() + '$');
  });
}

function setupAjaxSubmit(formSelector) {
  // if (!formSelector.startsWith('#')) {
  //   formSelector = '#' + formSelector;
  // }
  $(formSelector).submit(function(event) {
    console.log("form submission triggered: " + event);
    event.preventDefault();
  });
  $(formSelector).submit(function(event) {
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

function setupResetOnHide(modalSelector) {
  // if (!modalSelector.startsWith('#')) {
  //   modalSelector = '#' + modalSelector;
  // }
  $(modalSelector).on('hide.bs.modal', function(event) {
    $(`${modalSelector} form`).get(0).reset();
  })
}