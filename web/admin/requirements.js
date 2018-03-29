let app = angular.module('grouse-app', []);

let grouseController = app.controller('RequirementsController', ['$scope', '$http',

    function ($scope, $http) {
        console.log("grouseController started");

        /* When page loads, grab the latest requirements from the database */
        var urlRequirement = baseUrlApp + "/" + REQUIREMENT + "/";

        $http({
            url: urlRequirement,
            method: "GET",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': GetUserToken()
            },
        }).then(function successCallback(response) {
            console.log("GET Call to [" + urlRequirement + "] returned= " + JSON.stringify(response.data));
            $scope.requirements = response.data;
        });

        $scope.selectRequirement = function (requirement) {
            SetUserRequirementNumber(requirement.requirementNumber);
            changeLocation($scope, requirementPageName, true);
        };

    }]
);
