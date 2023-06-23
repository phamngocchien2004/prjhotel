package daopattern;

import model.Check;

import java.util.ArrayList;

public interface IRepository<C> {
    ArrayList<C> getAll();

    Boolean create(C c);

    Boolean update(C c);

    Boolean delete(C c);

    Check find(String id);

    Check find(Integer id);
}
