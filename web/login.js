var app = angular.module('grouse-app', []);

/**
 * login.js
 *
 * Used with index.html to provide the following functionality:
 *
 *
 */
var loginController = app.controller('LoginController',
  ['$scope', '$http', function ($scope, $http) {

    $scope.showCreateAccount = false;


    $scope.createAccountSelected = function () {
      $scope.showCreateAccount = true;
    };

    $scope.createAccount = function () {
      $scope.showCreateAccount = false;
    };

    $scope.login = function () {

    }

  }]);
