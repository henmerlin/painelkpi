package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-08T09:55:41.141-0200")
@StaticMetamodel(Periodo.class)
public class Periodo_ {
	public static volatile SingularAttribute<Periodo, Integer> id;
	public static volatile SingularAttribute<Periodo, String> nome;
	public static volatile ListAttribute<Periodo, Resultado> resultado;
	public static volatile SingularAttribute<Periodo, Date> data;
}
