$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SampleE2E.feature");
formatter.feature({
  "line": 1,
  "name": "Examples feature",
  "description": "",
  "id": "examples-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1213700,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "example scenario",
  "description": "",
  "id": "examples-feature;example-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@e2e"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "The user is on the Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "The user enters the credentials \"example.user@yopmail.com\" and \"123456\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "The user should see the Welcome Page",
  "keyword": "Then "
});
formatter.match({
  "location": "GeneralSteps.theUserIsOnTheHomePage()"
});
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "duration": 17607543300,
  "error_message": "java.lang.NullPointerException\r\n\tat java.util.Objects.requireNonNull(Objects.java:203)\r\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:106)\r\n\tat org.openqa.selenium.support.ui.FluentWait.\u003cinit\u003e(FluentWait.java:97)\r\n\tat org.aut.pages.BasePage.getWait(BasePage.java:67)\r\n\tat org.aut.pages.BasePage.isElementDisplayed(BasePage.java:52)\r\n\tat org.aut.pages.HomePage.isPageLoaded(HomePage.java:24)\r\n\tat org.aut.steps.definition.GeneralSteps.theUserIsOnTheHomePage(GeneralSteps.java:25)\r\n\tat ✽.Given The user is on the Home Page(SampleE2E.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "example.user@yopmail.com",
      "offset": 33
    },
    {
      "val": "123456",
      "offset": 64
    }
  ],
  "location": "HomeSteps.theUserEntersTheCredentialsAnd(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomeSteps.theUserShouldSeeTheWelcomePage()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "duration": 1210937200,
  "status": "passed"
});
});