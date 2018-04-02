var app = angular.module('grouse-app', []);

/**
 * kravspec.js
 *
 * Used with kravspec.html to provide the following functionality:
 *
 *
 */
var requirementsController = app.controller('RequirementsController',
  ['$scope', '$http', '$window', function ($scope, $http, $window) {

    $scope.currentUser = JSON.parse("{\"username\":\"admin@kdrs.no\",\"password\":\"{bcrypt}$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC\",\"firstname\":\"John\",\"lastname\":\"Smith\",\"roles\":[{\"role\":\"ROLE_ADMIN\"},{\"role\":\"ROLE_USER\"}],\"links\":[{\"rel\":\"self\",\"href\":\"http://localhost:9294/grouse/bruker/admin@kdrs.no\",\"hreflang\":null,\"media\":null,\"title\":null,\"type\":null,\"deprecation\":null},{\"rel\":\"prosjekt\",\"href\":\"http://localhost:9294/grouse/bruker/admin@kdrs.no/prosjekt\",\"hreflang\":null,\"media\":null,\"title\":null,\"type\":null,\"deprecation\":null}]}");
    $scope.projectsView = true;
    $scope.requirementsView = false;

    $scope.priorityValues = ['O', '1', '2'];

    $scope.selectedProject = null;
    $scope.progressBarText = null;
    $scope.selectedMenuItem = null;
    $scope.documentHref = null;
    $scope.token = GetUserToken();

    $scope.progressBarValue = 0;

    console.log("Grouse kravspec.js page load. User token is set to " + $scope.token);
    console.log("Retrieving projects on page load. Current user is [" + $scope.currentUser + "] .\n");

    var token = GetUserToken();
    /*
      if (typeof variable === 'undefined' || variable === null) {
       alert("Mangler identifikasjons token for å fortsette." +
             "Kan ikke opprette et nytt prosjekt");
       return;
      }
    */
    for (var rel in $scope.currentUser.links) {
      var relation = $scope.currentUser.links[rel].rel;
      if (relation == REL_PROJECT) {
        var urlForProjects = $scope.currentUser.links[rel].href;
        console.log("Checking urlForProjects[" + urlForProjects);
        $http({
          method: 'GET',
          url: urlForProjects,
          headers: {'Authorization': token}
        }).then(function successCallback(response) {
          $scope.projects = response.data;
          console.log(" GET urlForProjects[" + urlForProjects +
            "] returned " + JSON.stringify(response));
        }, function errorCallback(response) {
          alert("Kunne ikke opprette nytt prosjekt. " +
            JSON.stringify(response));
          console.log(" GET urlForProjects[" + urlForProjects +
            "] returned " + JSON.stringify(response));
        });
      }
    }
    /**
     * menuItem_selected
     *
     * Sets the chosen menuitem from GUI. Retrieves any related metadata.
     */
    $scope.menuItem_selected = function (menuItem) {
      console.log("menuItem[" + JSON.stringify(menuItem) + "] selected.\n");
      $scope.selectedMenuItem = menuItem;

      /*
            var projectId = "1";
            //var urlToRequirements = "http://localhost:9294/grouse/prosjekt/" +
            //  projectId + "/krav/" + menuItem.functionalityNumber;
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

    };

    /**
     * updateRequirementText
     *
     * handles a change in requirement text.
     */
    $scope.updateRequirementText = function (requirement) {
      console.log("updateRequirementText [" + JSON.stringify(requirement) + "] selected.\n");
      $scope.selectedRequirement = requirement;

      var patchString = '[{ "op": "replace", "path": "/requirementText", "value": "' +
        requirement.requirementText + '"}]';

      console.log("updateRequirementText. Attempting PATCH[" + patchString + "].\n");

      for (var rel in $scope.selectedRequirement.links) {
        var relation = $scope.selectedRequirement.links[rel].rel;
        if (relation === REL_SELF) {
          var urlForRequirementChange = $scope.selectedRequirement.links[rel].href;
          console.log("Checking urlForRequirementTextChange [" + urlForRequirementChange);
          $http({
            method: 'PATCH',
            url: urlForRequirementChange,
            headers: {'Authorization': token},
            data: patchString
          }).then(function successCallback(response) {
            console.log("PATCH [" + urlForRequirementChange +
              "] returned " + JSON.stringify(response));
            $scope.selectedRequirement = response.data;
          }, function errorCallback(response) {
            alert("Kunne ikke endre krav for funksjon. " +
              JSON.stringify(response));
            console.log("PATCH urlForRequirementChange l[" + urlForRequirementChange +
              "] returned " + JSON.stringify(response));
          });
        }
      }

    };
    /**
     * updateRequirementPriority
     *
     * handles a change in requirement priority.
     */
    $scope.updateRequirementPriority = function (requirement) {
      console.log("updateRequirementPriority[" + JSON.stringify(requirement) + "] selected.\n");
      $scope.selectedRequirement = requirement;

      var patchString = '[{ "op": "replace", "path": "/priority", "value": "' +
        requirement.priority + '"}]';
      console.log("updateRequirementPriority. Attempting PATCH[" + patchString + "].\n");

      for (var rel in $scope.selectedRequirement.links) {
        var relation = $scope.selectedRequirement.links[rel].rel;
        if (relation === REL_SELF) {
          var urlForRequirementChange = $scope.selectedRequirement.links[rel].href;
          console.log("Checking urlForRequirementChange [" + urlForRequirementChange);
          $http({
            method: 'PATCH',
            url: urlForRequirementChange,
            headers: {'Authorization': token},
            data: patchString
          }).then(function successCallback(response) {
            console.log("PATCH [" + urlForRequirementChange +
              "] returned " + JSON.stringify(response));
            $scope.selectedRequirement = response.data;
          }, function errorCallback(response) {
            alert("Kunne ikke endre krav for funksjon. " +
              JSON.stringify(response));
            console.log("PATCH urlForRequirementChange l[" + urlForRequirementChange +
              "] returned " + JSON.stringify(response));
          });
        }
      }
    };

    $scope.addRequirement = function () {
      console.log("addRequirement selected.");
      var requirement = {
        requirementText: "hello",
        priority: "O"
      };
      $scope.menuItems[1].referenceProjectRequirement.push(requirement);
    };

    $scope.deleteRequirementAndRow = function (index) {
      console.log("deleteRequirementAndRow selected.");

      var requirement = $scope.menuItems[index].referenceProjectRequirement.requirementText;
      if ($window.confirm("Er du sikker du vil slette: " + requirement)) {
        $scope.menuItems[index].referenceProjectRequirement.splice(index, 1);
      }
    };

    /**
     * projectSelected
     *
     * The user has selected a project, change the view so that the functionality areas
     * are shown and the user can start choosing details related to the project.
     *
     */
    $scope.projectSelected = function (project) {
      console.log("projectSelected[" + JSON.stringify(project) + "] selected.\n");
      $scope.selectedProject = project;

      $scope.projectsView = false;
      $scope.requirementsView = true;

      var token = GetUserToken();
      /*
      if (typeof variable === 'undefined' || variable === null) {
       alert("Mangler identifikasjons token for å fortsette." +
             "Kan ikke opprette et nytt prosjekt");
       return;
      }
      */
      for (var rel in $scope.selectedProject.links) {
        var relation = $scope.selectedProject.links[rel].rel;
        if (relation == REL_FUNCTIONALITY) {
          var urlForFunctionalityRetrieval = $scope.selectedProject.links[rel].href;
          console.log("Checking urlForFunctionalityRetrieval[" + urlForFunctionalityRetrieval);
          $http({
            method: 'GET',
            url: urlForFunctionalityRetrieval,
            headers: {'Authorization': token}
          }).then(function successCallback(response) {
            console.log("GET [" + urlForFunctionalityRetrieval +
              "] returned " + JSON.stringify(response));
            $scope.menuItems = response.data;
            $scope.selectedMenuItem = null;
          }, function errorCallback(response) {
            alert("Kunne ikke hente funksjonalitetsbeskrivelse for prosjekt. " +
              JSON.stringify(response));
            console.log("GET urlForFunctionalityRetrieval[" + urlForFunctionalityRetrieval +
              "] returned " + JSON.stringify(response));
          });
        }
      }
    };

    /**
     * continueSelected
     *
     * When a user accepts a subset of defined requirements are acceptable
     * this method is called. The menuItem gets a success status and the progress
     * bar is updated.
     *
     */
    $scope.continueSelected = function () {
      console.log("continueSelected selected.\n");
      console.log("Attempting to find [" + $scope.selectedMenuItem.functionalityNumber + "]");
      $scope.selectedMenuItem.showMe = !$scope.selectedMenuItem.showMe;
      $scope.selectedMenuItem.processed = true;
      // Find out how far we have progressed through all requirements
      // set progress bare accordingly.

      var countTrue = 0;
      var countFalse = 0;

      for (var rel in $scope.menuItems) {
        $scope.menuItems[rel].processed === true ? countTrue++ : countFalse++;
      }

      console.log("Number that is true is [" + countTrue + "]");
      console.log("Number that is false is [" + countFalse + "]");
      console.log("Number that is total is [" + rel + "]");
      var percentage = (countTrue / ++rel) * 100;
      console.log("Percentage is [" + percentage + "]");
      $scope.progressBarValue = percentage;
      console.log("Number that is total is [" + rel + "]");
      // The GUI thinks the document is ready to be created
      if (countTrue === rel) {
        console.log("countTrue === rel CHECKING $scope.selectedProject.documentCreated " + $scope.selectedProject.documentCreated);
        // We do this check to avoid regenerating the document every time someone reloads the project
        // But if they go back and change something, we need to set documentCreated to false
        //if ($scope.selectedProject.documentCreated === false) {
        {for (var rel in $scope.selectedProject.links) {
            console.log("checking $scope.selectedProject.links[rel].rel [" + $scope.selectedProject.links[rel].rel + "]");

            var relation = $scope.selectedProject.links[rel].rel;
            console.log("relation [" + relation + "]");
            console.log("REL_DOCUMENT" + REL_DOCUMENT+"]");
            if (relation == REL_DOCUMENT) {
              var urlForDocumentCreation = $scope.selectedProject.links[rel].href;
              console.log("Checking urlForDocumentCreation[" + urlForDocumentCreation);
              $http({
                method: 'POST',
                url: urlForDocumentCreation,
                headers: {'Authorization': token}
              }).then(function successCallback(response) {
                console.log("POST urlForDocumentCreation [" + urlForDocumentCreation +
                  "] returned " + JSON.stringify(response));

                // If 201 CREATED, set a download link in progress bar
                $scope.progressBarText = "Last ned dokument";
                $scope.documentHref = urlForDocumentCreation;
              }, function errorCallback(response) {
                alert("Kunne ikke opprette Dokument. " +
                  JSON.stringify(response));
                console.log("POST urlForDocumentCreation [" + urlForDocumentCreation +
                  "] returned " + JSON.stringify(response));
              });
            }
          }
        }
      }
    };


    /**
     * createProject
     *
     * creates a new project associated with the current user.
     *
     * Takes information about the current user from the scope and
     * traverses the RELs looking for a REL_PROJECT (prosjekt). Once
     * it finds this it uses the associated HREF as the address of
     * where to POST the project object.
     *
     *
     */
    $scope.createProject = function () {
      console.log("createProject. Current user is [" + $scope.currentUser + "] .\n");

      var token = GetUserToken();
      /*
            if (typeof variable === 'undefined' || variable === null) {
             alert("Mangler identifikasjons token for å fortsette." +
                   "Kan ikke opprette et nytt prosjekt");
             return;
            }
      */
      for (var rel in $scope.currentUser.links) {
        var relation = $scope.currentUser.links[rel].rel;
        if (relation == REL_PROJECT) {
          var urlForProjectCreation = $scope.currentUser.links[rel].href;
          console.log("Checking urlForProjectCreation[" + urlForProjectCreation);
          $http({
            method: 'POST',
            url: urlForProjectCreation,
            headers: {'Authorization': token},
            data: {
              projectName: $scope.projectName,
              organisationName: $scope.organisationName
            }
          }).then(function successCallback(response) {
            console.log("POST urlForProjectCreation[" + urlForProjectCreation +
              "] returned " + JSON.stringify(response));
          }, function errorCallback(response) {
            alert("Kunne ikke opprette nytt prosjekt. " +
              JSON.stringify(response));
            console.log("POST urlForProjectCreation[" + urlForProjectCreation +
              "] returned " + JSON.stringify(response));
          });
        }
      }
    };
  }]);
