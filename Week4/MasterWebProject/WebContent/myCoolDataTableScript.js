/**
 * data tables
 */
window.onload = function(){
	$('.myAwesomeDataTables').DataTable();
	
	/*
	 * Custom settings
	 *  - Save the state of my DataTable
	 *  - Disable ordering for column with index 1
	 *   
	 $('.myAwesomeDataTables').DataTable(
		{
		 stateSave: true,
		 columnDefs:[
		             {orderable:false, targets:1}
		             ]
		}
	);
	
   */
}