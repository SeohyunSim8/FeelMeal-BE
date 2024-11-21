package feelmeal.global.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Constant {
    public enum Status {
        ACTIVE, DELETE
    }

    public enum Category {
        KOREAN, JAPANESE, CHINESE, AMERICAN
    }

    public enum Emotion {
        HAPPY, SAD, ANGRY, NERVOUS
    }
}
