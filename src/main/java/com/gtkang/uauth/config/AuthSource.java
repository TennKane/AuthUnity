package com.gtkang.uauth.config;

import com.gtkang.uauth.enums.AuthResponseStatus;
import com.gtkang.uauth.exception.AuthException;
import lombok.Getter;

/**
 * API地址的统一接口
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
public interface AuthSource {
    /**
     * 授权的api
     *
     * @return url
     */
    String authorize();

    /**
     * 获取accessToken的api
     *
     * @return url
     */
    String accessToken();

    /**
     * 取消授权的api
     *
     * @return url
     */
    default String revoke() {
        throw new AuthException(AuthResponseStatus.UNSUPPORTED);
    }

    /**
     * 刷新授权的api
     *
     * @return url
     */
    default String refresh() {
        throw new AuthException(AuthResponseStatus.UNSUPPORTED);
    }

    /**
     * 获取Source的字符串名字
     *
     * @return name
     */
    default String getName() {
        if (this instanceof Enum) {
            return String.valueOf(this);
        }
        return this.getClass().getSimpleName();
    }
}
