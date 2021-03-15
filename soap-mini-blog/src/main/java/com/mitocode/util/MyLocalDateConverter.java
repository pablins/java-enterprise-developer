package com.mitocode.util;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/*
 * Clase utilitaria (est� ampliamente divulgada en internet). Util para fechas con Java 8 con LocalDate. S� se trabajara con java.util.Date esto no ser�a necesario
 * 
 * Debido a que existen modelos que manejan fechas y que vamos a trabajar con servicios, en el modelo anterior con JSF no era necesario
 * porque estabamos trabajando con c�digo Java, pero ahora la data ingresar� por XML(para SOAP) o por JSON(para REST). Entonces, esto 
 * necesita ser analizado por Java para que pueda devolver una instancia del objeto LocalDate
 */
@Converter(autoApply = true)
public class MyLocalDateConverter implements AttributeConverter<java.time.LocalDate, java.sql.Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return attribute == null ? null : Date.valueOf(attribute);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		return dbData == null ? null : dbData.toLocalDate();
	}

}
