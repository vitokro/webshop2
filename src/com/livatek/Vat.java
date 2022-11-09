package com.livatek;

import java.math.BigDecimal;

public enum Vat {

    DK {
        @Override
        public BigDecimal getVatByType(Type type) {
            return scandVat;
        }
    },
    NO {
        @Override
        public BigDecimal getVatByType(Type type) {
            return scandVat;
        }
    },
    SE {
        @Override
        public BigDecimal getVatByType(Type type) {
            return scandVat;
        }
    },
    GB {
        @Override
        public BigDecimal getVatByType(Type type) {
            return gbVat;
        }
    },
    DE {
        @Override
        public BigDecimal getVatByType(Type type) {
            if (type == Type.BOOK) {
                return deBookVat;
            }
            if (type == Type.ONLINE) {
                return deOnlineVat;
            }
            return BigDecimal.ZERO;
        }
    },
    ;

    private static BigDecimal scandVat = new BigDecimal("1.25");
    private static BigDecimal gbVat = new BigDecimal("1.2");
    private static BigDecimal deBookVat = new BigDecimal("1.12");
    private static BigDecimal deOnlineVat = new BigDecimal("1.19");

    public static BigDecimal of(String vat, Type type) {
        if (vat == null) {
            return BigDecimal.ONE;
        } else {
            return valueOf(vat).getVatByType(type);
        }
    }

    abstract BigDecimal getVatByType(Type type);
}
