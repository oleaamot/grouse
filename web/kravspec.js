var app = angular.module('grouse-app', []);

/**
 * kravspec.js
 *
 * Used with kravspec.html to provide the following functionality:
 *
 *
 */
var requirementsController = app.controller('RequirementsController',
  ['$scope', '$http', function ($scope, $http) {

    var token = GetUserToken();
    console.log("Grouse kravspec.js page load. User token is set to " + token);
    $scope.isopen = true;
    var method = 'GET';
    $http({
      method: method,
      url: urlToMenuItems,
      headers: {'Authorization': token}
    }).then(function successCallback(response) {
      $scope.menuItems = response.data;
      console.log(method + " GET urlToMenuItems[" + urlToMenuItems + "] returned " + JSON.stringify(response));
    }, function errorCallback(response) {
      console.log(method + " GET urlToMenuItems[" + urlToMenuItems + "] returned " + JSON.stringify(response));
    })

    /**
     * menuItem_selected
     *
     * Description of what function does
     */
    $scope.menuItem_selected = function (menuItem) {
      console.log("menuItems[" + JSON.stringify(menuItem) + "] selected.");
    };
  }]);
