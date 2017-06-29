package snippet;

public class Snippet {
	 <tbody>
	    <#list accounts as account>
	    <tr>
	    <td> ${account.id}</td> <td>${account.balance}</td> 
	   </#list>
	    </tr>
	    
	    </tbody>
}

