package Factory;

import daopattern.BillIRepository;
import daopattern.IRespository;
import daopattern.OrderRepository;
import daopattern.RoomIRepository;
import enums.RepType;

public class RespositoryFactory {
    public static IRespository createRepositoryInstance(RepType type) {
        if (type == RepType.ROOM)
            return RoomIRepository.getInstance();
        else if (type == RepType.Order) {
            return OrderRepository.getInstance();
      }else if (type == RepType.Bill) {
            return BillIRepository.getInstance();
          }
            return null;
        }
    }
