package com.robo.model;

public enum OrientationEnum {
    NORTH("N", "E", "W"),
    SOUTH("S", "W", "E"),
    EAST("E", "S", "N"),
    WEST("W", "N", "S");

    private String sigla;
    private String right;
    private String left;

    private OrientationEnum(String sigla, String right, String left) {
        this.sigla = sigla;
        this.right = right;
        this.left = left;
    }

    public String getSigla() {
        return sigla;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }
    public OrientationEnum getLeftOrientationBy(String orientation) {
        for (OrientationEnum orientationEnum : OrientationEnum.values()) {
            if (orientationEnum.getRight().equals(orientation)) {
                return orientationEnum;
            }
        }
        return null;
    }

    public OrientationEnum getRightOrientationBy(String orientation) {
        for (OrientationEnum orientationEnum : OrientationEnum.values()) {
            if (orientationEnum.getLeft().equals(orientation)) {
                return orientationEnum;
            }
        }
        return null;
    }

}
