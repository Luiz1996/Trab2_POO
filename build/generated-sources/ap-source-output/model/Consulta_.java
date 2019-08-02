package model;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Consulta.class)
public abstract class Consulta_ {

	public static volatile SingularAttribute<Consulta, String> cpfPac;
	public static volatile SingularAttribute<Consulta, Calendar> dtConsulta;
	public static volatile SingularAttribute<Consulta, Integer> tipoConsulta;
	public static volatile SingularAttribute<Consulta, String> cpfMed;
	public static volatile SingularAttribute<Consulta, Integer> id;

}

