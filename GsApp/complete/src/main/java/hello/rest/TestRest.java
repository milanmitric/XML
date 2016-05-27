package hello.rest;

import hello.entity.TAkt;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by aloha on 24-May-16.
 */
@RestController
@RequestMapping("/api")
public class TestRest {


    @RequestMapping("/test1")
    public HttpStatus test() {
        return HttpStatus.OK;
    }


    @RequestMapping("/test2")
    public String test2() {
        //that link generates random JSON
        RestTemplate restTemplate = new RestTemplate();
        String s=restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
        return s;
    }


    @RequestMapping("/test3")
    public HttpStatus test3(@RequestBody String s) {

        //http://www.mkyong.com/java/jaxb-hello-world-example/

        JSONObject obj = null;
        try {
             obj=new JSONObject(s);
            System.out.println(obj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TAkt akt=new TAkt();
        try {
            akt.setNaslov(obj.getString("naslov"));
            //gde validacija ?!
            //moze da se marshal pa da se naprvi XML doc
            //pa to saljemo mark bazi?
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("NASLOV IZ OBJ AKT: "+akt.getNaslov());
        return HttpStatus.OK;
    }


    @RequestMapping("/test4")
    public HttpStatus test4(@RequestBody TAkt t) {
        //nece - 405
        System.out.println(t.getNaslov());
        return HttpStatus.OK;
    }





}