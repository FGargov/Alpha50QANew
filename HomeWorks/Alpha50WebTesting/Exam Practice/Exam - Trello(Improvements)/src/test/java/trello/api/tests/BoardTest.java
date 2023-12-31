package trello.api.tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Endpoints.BOARDS_ENDPOINT;
import static com.telerikacademy.api.tests.Endpoints.BOARD_ENDPOINT;
import static io.restassured.RestAssured.basePath;
import static java.lang.String.format;
import static java.util.Objects.isNull;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class BoardTest extends BaseTestSetup {

    @Test
    public void createBoardTest() {
        basePath = BOARDS_ENDPOINT;

        String boardNameUnique = format("%s %s", BOARD_NAME, timestamp);

        Response response = getApplicationAuthentication()
                .queryParam("name", boardNameUnique)
                .when()
                .post();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, format("Incorrect status code. Expected %s.", SC_OK));
        assertEquals(response.getBody().jsonPath().getString("name"), boardNameUnique, "Board names don't match.");

        boardId = response.getBody().jsonPath().getString("id");

        System.out.printf("Board with name '%s' and id '%s' was successfully created.%n", boardNameUnique, boardId);
    }

    @Test
    public void getBoardListsTest() {

        if (isNull(boardId)) {
            createBoardTest();
        }

        basePath = BOARD_ENDPOINT;

        Response response = getApplicationAuthentication()
                .pathParam("id", boardId)
                .queryParam("lists", "all")
                .when()
                .get();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, format("Incorrect status code. Expected %s.", SC_OK));

        ArrayList<HashMap<String, String>> lists = response.getBody().jsonPath().get("lists");
        for (HashMap<String, String> list : lists) {
            if (list.get("name").equals("To Do")) {
                toDoListId = list.get("id");
                break;
            }
        }

        System.out.printf("List 'To Do' id is: %s.%n", toDoListId);
    }
/*    @Test
    public void correctDataReturned_when_createBoardTest() {
        baseURI = format("%s%s", BASE_URL, BOARDS_ENDPOINT);

        String requestBody = format(BOARD, BOARD_NAME, BOARD_DESCRIPTION, ORGANIZATION_ID, KEY, TOKEN);
        Assert.assertTrue(isValid(requestBody), "Body is not a valid JSON");

        Response response = getApplicationJSONSpecification()
                .body(requestBody)
                .post();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200");
        System.out.printf("Board with key %s was created%n%n", BOARD_ID);


        Assert.assertTrue(response.getContentType().contains("application/json"), "Content type is not JSON");
        Assert.assertEquals(response.jsonPath().getString("name"), "First Board - exam", "Board name is not correct");
        Assert.assertFalse(response.jsonPath().getString("id").isEmpty(), "Board ID is empty in the response");
        Assert.assertTrue(response.getTime() <= 2000, "Response time is greater than 2000ms");
    }*/
}
