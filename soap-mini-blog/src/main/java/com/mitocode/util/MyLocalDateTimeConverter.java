package com.mitocode.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/*
 * Clase utilitaria (está ampliamente divulgada en internet). Util para fechas con Java 8 con LocalDateTime. Sí se trabajara con java.util.Date esto no sería necesario
 * 
 * Debido a que existen modelos que manejan fechas y que vamos a trabajar con servicios, en el modelo anterior con JSF no era necesario
 * porque estabamos trabajando con código Java, pero ahora la data ingresará por XML(para SOAP) o por JSON(para REST). Entonces, esto 
 * necesita ser analizado por Java para que pueda devolver una instancia del objeto LocalDateTime
 */
@Converter(autoApply = true)
public class MyLocalDateTimeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		return attribute == null ? null : Timestamp.valueOf(attribute);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		return dbData == null ? null : dbData.toLocalDateTime();
	}

}
