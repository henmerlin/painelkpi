package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T11:16:29.625-0200")
@StaticMetamodel(Frente.class)
public class Frente_ {
	public static volatile SingularAttribute<Frente, Integer> id;
	public static volatile SingularAttribute<Frente, String> nome;
	public static volatile ListAttribute<Frente, Area> areas;
}
