SpringSecApp.controller("LoginController",['$scope','sendRequestService',function($scope,sendRequestService){

	$scope.message="Hello";
	$scope.submitDetails=function(){
		var obj={
				'name':window.btoa($scope.username),
				'password':window.btoa($scope.password)
		}
		var p_url = appConstants+'SpringProject/validateLogin';
		var p_attrs = {'method':'POST','url':p_url,'data':obj,'addHeaders':true};
		var promise = sendRequestService(p_attrs);
		promise.then(function(result){
			$scope.message=result;
		}, function (error) {
			console.log(error);
		});
	};
	}]);