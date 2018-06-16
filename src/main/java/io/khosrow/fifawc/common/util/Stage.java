package io.khosrow.fifawc.common.util;

import lombok.Getter;

public enum Stage {
    GROUPS("Group Phase"),

    ROUND_SIXTEEN("Round of 16"),

    QUARTER_FINALS("Quarter-finals"),

    SEMI_FINALS("Semi-finals"),

    PLAYOFF("Play-off for third place"),

    FINAL("Final"),

    NULL("Null");

    @Getter
    private final String title;

    private Stage(final String title) {
        this.title = title;
    }

    public static Stage of(String stage) {
        for (Stage s : values()) {
            if (s.name().equals(stage)) {
                return s;
            }
        }

        return null;
    }
}
