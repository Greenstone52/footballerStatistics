package tr.mdb.footballStats.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import tr.mdb.footballStats.enums.Nationality;
import tr.mdb.footballStats.enums.Position;
import tr.mdb.footballStats.enums.PreferredFoot;

@Document("footballer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Footballer {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private int age;
    private PreferredFoot foot;

    //@Field(targetType = FieldType.STRING)
    private Nationality nationality;

    private String club;
    private int jerseyNumber;

    @Field(targetType = FieldType.STRING)
    private Position position;

    private long marketValue;
    private long wage;
}
