package br.com.consulta.viacep.util;

import java.lang.reflect.Array;
import java.util.List;

public class States {

    //SUDESTE
    private static final String ESPIRITO_SANTO = "ES";
    private static final String MINAS_GERAIS = "MG";
    private static final String RIO_DE_JANEIRO = "RJ";
    private static final String SAO_PAULO = "SP";

    //CENTRO-OESTE
    private static final String GOIAS = "GO";
    private static final String MATO_GROSSO = "MT";
    private static final String MATO_GROSSO_DO_SUL = "MS";
    private static final String DISTRITO_FEDERAL = "DF";

    //NORDESTE
    private static final String ALAGOAS = "AL";
    private static final String BAHIA = "BA";
    private static final String CEARA = "CE";
    private static final String MARANHAO = "MA";
    private static final String PARAIBA = "PB";
    private static final String PERNANBUCO = "PE";
    private static final String PIAUI = "PI";
    private static final String RIO_GRANDE_DO_NORTE = "RN";
    private static final String SERGIPE = "SE";

    //SUL
    private static final String PARANA = "PR";
    private static final String RIO_GRANDE_DO_SUL = "RS";
    private static final String SANTA_CATARINA = "SC";

    //NORTE
    private static final String ACRE = "AC";
    private static final String AMAPA = "AP";
    private static final String AMAZONAS = "AM";
    private static final String PARA = "PA";
    private static final String RONDONIA = "RO";
    private static final String RORAIMA = "RR";
    private static final String TOCANTINS = "TO";

    public static List<String> listStates() {

        String[] strings = {ESPIRITO_SANTO, MINAS_GERAIS, RIO_DE_JANEIRO, SAO_PAULO,
                GOIAS, MATO_GROSSO, MATO_GROSSO_DO_SUL, DISTRITO_FEDERAL,
                ALAGOAS, BAHIA, CEARA, MARANHAO, PARAIBA, PERNANBUCO, PIAUI, RIO_GRANDE_DO_NORTE, SERGIPE,
                PARANA, RIO_GRANDE_DO_SUL, SANTA_CATARINA,
                ACRE, AMAPA, AMAZONAS, PARA, RONDONIA, RORAIMA, TOCANTINS
        };

        return List.of(strings);
    }

    public static String compareTo(String states) {

        String result = null;
        if (states.equals(ESPIRITO_SANTO) || states.equals(MINAS_GERAIS) || states.equals(RIO_DE_JANEIRO) || states.equals(SAO_PAULO))
            result = "7,85";
        if (states.equals(GOIAS) || states.equals(MATO_GROSSO) || states.equals(MATO_GROSSO_DO_SUL) || states.equals(DISTRITO_FEDERAL))
            result = "12,50";
        if (states.equals(ALAGOAS) || states.equals(BAHIA) || states.equals(CEARA) || states.equals(MARANHAO) || states.equals(PARAIBA) || states.equals(PERNANBUCO) || states.equals(PIAUI) || states.equals(RIO_GRANDE_DO_NORTE) || states.equals(SERGIPE))
            result = "15,98";
        if (states.equals(PARANA) || states.equals(RIO_GRANDE_DO_SUL) || states.equals(SANTA_CATARINA))
            result = "17,30";
        if (states.equals(ACRE) || states.equals(AMAPA) || states.equals(AMAZONAS) || states.equals(PARA) || states.equals(RONDONIA) || states.equals(RORAIMA) || states.equals(TOCANTINS) )
            result = "20,83";

        return result;
    }

}
