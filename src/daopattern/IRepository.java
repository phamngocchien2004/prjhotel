package daopattern;

import model.ToCheckin;

import java.util.ArrayList;

public interface IRepository<C> {
    ArrayList<C> getAll();


    ArrayList<ToCheckin> getAll1();

    Boolean create(C c);

    Boolean update(C c);

    Boolean delete(C c);


}
