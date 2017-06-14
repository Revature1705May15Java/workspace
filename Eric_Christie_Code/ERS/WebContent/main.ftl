<!DOCTYPE html>
<html lang="en">
<#include "./templates/bootstrap4/main-head.html" parse=true>
<body>
  <!-- NAVBAR -->
  <#include "./templates/bootstrap4/navbar.html" parse=true>

  <!-- SETTINGS MODAL -->
  <#include "./templates/bootstrap4/settings-modal.html" parse=true>
  <#if user??>
    <#if user.isManager()>
      <!-- REGISTRATION MODAL -->
      <#include "./templates/bootstrap4/registration-modal.html" parse=true>
    <#else>
      <!-- REQUEST MODAL -->
      <#include "./templates/bootstrap4/request-modal.html" parse=true>
    </#if>
  </#if>

  <div class="container">
    <#if user??>
      Welcome ${user.firstname} ${user.lastname}
    </#if>
    <!-- MAIN CONTENT -->
    <#include "./templates/bootstrap4/main-content.html" parse=true>
  </div>

  <script src="./js/ers-main.js"></script>
</body>
</html>