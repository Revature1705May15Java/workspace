/* javascript file used by pages other than main */

function activatePasswordConfirmation(passwordInputSelector, confirmationInputSelector) {
  $(passwordInputSelector).on('change', function() {
    $(confirmationInputSelector).attr('pattern', '^' + $(passwordInputSelector).val() + '$');
  });
}