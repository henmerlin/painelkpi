package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T15:21:44.450-0200")
@StaticMetamodel(Resultado.class)
public class Resultado_ {
	public static volatile SingularAttribute<Resultado, Integer> id;
	public static volatile SingularAttribute<Resultado, Kpi> kpi;
	public static volatile SingularAttribute<Resultado, Date> periodo;
}
