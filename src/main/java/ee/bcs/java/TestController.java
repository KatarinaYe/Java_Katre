package ee.bcs.java;


import ee.bcs.java.tasks.Lesson1;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    private List<Client> clients = new ArrayList<>();

    @GetMapping ("client")
    public List<Client> getClients(){
        // todo tagasta kogu clients list
        return clients;
    }

    @PostMapping("client")
    public void saveClient(@RequestBody Client client) {
        //todo lisa requestBodys olev klient listi
       clients.add(client);
        System.out.println(clients);
    }

    @GetMapping("client/{index}")
    public Client getClient(@PathVariable("index") Integer index){
        // todo tagasta klient indexil

        return clients.get(index);
    }

    @DeleteMapping("client/{index}")
    public void deleteClient(@PathVariable ("index") int index){
        //todo kustututa klient vastaval indexil
       clients.remove(index);
    }

    @PutMapping("client/{index}")
    public void updateClient(@PathVariable("index") int i, @RequestBody Client client){
        //todo värskeda nimekirja
        clients.set(i, client);
    }

    @GetMapping("client2")
    public Client getClient2(){
        Client client = new Client();
        client.setFirstName("Katre");
        client.setLastName("Kivaste");
        client.setAddress("Saku");
        return client;
    }

    @PostMapping("client2")
    public Client Client2(@RequestBody Client client){
        client.setFirstName(client.getFirstName() + "2");
        return client;

    }

    //http://localhost:8080/test


    //http://localhost:8080/lesson1/min/3/6
    @GetMapping("lesson1/min/{a}/{b}")
    public Integer min(@PathVariable("a") int x, @PathVariable("b") int y){
        return Lesson1.min(x, y);
    }

    //http://localhost:8080/lesson1/max?a=3&b=8
    @GetMapping("lesson1/max")
    public Integer max(@RequestParam("a") int x, @RequestParam("b") int y){
        return Lesson1.max(x, y);
    }

    //http://localhost:8080/lesson1/abs?a=3
    @GetMapping("lesson1/abs")
    public Integer abs( Integer a){
        return Lesson1.abs(a);
    }

    //http://localhost:8080/lesson1/isEven?a=3
    @GetMapping("lesson1/isEven")
    public boolean isEven(Integer a){
        return Lesson1.isEven(a);
    }

    //http://localhost:8080/lesson1/max3?a=3&b=8&c=9
    @GetMapping("lesson1/max3")
    public Integer max3(@RequestParam("a") int x, @RequestParam("b") int y, @RequestParam("c") int q ){
        return Lesson1.max3(x, y, q);
    }

    //http://localhost:8080/lesson1/min3?a=3&b=8&c=9
    @GetMapping("lesson1/min3")
    public Integer min3(@RequestParam("a") int x, @RequestParam("b") int y, @RequestParam("c") int q ){
        return Lesson1.min3(x, y, q);
    }


}
