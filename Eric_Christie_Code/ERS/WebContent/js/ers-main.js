/* javascript file for the main page of the application */

var links = ['#registrationButton', '#requestButton', '#settingsButton', 'a[data-value="approve"]', 'a[data-value="deny"]'];

var modals = [
    {
      selector: '#registrationModal',
      responseHandler: function(res, status, xhr) {
        var modalSelector = '#registrationModal';
        location.reload(true);
      }
    },
    {
      selector: '#requestModal',
      responseHandler: function(res, status, xhr) {
        var modalSelector = '#requestModal';
        location.reload(true);
      }
    },
    {
      selector: '#settingsModal',
      responseHandler: function(res, status, xhr) {
        var modalSelector = '#settingsModal';

        // var emailInput = $(modalSelector + ' form input[name="email"]').get(0);
        // var firstnameInput = $(modalSelector + ' form input[name="firstname"]').get(0);
        // var lastnameInput = $(modalSelector + ' form input[name="lastname"]').get(0);
        // var emailAlertsInput = $(modalSelector + ' form input[name="emailAlerts"]').get(0);

        // emailInput.defaultValue = res.email;
        // firstnameInput.defaultValue = res.firstname;
        // lastnameInput.defaultValue = res.lastname;
        // emailAlertsInput.defaultChecked = res.emailAlertsOn;

        // emailInput.value = res.email;
        // firstnameInput.value = res.firstname;
        // lastnameInput.value = res.lastname;
        // emailAlertsInput.checked = res.emailAlertsOn;

        location.reload(true);
      }
    },
    {
      selector: '#resolveModal',
      responseHandler: function(res, status, xhr) {
        var modalSelector = '#resolveModal';
        location.reload(true);
      }
    }
  ];

/*
 * -** checkbox inputs can be toggled programmatically via $('#checkboxId').get(0).checked = true/false
 */



function setupPasswordConfirmation(passwordInputSelector, confirmationInputSelector) {
  $(passwordInputSelector).on('change', function() {
    $(confirmationInputSelector).attr('pattern', '^' + $(passwordInputSelector).val() + '$');
  });
}

function setupResetOnHide(modalSelector) {
  $(modalSelector).on('hide.bs.modal', function(event) {
    $(modalSelector + ' form').get(0).reset();
    document.activeElement.blur();
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

/**
 * @param modalObj an object representing a modal. it has 2 properties:
 * - selector: the selector string for the modal
 * - responseHandler: a function that takes in the response object, the status string, 
 * and the jQuery XMLHttpRequest object
 */
function setupAjaxSubmit(modalObj) {
  $(modalObj.selector + ' form').submit(function(event) {
    // cancel the normal, non-ajax form submission request
    event.preventDefault();
    var url = $(this).attr('action');
    var inputsObject = {};
    var inputsArray = $(this).serializeArray().forEach(function(input) {
      inputsObject[input.name] = input.value;
    });
    for (var prop in inputsObject) {
      console.log(prop + ' ' + inputsObject[prop]);
    }
    $(modalObj.selector + ' .progress').removeClass('hidden-xs-up');

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
        console.log('update status: ' + status);
        console.log('response headers: ' + xhr.getAllResponseHeaders());
        console.log(res);
        $(modalObj.selector + ' .progress').addClass('hidden-xs-up');
        modalObj.responseHandler(res, status, xhr);
        $(modalObj.selector).modal('hide');
        document.activeElement.blur();
      },
      error: function(xhr, status, error) {
        console.log('update error: ' + status + ' - ' + error);
        $(modalObj.selector + ' #error-message').removeClass('hidden-xs-up');
        $(modalObj.selector + ' .progress').addClass('hidden-xs-up');
        setTimeout(function() {
          $(modalObj.selector + ' #error-message').addClass('hidden-xs-up');
        }, 5000);
      },
      complete: function(xhr, status) {
        console.log('XMLHttpRequest done: ' + status);
      }
    });
  });
}

function setupVaryingResolveModal() {
  $('#resolveModal').on('show.bs.modal', function(event) {
    var button = $(event.relatedTarget);
    var requestId = button.data('id');
    var state = button.data('value');
    $('#resolveModal .modal-title').html(state + ' Reimbursement Request.');
    $('#resolveModal input[name="requestId"]').val(requestId);
    $('#resolveModal input[name="state"]').val(state);
  });
}

// TODO add popup behavior for viewing complete information for pending and resolved requests
function setupRequestDisplayModal() {
  $('#pendingDisplayModal').on('show.bs.modal', function(event) {
    var row = $(event.relatedTarget);
    
  });
  $('#resolvedDisplayModal').on('show.bs.modal', function(event) {
    var row = $(event.relatedTarget);
    
  });
}