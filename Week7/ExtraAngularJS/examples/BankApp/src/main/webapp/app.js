var bankApp = angular.module("bankApp",["ui.router"]);

bankApp.config(function($stateProvider,$urlRouterProvider){
	
	console.log("Init bankApp...");
	
	$stateProvider
		.state("login",{
			url:"/login",
			templateUrl:"templates/login.html",
			controller:"LoginCtrl as login"
		})
		.state("home", {
			url:"/home",
			templateUrl:"templates/home.html",
			controller:"AccountCtrl as account"
		})
		.state("home.op", {
			url:"/home/op",
			templateUrl:"templates/op.html",
		})
		.state("register",{
			url:"/register",
			templateUrl:"templates/register.html",
			controller:"RegisterCtrl as register"
		});
	
});

bankApp.controller("LoginCtrl",function(UserService, $state){
	var login = this;
	login.user = UserService.getUser();
	login.doLogin = function(){
		UserService.authenticateUser();
		if(login.user.authenticated){
			$state.go("home");
		}else{
			alert("Bad login!");
		}
	};
});

bankApp.controller("RegisterCtrl", function(UserService, $state){
	var register = this;
	
	register.user = UserService.getUser();
	register.doRegister = function(){
		var promise = UserService.registerUser();
		
		promise.then(
				function(response){
					console.log(response);
					UserService.setUser(response.data);
					$state.go('register');
				},function(error){
					console.log(error);
					alert(error.data.cause.cause.message);
				}
		);
		
	}
	
});

bankApp.service("UserService", function($http,$q){
	var service = this;
	service.user = {
			username:"",
			password:"",
			authenticated:false
	};
	service.getUser = function(){
		return service.user;
	};
	service.setUser = function(data){
		service.user.username = data.username;
		service.user.password = data.password;
		service.user.authenticated = data.authenticated;
	};
	service.userStore = [
	                     {
	                    	 username:"Tom",
	                    	 password:"1234"
	                     }
	];
	service.authenticateUser = function(){
		var userFromStore = {};
		for(var i = 0; i < service.userStore.length;i++){
			userFromStore = service.userStore[i];
			if(userFromStore.username === service.user.username
					&&
				userFromStore.password === service.user.password){
				service.user.authenticated = true;
			}
		}
	};
	
	service.registerUser = function(){
		var promise;
		
		promise = $http.post(
				'http://localhost:8085/BankApp/rest/user/register',
				service.user
			).then(
				function(response){
					console.log(response);
					return response;
				},
				function(error){
					return $q.reject(error);
				}
		);
		
		return promise;
	};
});

/*
 * Commented out due to using the AccountCtrl
 */
//bankApp.controller("HomeCtrl", function(UserService){
//	var home = this;
//	console.log("Init HomeCtrl...");
//	
//	home.user = UserService.getUser();
//});

bankApp.service("AccountService", function(){
	
	var service = this;
	
	service.account = {
		id:0,
		balance:0,
		amount:0
	};
	
	service.getAccount = function(){
		return service.account;
	};
	
	service.setAccount = function(data){
		service.account.id = data.id;
		service.account.balance = data.balance;
		service.account.amount = data.amount;
	};
	
	service.fetchAccountByUserId = function(userId){
		// TODO make actual call with userId
		return service.account;
	};
	
});

bankApp.controller("AccountCtrl", 
					function(UserService, AccountService, $state){
	
	var account = this;
	
	account.curAccount = AccountService.getAccount();
	
	account.amount = 0;
	
	account.curUser = UserService.getUser();
	
	// TODO Make call to AccountService.fetchAccountByUserId(userId)
	
	account.deposit = function(){
		// TODO Make call to AccountService.deposit(account.curAccount,account.amount, account.curUser)
		account.curAccount.balance += account.amount;
		account.amount = 0;
	};
	
	account.withdraw = function(){
		//TODO Make call to AccountService.withdraw(account.curAccount,account.amount, account.curUser)
		account.curAccount.balance -= account.amount;
		account.amount = 0;
	};
	
	
});

bankApp.controller("NavCtrl", function(UserService, $state){
	
	var nav = this;
	
	nav.user = UserService.getUser();
	
	nav.isActive = function(viewLocation){
		return viewLocation === $state.current.url;
	};
	
	nav.logout = function(){
		UserService.setUser({
			username:"",
			password:"",
			authenticated:false
		});
		$state.go("login");
	};
	
});


