$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("E:/Study/CucumberWS/freeCRM/Features/login.feature");
formatter.feature({
  "line": 1,
  "name": "Login to Free CRM website",
  "description": "",
  "id": "login-to-free-crm-website",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Verify successful Login in Free CRM website.",
  "description": "",
  "id": "login-to-free-crm-website;verify-successful-login-in-free-crm-website.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on Free CRM Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter username as \"\u003cusername\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enter password as \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user click on login button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User should be able to log into Free CRM website successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User closes the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "login-to-free-crm-website;verify-successful-login-in-free-crm-website.;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 15,
      "id": "login-to-free-crm-website;verify-successful-login-in-free-crm-website.;;1"
    },
    {
      "cells": [
        "mayurc",
        "test@123"
      ],
      "line": 16,
      "id": "login-to-free-crm-website;verify-successful-login-in-free-crm-website.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 16,
  "name": "Verify successful Login in Free CRM website.",
  "description": "",
  "id": "login-to-free-crm-website;verify-successful-login-in-free-crm-website.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "User is on Free CRM Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter username as \"mayurc\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enter password as \"test@123\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user click on login button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User should be able to log into Free CRM website successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User closes the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "login.user_is_on_Free_CRM_Login_Page()"
});
formatter.result({
  "duration": 43849086048,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mayurc",
      "offset": 24
    }
  ],
  "location": "login.user_enter_username_as(String)"
});
formatter.result({
  "duration": 293283356,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test@123",
      "offset": 24
    }
  ],
  "location": "login.user_enter_password_as(String)"
});
formatter.result({
  "duration": 146999744,
  "status": "passed"
});
formatter.match({
  "location": "login.user_click_on_login_button()"
});
formatter.result({
  "duration": 18189808007,
  "status": "passed"
});
formatter.match({
  "location": "login.user_should_be_able_to_log_into_Free_CRM_website_successfully()"
});
formatter.result({
  "duration": 21853425,
  "status": "passed"
});
formatter.match({
  "location": "login.user_closes_the_browser()"
});
formatter.result({
  "duration": 36929254,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 17,
      "value": "#|\tcrmadmin1\t|\ttest@123\t|"
    },
    {
      "line": 18,
      "value": "#|\tcrmuser1\t|\ttest@123\t|"
    }
  ],
  "line": 23,
  "name": "Verify user is not able to login with invalid credentials",
  "description": "",
  "id": "login-to-free-crm-website;verify-user-is-not-able-to-login-with-invalid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "User is on Free CRM Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "user enter username as \"mayurc\"",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "user enter password as \"invalidpass\"",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "user click on login button",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "User should not be able to log into Free CRM website",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "User closes the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "login.user_is_on_Free_CRM_Login_Page()"
});
formatter.result({
  "duration": 21366414329,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mayurc",
      "offset": 24
    }
  ],
  "location": "login.user_enter_username_as(String)"
});
formatter.result({
  "duration": 145866248,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "invalidpass",
      "offset": 24
    }
  ],
  "location": "login.user_enter_password_as(String)"
});
formatter.result({
  "duration": 124667378,
  "status": "passed"
});
formatter.match({
  "location": "login.user_click_on_login_button()"
});
formatter.result({
  "duration": 4592709709,
  "status": "passed"
});
formatter.match({
  "location": "login.user_should_not_be_able_to_log_into_Free_CRM_website()"
});
formatter.result({
  "duration": 67001090,
  "status": "passed"
});
formatter.match({
  "location": "login.user_closes_the_browser()"
});
formatter.result({
  "duration": 46900363,
  "status": "passed"
});
});