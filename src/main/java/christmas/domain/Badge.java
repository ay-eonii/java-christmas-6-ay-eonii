package christmas.domain;

import christmas.domain.benefit.CustomBenefit;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);

    private final String badge;
    private final int standard;

    Badge(String badge, int standard) {
        this.badge = badge;
        this.standard = standard;
    }

    public static String determineBadge(CustomBenefit customBenefit) {
        return Arrays.stream(values())
                .filter(badge -> badge.standard <= customBenefit.getTotalBenefit())
                .findFirst()
                .orElse(NONE)
                .badge;
    }
}
