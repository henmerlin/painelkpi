package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-29T11:09:10.817-0200")
@StaticMetamodel(Resultado.class)
public class Resultado_ {
	public static volatile SingularAttribute<Resultado, Integer> id;
	public static volatile SingularAttribute<Resultado, Kpi> kpi;
	public static volatile SingularAttribute<Resultado, Periodo> periodo;
	public static volatile SingularAttribute<Resultado, Double> valor;
	public static volatile SingularAttribute<Resultado, Integer> volume;
}
