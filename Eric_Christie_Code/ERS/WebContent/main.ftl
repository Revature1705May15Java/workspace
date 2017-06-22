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
      <!-- RESOLVE MODAL -->
      <#include "./templates/bootstrap4/resolve-modal.html" parse=true>
    <#else>
      <!-- REQUEST MODAL -->
      <#include "./templates/bootstrap4/request-modal.html" parse=true>
    </#if>
  </#if>

  <!-- MAIN CONTENT -->
  <#-- <#include "./templates/bootstrap4/main-tables.html" parse=true> -->
  <#-- <#include "./templates/bootstrap4/main-content.html" parse=true> -->
  <#include "./templates/bootstrap4/main-tables2.html" parse=true>

  
  <script>
    $(document).ready(function() {
      // TODO add feature detection and stuff to handle browsers with missing features
      $('[data-toggle="tooltip"]').tooltip(); // initialize tooltips
      $('[data-toggle="popover"]').popover(); // enable popovers
      links.forEach(function(link) {
        setupNavigationCancel(link);
      });
      
      modals.forEach(function(modal) {
        setupAjaxSubmit(modal);
        setupResetOnHide(modal.selector);
      });
      setupPasswordConfirmation('#userPassword', '#userConfirm');
      setupVaryingResolveModal();
      $('#resolvedTable').DataTable();
      $('#pendingTable').DataTable();
    });
  </script>
</body>
</html>