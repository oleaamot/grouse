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

    $scope.priorityValues = ['O', '1', '2'];

    $scope.selectedMenuItem = null;
    $scope.token = GetUserToken();

    console.log("Grouse kravspec.js page load. User token is set to " + $scope.token);
    $scope.isopen = true;
    var method = 'GET';
    $http({
      method: method,
      url: urlToMenuItems,
      headers: {'Authorization': $scope.token}
    }).then(function successCallback(response) {
      $scope.menuItems = response.data;
      console.log(method + " GET urlToMenuItems[" + urlToMenuItems + "] returned " + JSON.stringify(response));
    }, function errorCallback(response) {
      console.log(method + " GET urlToMenuItems[" + urlToMenuItems + "] returned " + JSON.stringify(response));
    });

    /**
     * menuItem_selected
     *
     * Sets the chosen menuitem from GUI. Retrieves any related metadata.
     */
    $scope.menuItem_selected = function (menuItem) {
      console.log("menuItem[" + JSON.stringify(menuItem) + "] selected.\n");
      $scope.selectedMenuItem = menuItem;
/*
      var projectNumber = "1";
      //var urlToRequirements = "http://localhost:9294/grouse/prosjekt/" +
      //  projectNumber + "/krav/" + menuItem.functionalityNumber;
      var urlToRequirements = "http://localhost:9294/grouse/prosjekt/1"
        + "/krav/" + menuItem.functionalityNumber;

      console.log("kravspec.js menuItem:. Attempting GET on " + urlToRequirements);

      $http({
        method: 'GET',
        url: urlToRequirements,
        headers: {'Authorization': $scope.token}
      }).then(function successCallback(response) {
        $scope.menuItems = response.data;
        console.log(method + " GET urlToMenuItems[" + urlToMenuItems + "] returned " + JSON.stringify(response));
      }, function errorCallback(response) {
        console.log(method + " GET urlToMenuItems[" + urlToMenuItems + "] returned " + JSON.stringify(response));
      });
*/
    };

    /**
     * menuItem_selected
     *
     * Sets the chosen menuitem from GUI. Retrieves any related metadata.
     */
    $scope.selectForDelete = function (menuItem) {
      console.log("menuItem[" + JSON.stringify(menuItem) + "] selected.\n");
      $scope.selectedMenuItem = menuItem;
      /*
            var projectNumber = "1";
            //var urlToRequirements = "http://localhost:9294/grouse/prosjekt/" +
            //  projectNumber + "/krav/" + menuItem.functionalityNumber;
            var urlToRequirements = "http://localhost:9294/grouse/prosjekt/1"
              + "/krav/" + menuItem.functionalityNumber;

            console.log("kravspec.js menuItem:. Attempting GET on " + urlToRequirements);

            $http({
              method: 'GET',
              url: urlToRequirements,
              headers: {'Authorization': $scope.token}
            }).then(function successCallback(response) {
              $scope.menuItems = response.data;
              console.log(method + " GET urlToMenuItems[" + urlToMenuItems + "] returned " + JSON.stringify(response));
            }, function errorCallback(response) {
              console.log(method + " GET urlToMenuItems[" + urlToMenuItems + "] returned " + JSON.stringify(response));
            });
      */
    };

  }]);
