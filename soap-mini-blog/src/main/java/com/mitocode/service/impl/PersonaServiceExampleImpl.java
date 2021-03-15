package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.mitocode.service.IPersonaServiceExample;

@WebService//marcamos la clase para ser usada como web service. Le indica al servidor que se está creando un servicio web y debe publicarlo en una dirección
//El estilo por defecto es document. Además podrían cambiar algunas cositas de estructura pero en cuanto a uso es lo mismo
//@SOAPBinding(style = Style.RPC)//Es como lo antiguito, con este estilo no soportaría el trabajo con objeto sino que solo acepta los tipos primitivos y listas. Se usa para compatibilidad con servicios que no tengan soporte a POO
public class PersonaServiceExampleImpl implements IPersonaServiceExample, Serializable {

	@WebMethod//Le indica que es una operación del servicio
	@Override
	public String saludar() {
		return "Hola Coders!!!";
	}

	@WebMethod(operationName="saludar2")//establecemos un nombre dado que por defecto JAX-WS nos colocará el nombre del método y no pueden existir 2 operaciones con el mismo nombre
	@Override
	public String saludar(String nombre) {
		return "Hola " + nombre;
	}

	@WebMethod
	@Override
	public List<String> listar() {
		String[] arregloPaises = { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina",
				"Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados",
				"Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana",
				"Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde",
				"Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo",
				"Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark",
				"Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador",
				"Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia",
				"Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
				"Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}",
				"Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati",
				"Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho",
				"Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi",
				"Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "México",
				"Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar {Burma}",
				"Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway",
				"Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Perú", "Philippines", "Poland",
				"Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia",
				"Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia",
				"Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia",
				"Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname",
				"Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo",
				"Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine",
				"United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu",
				"Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" };
		
		return new ArrayList<>(Arrays.asList(arregloPaises));
	}

}
