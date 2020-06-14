package steps;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class BDDStyledMethod {

    public static void SimpleGETPost(String postNumber){
        given().contentType(ContentType.JSON);
        when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().body("author",is("Karthik KK"));
    }

    public static void ContainsCollection(){
        given().
                contentType(ContentType.JSON);
        when().
                get("http://localhost:3000/posts/").
                then().body("author",containsInAnyOrder("Karthik KK",null,"Mono")).statusCode(200);
    }

     public static void PerformPathParameter(){
        given()
                .contentType(ContentType.JSON).
        with()
                .pathParams("post", 1).
        when()
                .get("http://localhost:3000/posts/{post}").

        then()
                .body("author", containsString("Karthik KK"));
     }
    public static void PerformQueryParameter(){
        given()
                .contentType(ContentType.JSON).
                queryParam("id",1).
                when()
                .get("http://localhost:3000/posts/").

                then()
                .body("author", hasItem("Karthik KK"));
    }

    public static void PerformPostWithBodyParamether(){
        HashMap<String,String> postContect = new HashMap<String, String>();
        postContect.put("id","5");
        postContect.put("title","Robotica");
        postContect.put("author","Juanjo");


        given()
                .contentType(ContentType.JSON).
        with()
                .body(postContect).
        when()
                .post("http://localhost:3000/posts").

        then()
                .body("author", Is.is("Juanjo"));

    }


}
