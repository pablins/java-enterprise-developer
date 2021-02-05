package com.mitocode.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//Se define como DTO debido a que es una clase de apoyo para representar información
@Named//usada para inyección de dependencia. Con esto la podemos usar en la vista con EL
//ESTABLECEMOS EL AMBITO
//@RequestScoped//No lo usamos debido a que en cada petición se crearía un objeto
//@SessionScoped//No lo usamos debido a que existiría un objeto por cada usuario en el sistema
@ApplicationScoped//Es el mejor alcance debido a que es poco probable que cambien los paises y sólo se instanciara un objeto de este para toda la aplicación. Estará disponible para todos los usuarios una vez cargue la aplicación
public class PaisDTO implements Serializable {
	
	private List<String> paises;
	
	public PaisDTO() {
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
		
		this.paises = new ArrayList<>(Arrays.asList(arregloPaises));
	}

	//Solamente establecemos el método get debido a que es el unico que usaremos, no se establece el set dado que no se cambiarán los paises sino que se usarán los definidos en el constructor
	public List<String> getPaises() {
		return paises;
	}
	
}
