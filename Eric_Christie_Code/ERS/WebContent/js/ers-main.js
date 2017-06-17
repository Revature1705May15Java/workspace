/* javascript file for the main page of the application */

$(document).ready(function() {
  // TODO add feature detection and stuff to handle browsers with missing features
  $('[data-toggle="tooltip"]').tooltip(); // initialize tooltips
  var links = ['#registrationButton', '#requestButton', '#settingsButton'];
  links.forEach(function(ln) {
    setupNavigationCancel(ln);
  });
  var modals = ['#registrationModal', '#requestModal', '#settingsModal'];
  modals.forEach(function(modal) {
    setupAjaxSubmit(modal);
    setupResetOnHide(modal);
  });
  setupPasswordConfirmation('#userPassword', '#userConfirm');
});

/*
 * - have non-ajax form submission trigger an event handler that instead sends an ajax request
 * - have the event fired when a modal is hidden trigger the calling of the reset method for the form in that modal
 * 
 * -** checkbox inputs can be toggled programmatically via $('#checkboxId').get(0).checked = true/false
 */

function setupPasswordConfirmation(passwordInputSelector, confirmationInputSelector) {
  $(passwordInputSelector).on('change', function() {
    $(confirmationInputSelector).attr('pattern', '^' + $(passwordInputSelector).val() + '$');
  });
}

/**
 * 
 * @param {*} modalSelector 
 * @param {*} responseHandler a function that takes in the modal selector, the response object, 
 * the jQuery XMLHttpRequest object, the status string, and an error string
 */
function setupAjaxSubmit(modalSelector, responseHandler) {
  // if (!modalSelector.startsWith('#')) {
  //   modalSelector = '#' + modalSelector;
  // }
  $(modalSelector + ' form').submit(function(event) {
    // cancel the normal, non-ajax form submission request
    event.preventDefault();
    var url = $(this).attr('action');
    var inputsObject = {};
    var inputsArray = $(this).serializeArray().forEach(function(input) {
      console.log(input);
      inputsObject[input.name] = input.value;
    });

    var xhr = $.post({
      url: url,
      data: inputsObject,
      dataType: 'json',
      // global: true, // this controls whether or not this request triggers global ajax event handlers.
        // could be useful if you want other parts of the document to do things whenever an ajax request is send
      headers: {},
      // ifModified: true, // use this to only allow a request to be successful when the response has changed
        // since the previous request
      success: function(res, status, xhr) {
        console.log('update successful: ' + status);
        console.log('Headers: ' + xhr.getAllResponseHeaders());
        console.log(res);
        // TODO be sure to close the modal after receiving a response from the server
        // $(modalSelector).modal('hide');
        responseHandler(res, status, xhr);
      },
      error: function(xhr, status, error) {
        
        // TODO you probably shouldn't close the modal if the response contains an error code
      },
      complete: function(xhr, status) {
        console.log('XMLHttpRequest done: ' + status);
      }
    });
  });
}

function setupResetOnHide(modalSelector) {
  // if (!modalSelector.startsWith('#')) {
  //   modalSelector = '#' + modalSelector;
  // }
  $(modalSelector).on('hide.bs.modal', function(event) {
    $(modalSelector + ' form').get(0).reset();
  })
}

function setupNavigationCancel(linkSelector) {
  // TODO consider also changing the href attribute on the links
  $(linkSelector).click(function(event) {
    // TODO include feature detection to determine when link navigation cancelling should be activated
    event.preventDefault(); // stop navigation to another page from occurring when links are clicked
    // event.stopPropagation(); // stop the link click event from propagating
  });
}

function registrationResponseHandler(modalSelector, res, xhr, status, error) {

}

function requestResponseHandler(modalSelector, res, xhr, status, error) {

}

function settingsResponseHandler(modalSelector, res, xhr, status, error) {
  if (error) {
    // display some kind of message to user when the response is an error
    console.log('update error: ' + status + ' - ' + error);
  } else {
    for (var prop in res) {

    }
  }
}