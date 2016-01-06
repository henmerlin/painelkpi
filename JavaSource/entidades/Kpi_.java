package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T15:22:23.183-0200")
@StaticMetamodel(Kpi.class)
public class Kpi_ {
	public static volatile SingularAttribute<Kpi, Integer> id;
	public static volatile SingularAttribute<Kpi, String> nome;
	public static volatile SingularAttribute<Kpi, Area> area;
	public static volatile ListAttribute<Kpi, Resultado> resultados;
}
