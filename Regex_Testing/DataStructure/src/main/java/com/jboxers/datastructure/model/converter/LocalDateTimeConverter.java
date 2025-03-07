package com.jboxers.datastructure.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {


    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime ==null ? null : Timestamp.valueOf(localDateTime);
    }
    //TODO: new Timestamp(10L) is just for testing
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp ==null ? null : timestamp.toLocalDateTime();
    }
}
