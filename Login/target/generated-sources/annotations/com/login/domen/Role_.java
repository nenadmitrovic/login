package com.login.domen;

import com.login.domen.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-12T00:30:05")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Integer> roleId;
    public static volatile CollectionAttribute<Role, User> userCollection;
    public static volatile SingularAttribute<Role, String> name;

}