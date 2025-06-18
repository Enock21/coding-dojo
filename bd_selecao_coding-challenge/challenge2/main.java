class Solucao{
    public static String solucao(int segundos){
        if(segundos == 0){
            return "now";
        }

        String retorno = "";

        int diasEm1Ano = 365;
        int horasEm1Dia = 24;
        int minutosEm1Hora = 60;
        int segundosEm1Min = 60;

        int segundosEm1Ano = diasEm1Ano * horasEm1Dia * minutosEm1Hora * segundosEm1Min;
        int segundosEm1Dia = horasEm1Dia * minutosEm1Hora * segundosEm1Min;
        int segundosEm1Hora = minutosEm1Hora * segundosEm1Min;


        int valorAtual;
        while(segundos != 0){
            if (segundos / segundosEm1Ano >= 1){
                valorAtual = segundos / segundosEm1Ano;
                segundos = segundos % segundosEm1Ano;
                retorno = retorno + valorAtual + " year";
                //guarda anos
            }else if (segundos / segundosEm1Dia >= 1){
                valorAtual = segundos / segundosEm1Dia;
                segundos = segundos % segundosEm1Dia;
                retorno = retorno + valorAtual + " day";
                //guarda dias
            }else if (segundos / segundosEm1Hora >= 1){
                valorAtual = segundos / segundosEm1Hora;
                segundos = segundos % segundosEm1Hora;
                retorno = retorno + valorAtual + " hour";
                //guarda horas
            }
            else if ((float) segundos / (segundosEm1Min) >= 1){
                valorAtual = segundos / segundosEm1Min;
                segundos = segundos % segundosEm1Min;
                retorno = retorno + valorAtual + " minute";
                //guarda minutos
            }else{
                valorAtual = segundos;
                segundos = segundos % segundos;
                retorno = retorno + valorAtual + " second";
                //guarda segundos
            }
            if (valorAtual > 1) retorno = retorno + "s";
            if (segundos > 0) retorno = retorno + ", ";
        }
        return retorno;
    }
}

class Main{
    public static void main(String[] args){
        //1 ano = 31.536.000 segundos
        //15731080 = 182 days, 1 hour, 44 minutes and 40 seconds
        System.out.println(Solucao.solucao(15731080));
    }
}