package Factory;

import daopattern.CheckRepository;
import daopattern.IRepository;
import enums.RepositoryType;

public class RepositoryFactoryCheckOut {
    public static IRepository createRepositoryInstance(RepositoryType type) {
        if (type == RepositoryType.Check) {
            return CheckRepository.getInstance();
    }  return null;
}
}
