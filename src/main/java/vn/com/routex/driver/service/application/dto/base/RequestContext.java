package vn.com.routex.driver.service.application.dto.base;

import lombok.Builder;

@Builder
public record RequestContext(
        String requestId,
        String requestDateTime,
        String channel
) {
}
