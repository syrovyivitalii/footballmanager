package lviv.syrovyi.footballManager.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorCode {
    //400
    ILLEGAL_PARAM_TYPE("400-001",
            "Illegal parameter type",
            400),

    //403
    FORBIDDEN(
            "403",
            "Forbidden",
            403
    ),

    // 404
    TEAM_NOT_FOUND(
            "404-001",
            "Team not found",
            404
    ),
    PLAYER_NOT_FOUND(
            "404-002",
            "Player not found",
            404
    ),
    TEAM_ALREADY_EXISTS(
            "404-003",
            "Team already exists",
            404
    ),
    PLAYER_ALREADY_EXISTS(
            "404-004",
            "Player already exists",
            404
    ),

    //500
    UNKNOWN_SERVER_ERROR("500",
            "Unknown server error",
            500),;



    private final Data data;

    ErrorCode(String code, String description, int httpResponseCode) {
        this.data = new Data(code, description, httpResponseCode);
    }

    @Getter
    public static final class Data {
        private final String code;

        @Setter
        private String description;
        private final int httpResponseCode;
        @Setter
        private String label;

        public Data(String code, String description, int httpResponseCode) {
            this.code = code;
            this.description = description;
            this.httpResponseCode = httpResponseCode;
        }
    }
}
