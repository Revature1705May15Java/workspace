initPasswordValidation();

function initPasswordValidation() {
    // Only attempt validate passwords on employee account page
    if ($('#employeeAccountContainer').length == 0) return;

    var password = document.getElementById('employeeAccountContainer').getElementsByClassName('password')[0];
    var confirm = document.getElementById('employeeAccountContainer').getElementsByClassName('confirmPassword')[0];

    function validatePassword(){
        if(password.value != confirm.value) {
            confirm.setCustomValidity('Passwords don\'t match');
        } else {
            confirm.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm.onkeyup = validatePassword;
}
