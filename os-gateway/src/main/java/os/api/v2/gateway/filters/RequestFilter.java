// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-01 21:35
// +----------------------------------------------------------------------
package os.api.v2.gateway.filters;

import com.alibaba.fastjson2.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import os.api.v2.common.base.common.Result;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * os.api.v2.gateway.filters.RequestFilter
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-01 21:35
 */
@Component
public class RequestFilter implements GlobalFilter, Ordered {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected StringRedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        if (this.toLimit(exchange.getRequest())) {
//            return this.callLimit(exchange.getResponse());
//        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 判断是否频率过快
     *
     * @param request ServerHttpRequest
     * @return boolean
     */
    private boolean toLimit(ServerHttpRequest request) {
        String token = request.getHeaders().getFirst("Token");
        String strTime = request.getHeaders().getFirst("Timestamp");
        assert strTime != null;
        long longTime = Long.parseLong(strTime);
        long now = new Date().getTime();
        return now - longTime < 3000;
    }

    /**
     * 返回请求限制
     *
     * @param response ServerHttpResponse
     * @return Mono<Void>
     */
    private Mono<Void> callLimit(ServerHttpResponse response) {
        Result<Object> result = new Result<>(Result.FAILURE, "请求频率过快");
        String resultToJson = JSON.toJSONString(result);
        byte[] resultToJsonBytes = resultToJson.getBytes(StandardCharsets.UTF_8);
        DataBuffer dataBuffer = response.bufferFactory().wrap(resultToJsonBytes);
        response.setStatusCode(HttpStatus.OK);
        return response.writeWith(Mono.just(dataBuffer));
    }
}
