package tr.mdb.footballStats.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tr.mdb.footballStats.entity.Footballer;
import tr.mdb.footballStats.enums.Nationality;
import tr.mdb.footballStats.enums.Position;
import tr.mdb.footballStats.exceptions.IllegalFootTypeException;
import tr.mdb.footballStats.exceptions.IllegalNationalityException;
import tr.mdb.footballStats.exceptions.IllegalPositionException;
import tr.mdb.footballStats.repository.FootballerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FootballerService {
    private FootballerRepository foootballerRepository;

    public List<Footballer> getAllFootballers() {
        return foootballerRepository.findAll();
    }

    public List<Footballer> getAllFootballersByClub(String club) {
        return foootballerRepository.findFootballersByClub(club);
    }

    public List<Footballer> getAllFootballersByNationality(Nationality nationality) {
        return foootballerRepository.findFootballerByNationality(nationality);
    }

    public List<Footballer> getAllFootballerByClubAndPosition(String club, Position position) {
        return foootballerRepository.findFootballerByClubAndPosition(club, position);
    }

    public Footballer addStudent(Footballer footballer) {
        Footballer newFootballer = new Footballer();
        newFootballer.setAge(footballer.getAge());
        newFootballer.setFirstname(footballer.getFirstname());
        newFootballer.setLastname(footballer.getLastname());
        newFootballer.setClub(footballer.getClub());
        newFootballer.setJerseyNumber(footballer.getJerseyNumber());
        newFootballer.setWage(footballer.getWage());
        newFootballer.setMarketValue(footballer.getMarketValue());


        try {
            newFootballer.setPosition(footballer.getPosition());
        } catch (RuntimeException exception) {
            throw new IllegalPositionException("Please enter valid positions.");
        }

        try {
            newFootballer.setFoot(footballer.getFoot());
        } catch (RuntimeException exception) {
            throw new IllegalFootTypeException("Please enter valid foot type.");
        }

        try {
            newFootballer.setNationality(footballer.getNationality());
        } catch (RuntimeException exception) {
            throw new IllegalNationalityException("Please enter valid nationality.");
        }

        return foootballerRepository.save(newFootballer);
    }

    public void deleteFootballer(String id) {
        foootballerRepository.deleteById(id);
    }
}
