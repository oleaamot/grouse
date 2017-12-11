let app = angular.module('grouse-app', []);

let grouseController = app.controller('RequirementController', ['$scope', '$http',

    function ($scope, $http) {
        console.log("RequirementController started");

        /* When page loads, grab the latest requirement from the database */
        var urlRequirement = baseUrlApp + "/" + REQUIREMENT + "/" + GetUserRequirementNumber();
        console.log("Attempting a GET on " + urlRequirement);
        $http({
            url: urlRequirement,
            method: "GET",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': GetUserToken()
            },
        }).then(function successCallback(response) {
            console.log("GET Call to [" + urlRequirement + "] returned= " + JSON.stringify(response.data));
            $scope.requirement = response.data;
        });

        $scope.updateRequirement = function () {
            console.log("grouseController update_requirement called");
            var requirementNumber = GetUserRequirementNumber();
            var urlRequirement = baseUrlApp + "/" + REQUIREMENT + "/" + requirementNumber;

            $http({
                url: urlRequirement,
                method: "PUT",
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': GetUserToken()
                },
                data: {
                    requirementText: $.trim(document.getElementById("requirement_text").value),
                    explanation: $.trim(document.getElementById("explanation").value),
                    consequence: $.trim(document.getElementById("consequence").value),
                },
            }).then(function successCallback(response) {
                console.log("PUT Call to [" + urlRequirement + "] returned= " + JSON.stringify(response.data));
                // Update the fonds object so fields in GUI are changed
                $scope.requirement = response.data;
            });
        };
    }]
);
