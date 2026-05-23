package vn.com.routex.driver.service.domain.outbox;

public enum OutBoxEventStatus {
    PENDING,
    PROCESSED,
    COMPLETED,
    FAILED
}
