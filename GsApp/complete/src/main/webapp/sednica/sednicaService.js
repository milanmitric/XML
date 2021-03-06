angular.module('xapp')
.service('sednicaService', function($http){
	return{
		getSednicaStatus: function(onSuccess, onError){
             var req = {
                            method: 'GET',
                            url: '/api/getsednicastatus'
                        }

             			$http(req).then(onSuccess, onError);
		},
		setSednicaStatus: function(status,onSuccess, onError){
                             var req = {
                             					method: 'POST',
                             					url: '/api/startstopsednica/'+status
                             			}
                             				$http(req).then(onSuccess, onError);
        },
		prihvati: function(amaList, onSuccess,onError){
            var req = {
                    method: 'POST',
                    url: '/api/prihvatiovono',
                    headers: {
                                    'Content-Type': 'application/json'
                    },
                    data: amaList
                }
                $http(req).then(onSuccess, onError);
        },
		lal:function(onSuccess, onError){

		},
		update:function(onSuccess, onError){

		}
	}
});