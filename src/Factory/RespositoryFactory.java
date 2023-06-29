package Factory;

import daopattern.*;
import enums.RepType;

public class RespositoryFactory {
    public static IRespository createRepositoryInstance(RepType type) {
        if (type == RepType.ROOM)
            return RoomIRepository.getInstance();
      else if (type == RepType.Bill) {
            return BillIRepository.getInstance();
          } else if (type == RepType.Checkin){
          return CheckinReposity.getInstance();
        } else if (type == RepType.ToCheckin) {
            return ToCheckinRepository.getInstance();
        } else if (type == RepType.ToCheckout) {
            return ToCheckoutRepository.getInstance();
        }


        return null;
        }
    }
