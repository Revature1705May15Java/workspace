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
      $('#pendingTable').DataTable({
        responsive: true,
        paging: false,
        scrollY: '80%',
        columnDefs: [
          { // request id
            targets: 0,
            visible: false,
            searchable: false
          },
          { // requester
            targets: 1,
            responsivePriority: 1
          },
          { // requester email
            targets: 2,
            responsivePriority: 4
          },
          { // date requested
            targets: 3,
            responsivePriority: 3
          },
          { // purpose
            targets: 4,
            responsivePriority: 5
          },
          { // amount
            targets: 5,
            responsivePriority: 2
          },
          { // approve
            targets: 6,
            responsivePriority: 7,
            searchable: false,
            orderable: false
          },
          { // deny
            targets: 7,
            responsivePriority: 7,
            searchable: false,
            orderable: false
          }
        ]
      });
      $('#resolvedTable').DataTable({
        responsive: true,
        paging: false,
        scrollY: '80%',
        columnDefs: [
          { // request id
            targets: 0,
            visible: false,
            searchable: false
          },
          { // status
            targets: 1,
            responsivePriority: 2
          },
          { // requester
            targets: 2,
            responsivePriority: 3
          },
          { // requester email
            targets: 3,
            responsivePriority: 7
          },
          { // date requested
            targets: 4,
            responsivePriority: 6
          },
          { // purpose
            targets: 5,
            responsivePriority: 10
          },
          { // resolver
            targets: 6,
            responsivePriority: 4
          },
          { // resolver email
            targets: 7,
            responsivePriority: 8
          },
          { // date resolved
            targets: 8,
            responsivePriority: 5
          },
          { // note
            targets: 9,
            responsivePriority: 9
          },
          { // amount
            targets: 10,
            responsivePriority: 1
          }
        ]
      });
      $('#employeesTable').DataTable({
        // responsive: true,
        paging: false,
        scrollY: '80%'
      });
      $('.dataTables_filter input').removeClass('form-control-sm')
    });
  </script>
</body>
</html>