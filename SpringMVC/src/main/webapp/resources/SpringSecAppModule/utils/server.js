var SpringSecApp=angular.module("SpringSecApp",[]);
SpringSecApp.factory('sendRequestService',['$http','$q',function($http,$q){
        return function(params){
                var p_defered = $q.defer();
                var p_request;
                var p_headers;
               // $httpProvider.defaults.headers.common = {'userIdentifier': 'ayushi'};
                //set id in header of request
                //p_headers = angular.extend({},{'id':window.btoa(localStorage.getItem('Id'))},{'Content-Type': 'application/json'},params.addHeaders)
                p_headers = angular.extend({},{'Content-Type': 'application/json'},params.addHeaders)
                // Fill Request Parameters
                p_request = $http({
                        method : params.method,
                        url: params.url,
                        data: params.data,
                        headers: p_headers
                });
                // Make Request
                p_request
                .then(function(response) {
                        p_defered.resolve(response);
                },function(rejection) {
                        p_defered.reject(rejection);
                });
                return p_defered.promise;
                // Returns Promise
        };
}]);

