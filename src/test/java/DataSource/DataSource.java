package DataSource;

import com.google.gson.Gson;
import io.restassured.response.Response;
import pojo.PostEndavan;

public class DataSource{

    public PostEndavan setPostEndavan(){

        PostEndavan postEndavan = new PostEndavan();
        postEndavan.setTitle("Presentacion DEMO ");
        postEndavan.setAuthor("Luis Correa");
        postEndavan.setCompany("Endava");
        postEndavan.setCity("Risaralda");
        postEndavan.setFavoriteFood("Cerveza");

        return postEndavan;
    }

    public PostEndavan getPostEndavan(Response response){

        String json = response.getBody().asString();

        PostEndavan postEndavan = new Gson().fromJson(json, PostEndavan.class);

        return postEndavan;

    }

    public PostEndavan setPUTEndavan(){

        PostEndavan postEndavan = new PostEndavan();
        postEndavan.setTitle("Presentacion DEMO ");
        postEndavan.setAuthor("Luis Corrales");
        postEndavan.setCompany("Endava");
        postEndavan.setCity("Pereira");
        postEndavan.setFavoriteFood("Cerveza");

        return postEndavan;
    }





}
