package com.example.MonitoringLocation.controller;


import com.example.MonitoringLocation.model.Person;
import com.example.MonitoringLocation.payload.response.ResponseObject;
import com.example.MonitoringLocation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("monitoring-location/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{user_id}")
    public ResponseEntity<ResponseObject> getAll(@PathVariable Long user_id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query person by user_id is successfully", personService.getAllByUser(user_id))
        );
    }

    /* person
        {
            "user": {
                         "id": "1"
                     },
            "name": "Khai",
            "avatar": "dwthhhrtdwdw"
        }
         */
    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertPerson(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query person by user_id is successfully", personService.insert(person))
        );
    }


    @PostMapping("/check_person")
    public ResponseEntity<ResponseObject> checkPerson(@RequestBody String token) {

        String t = token.replace("\"", "");
        System.out.println(token);
        Person personFound = personService.checkPersonByToken(t);
        if (personFound == null) {
            return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).body(
                    new ResponseObject("NOT_FOUND", "Token does not exist ", null)
            );
        }
        System.out.println("tim thay person" + personFound.getId());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Token is correct", personFound.getId())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deletePerson(@PathVariable Long id) {
        int deleteResult = personService.deletePerson(id);

        return switch (deleteResult) {
            case 0 -> ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Deleted is successfully ", null)
            );
            case 1 -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("FAILED", "Person is not exist! ", null)
            );
            case 2 -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("FAILED", "Table is not exist! ", null)
            );
            default -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("FAILED", "Co 1 loi gi do! ", null)
            );
        };

    }

}
