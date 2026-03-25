package vn.com.routex.driver.service.domain.shared.port;

/**
 * Strategy for generating IDs (DIP-friendly, testable).
 */
public interface IdGeneratorPort {
    String newId();
}
