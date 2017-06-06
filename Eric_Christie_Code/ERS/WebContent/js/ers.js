function activatePasswordConfirmation() {
  $('#confirmPassword').attr('pattern', $('#employeePassword').attr())
}

function enableResetButton() {
  $('#resetSettings').removeAttr('disabled');
}

function submitSettingsForm() {
  
}