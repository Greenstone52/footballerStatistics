package tr.mdb.footballStats.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.mdb.footballStats.entity.Footballer;
import tr.mdb.footballStats.enums.Nationality;
import tr.mdb.footballStats.enums.Position;

import java.util.List;

public interface FootballerRepository extends MongoRepository<Footballer,String> {
    List<Footballer> findFootballersByClub(String club);
    List<Footballer> findFootballerByClubAndPosition(String club, Position position);
    List<Footballer> findFootballerByNationality(Nationality nationality);
}
