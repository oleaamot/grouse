let app = angular.module('grouse-app', []);

let grouseController = app.controller('FunctionalityController', ['$scope', '$http',

    function ($scope, $http) {
        console.log("FunctionalityController started");


        /* When page loads, grab the latest functionality from the database */
        var urlFunctionality = baseUrlApp + "/" + FUNCTIONALITY;
        console.log("Attempting a GET on " + urlFunctionality);
        $http({
            url: urlFunctionality,
            method: "GET",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': GetUserToken()
            },
        }).then(function successCallback(response) {
            console.log("GET Call to [" + urlFunctionality + "] returned= " + JSON.stringify(response.data));
            $scope.functionality = response.data;
        }, function errorCallback(response) {
            console.log("ERROR on GET Call to [" + urlFunctionality + "] returned= " + JSON.stringify(response));
        });

        $scope.updateFunctionality = function (functionality) {
            console.log("grouseController update_functionality called");
            var urlFunctionality = baseUrlApp + "/" + FUNCTIONALITY + "/" + functionality.functionalityNumber;

            console.log("Functionality is " + functionality);
            var functionalityDescription = "functionality_description_" + functionality.id;
            var functionalityExplanation = "functionality_consequence_" + functionality.id;
            var functionalityConsequence = "functionality_explanation_" + functionality.id;

            console.log("Values are " + functionalityDescription + " " + functionalityExplanation);
            $http({
                url: urlFunctionality,
                method: "PUT",
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': GetUserToken()
                },
                data: {
                    description: $.trim(document.getElementById(functionalityDescription).value),
                    explanation: $.trim(document.getElementById(functionalityExplanation).value),
                    consequence: $.trim(document.getElementById(functionalityConsequence).value),
                },
            }).then(function successCallback(response) {
                console.log("PUT Call to [" + urlFunctionality + "] returned= " + JSON.stringify(response.data));
            });
        };
    }]
);
