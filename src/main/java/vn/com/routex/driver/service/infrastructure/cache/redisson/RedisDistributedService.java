package vn.com.routex.driver.service.infrastructure.cache.redisson;

public interface RedisDistributedService {
    RedisDistributedLocker getDistributedLock(String lockKey);
}
