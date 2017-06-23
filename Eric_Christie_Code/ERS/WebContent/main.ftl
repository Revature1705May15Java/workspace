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
  <#-- <#include "./templates/bootstrap4/main-tables2.html" parse=true> -->
  <#include "./templates/bootstrap4/main-tables3.html" parse=true>

  
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
        info: false,
        responsive: true,
        paging: false,
        scrollY: '40%',
        //scrollCollapse: true,
        columnDefs: [
          { // requester
            targets: 0,
            responsivePriority: 1
          },
          { // requester email
            targets: 1,
            responsivePriority: 4
          },
          { // date requested
            targets: 2,
            responsivePriority: 3
          },
          { // purpose
            targets: 3,
            responsivePriority: 5
          },
          { // amount
            targets: 4,
            responsivePriority: 2
          },
          { // approve
            targets: 5,
            responsivePriority: 7,
            searchable: false,
            orderable: false
          },
          { // deny
            targets: 6,
            responsivePriority: 7,
            searchable: false,
            orderable: false
          }
        ]
      });
      $('#resolvedTable').DataTable({
        info: false,
        responsive: true,
        paging: false,
        scrollY: '50%',
        //scrollCollapse: true,
        columnDefs: [
          { // status
            targets: 0,
            responsivePriority: 2
          },
          { // requester
            targets: 1,
            responsivePriority: 3
          },
          { // requester email
            targets: 2,
            responsivePriority: 7
          },
          { // date requested
            targets: 3,
            responsivePriority: 6
          },
          { // purpose
            targets: 4,
            responsivePriority: 10
          },
          { // resolver
            targets: 5,
            responsivePriority: 4
          },
          { // resolver email
            targets: 6,
            responsivePriority: 8
          },
          { // date resolved
            targets: 7,
            responsivePriority: 5
          },
          { // note
            targets: 8,
            responsivePriority: 9
          },
          { // amount
            targets: 9,
            responsivePriority: 1
          }
        ]
      });
      $('#employeesTable').DataTable({
        info: false,
        responsive: true,
        paging: false,
        scrollY: '50%',
        //scrollCollapse: true,
        columnDefs: [
          { // employee
            targets: 0
          },
          { // email
            targets: 1
          }
        ]
      });
      $('.dataTables_filter input').removeClass('form-control-sm');
      //$('#pendingTable_wrapper .col-sm-12.col-md-6').html('Pending Reimbursement Requests');
      //$('#resolvedTable_wrapper .col-sm-12.col-md-6').html('Resolved Reimbursement Requests');
    });
  </script>
</body>
</html>