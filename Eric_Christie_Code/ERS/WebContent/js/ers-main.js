/* javascript file for the main page of the application */

$(document).ready(function() {
  let modals = ['#registrationModal', '#requestModal', '#settingsModal'];
  modals.forEach((m) => {
    setupAjaxSubmit(`${m} form`);
    setupResetOnHide(m);
  });
  activatePasswordConfirmation('#userPassword', '#userConfirm');
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
        console.log(`update successful: ${status}`);
        console.log(res);
        // TODO be sure to close the modal after receiving a response from the server
        
      },
      error: function(xhr, status, error) {
        console.log(`update error: ${status} - ${error}`);
        // TODO you probably shouldn't close the modal if the response contains an error code
      },
      complete: function(xhr, status) {
        console.log(`update complete: ${status}`);
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