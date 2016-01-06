package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T12:26:28.495-0200")
@StaticMetamodel(Area.class)
public class Area_ {
	public static volatile SingularAttribute<Area, Integer> id;
	public static volatile SingularAttribute<Area, String> nome;
	public static volatile SingularAttribute<Area, Frente> frente;
	public static volatile ListAttribute<Area, Kpi> kpis;
}
