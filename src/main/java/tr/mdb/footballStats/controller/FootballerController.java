package tr.mdb.footballStats.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.mdb.footballStats.entity.Footballer;
import tr.mdb.footballStats.enums.Nationality;
import tr.mdb.footballStats.enums.Position;
import tr.mdb.footballStats.exceptions.IllegalFootTypeException;
import tr.mdb.footballStats.exceptions.IllegalNationalityException;
import tr.mdb.footballStats.exceptions.IllegalPositionException;
import tr.mdb.footballStats.service.FootballerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/footballers")
@AllArgsConstructor
public class FootballerController {

    private FootballerService footballerService;

    @GetMapping
    public List<Footballer> getAllFootballers(){
        return footballerService.getAllFootballers();
    }

    @GetMapping("/clubs/{club}")
        public List<Footballer> getAllFootballersByClub(@PathVariable String club){
        return footballerService.getAllFootballersByClub(club);
    }

    @GetMapping("/nationalities/{nationality}")
    public List<Footballer> getAllFootballersByNationality(@PathVariable Nationality nationality){
        return footballerService.getAllFootballersByNationality(nationality);
    }

    @GetMapping("/clubs/{club}/positions/{position}")
    public List<Footballer> getAllFootballersByClubAndPosition(@PathVariable String club,@PathVariable Position position){
        return footballerService.getAllFootballerByClubAndPosition(club,position);
    }

    @PostMapping
    public Footballer postFootballers(@RequestBody Footballer student){
        return footballerService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteFootballer(@PathVariable String id){
        footballerService.deleteFootballer(id);
    }

    @ExceptionHandler(IllegalNationalityException.class)
    public ResponseEntity<String> handleIllegalNationalityException(IllegalNationalityException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(IllegalFootTypeException.class)
    public ResponseEntity<String> handleIllegalFootTypeException(IllegalFootTypeException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(IllegalPositionException.class)
    public ResponseEntity<String> handleIllegalPositionException(IllegalPositionException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
}
