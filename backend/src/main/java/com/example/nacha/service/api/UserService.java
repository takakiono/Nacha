package com.example.nacha.service.api;

import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.nacha.common.constants.ErrorMessage;
import com.example.nacha.common.exception.NachaBusinessException;
import com.example.nacha.common.utils.DatetimeUtils;
import com.example.nacha.common.utils.ExclusiveUtils;
import com.example.nacha.repository.UserRepository;
import com.example.nacha.repository.entity.UserEntity;
import com.example.nacha.service.bean.GetUserApiRequestBean;
import com.example.nacha.service.bean.GetUserApiResponseBean;
import com.example.nacha.service.bean.RegistUserApiRequestBean;
import com.example.nacha.service.bean.RegistUserApiResponseBean;
import com.example.nacha.service.bean.UpdateUserApiRequestBean;
import com.example.nacha.service.bean.UpdateUserApiResponseBean;
import com.example.nacha.service.bean.common.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザ情報の取得
     *
     * @param userId ユーザID
     * @return ユーザ情報
     */
    public GetUserApiResponseBean get(String userId){
        UserEntity entity = userRepository.getUser(Long.valueOf(userId));
        return GetUserApiResponseBean.builder()
                .user(User.builder()
                    .userId(String.valueOf(entity.getUserId()))
                    .userName(entity.getUserName())
                    .build())
                .updatetime(DatetimeUtils.format(entity.getUpdateDatetime()))
                .build();
    }

    /**
     * ユーザ情報の登録
     * 
     * @param users
     * @return
     */
    public RegistUserApiResponseBean regist(RegistUserApiRequestBean request){
        UserEntity user = UserEntity.builder()
            .userName(request.getUserName())
            .build();
        userRepository.registUser(user);

        UserEntity entity = userRepository.getUser(user.getUserId());
        return RegistUserApiResponseBean.builder()
            .user(User.builder()
                .userId(String.valueOf(entity.getUserId()))
                .userName(entity.getUserName())
                .build())
            .build();
    }

    /**
     * ユーザ情報の更新
     * 
     * @param users
     * @return
     */
    public UpdateUserApiResponseBean update(String userId, UpdateUserApiRequestBean request){
        // 楽観排他チェック
        ExclusiveUtils.checkExclusive(request.getUpdatetime(), userRepository.getUser(Long.valueOf(userId)).getUpdateDatetime());
        
        UserEntity user = UserEntity.builder()
            .userId(Long.valueOf(userId))
            .userName(request.getUserName())
            .updateDatetime(LocalDateTime.now())
            .build();
        userRepository.updateUser(user);

        UserEntity response = userRepository.getUser(user.getUserId());
        return UpdateUserApiResponseBean.builder()
            .user(User.builder()
                .userId(String.valueOf(response.getUserId()))
                .userName(response.getUserName())
                .build())
            .build();
    }

    /**
     * ユーザ情報の削除
     * 
     * @param userId　ユーザID
     * @throws Exception　例外
     */
    public void delete(String userId) throws Exception{

        // 削除対象のユーザの検索
        UserEntity entity = userRepository.getUser(Long.valueOf(userId));
        if (Objects.isNull(entity) || ObjectUtils.isEmpty(entity)){
            throw new NachaBusinessException(ErrorMessage.NachaNotTargetError);
        }

        int result = userRepository.deleteUser(Long.valueOf(userId));
        if(result == 0){
            throw new NachaBusinessException(ErrorMessage.NachaDeleteError);
        }
    }
}